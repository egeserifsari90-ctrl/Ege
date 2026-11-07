package com.egestore.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.*
import android.text.InputType
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : Activity() {
    private val prefs by lazy { getSharedPreferences("egestore", MODE_PRIVATE) }
    private val products = mutableListOf<Product>()
    private val cart = linkedMapOf<String, Int>()
    private lateinit var body: LinearLayout
    data class Product(val id: String, val name: String, val price: Double, val stock: Int, val description: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadProducts()
        if (products.isEmpty()) { products += Product("sample-1", "Örnek Ürün", 249.90, 10, "EgeStore demo ürünü."); saveProducts() }
        showHome()
    }
    private fun txt(value: String, size: Float = 16f, bold: Boolean = false) = TextView(this).apply {
        text = value; textSize = size; setTextColor(Color.rgb(30,41,59)); if (bold) setTypeface(null, Typeface.BOLD); setPadding(8,8,8,8)
    }
    private fun btn(label: String, action: () -> Unit) = Button(this).apply { text = label; setOnClickListener { action() } }
    private fun input(h: String, type: Int = InputType.TYPE_CLASS_TEXT) = EditText(this).apply { hint = h; inputType = type }
    private fun screen(title: String) {
        val root = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL; setPadding(16,8,16,12); setBackgroundColor(Color.rgb(247,248,250)) }
        val header = LinearLayout(this).apply { gravity = Gravity.CENTER_VERTICAL }
        header.addView(txt("EgeStore",24f,true), LinearLayout.LayoutParams(0,-2,1f)); header.addView(btn("Ana sayfa") { showHome() }); root.addView(header)
        root.addView(txt(title,20f,true)); val scroll = ScrollView(this)
        body = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }; scroll.addView(body)
        root.addView(scroll, LinearLayout.LayoutParams(-1,0,1f)); setContentView(root)
    }
    private fun showHome() {
        screen("Ürün kataloğu"); body.addView(txt("EgeStore'a hoş geldiniz",18f,true)); body.addView(btn("Sepetim (${cart.values.sum()})") { showCart() })
        products.forEach { p ->
            val card = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL; setPadding(12,8,12,8); setBackgroundColor(Color.WHITE) }
            card.addView(txt(p.name,18f,true)); card.addView(txt(p.description)); card.addView(txt("₺" + "%.2f".format(p.price) + " • Stok: " + p.stock))
            card.addView(btn("Sepete ekle") { val count = cart[p.id] ?: 0; if (count >= p.stock) toast("Stok yetersiz") else { cart[p.id] = count + 1; showHome() } })
            body.addView(card, LinearLayout.LayoutParams(-1,-2).apply { bottomMargin = 10 })
        }
        body.addView(btn("Ürün ekle") { showAddProduct() }); body.addView(btn("Ürünleri yönet") { showAdmin() })
        body.addView(txt("Yerel prototip: gerçek ödeme, çevrim içi sipariş ve cihazlar arası senkronizasyon yoktur.",12f))
    }
    private fun showAddProduct() {
        screen("Yeni ürün"); val name = input("Ürün adı"); val price = input("Fiyat (TL)",InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL)
        val stock = input("Stok",InputType.TYPE_CLASS_NUMBER); val description = input("Açıklama"); listOf(name,price,stock,description).forEach { body.addView(it) }
        body.addView(btn("Kaydet") {
            val n = name.text.toString().trim(); val p = price.text.toString().replace(',', '.').toDoubleOrNull(); val s = stock.text.toString().toIntOrNull()
            if (n.isBlank() || p == null || p < 0 || s == null || s < 0) toast("Bilgileri kontrol edin")
            else { products += Product("p" + System.currentTimeMillis(),n,p,s,description.text.toString()); saveProducts(); toast("Ürün kaydedildi"); showHome() }
        })
    }
    private fun showAdmin() { screen("Ürün yönetimi"); products.toList().forEach { p ->
        val row = LinearLayout(this).apply { gravity = Gravity.CENTER_VERTICAL }; row.addView(txt(p.name), LinearLayout.LayoutParams(0,-2,1f))
        row.addView(btn("Sil") { products.removeAll { it.id == p.id }; cart.remove(p.id); saveProducts(); showAdmin() }); body.addView(row)
    } }
    private fun showCart() { screen("Alışveriş sepeti"); var total = 0.0
        cart.forEach { (id,qty) -> val p = products.find { it.id == id } ?: return@forEach; total += p.price * qty; body.addView(txt("${p.name} × $qty — ₺" + "%.2f".format(p.price * qty))) }
        body.addView(txt("Toplam: ₺" + "%.2f".format(total),20f,true))
        body.addView(btn("Demo siparişi oluştur") {
            if (cart.isEmpty()) { toast("Sepet boş"); return@btn }
            cart.forEach { (id,qty) -> val i = products.indexOfFirst { it.id == id }; if (i >= 0) products[i] = products[i].copy(stock = (products[i].stock - qty).coerceAtLeast(0)) }
            cart.clear(); saveProducts(); toast("Demo sipariş oluşturuldu; ödeme alınmadı."); showHome()
        })
    }
    private fun saveProducts() { val a = JSONArray(); products.forEach { p -> a.put(JSONObject().put("id",p.id).put("name",p.name).put("price",p.price).put("stock",p.stock).put("description",p.description)) }; prefs.edit().putString("products",a.toString()).apply() }
    private fun loadProducts() { val a = runCatching { JSONArray(prefs.getString("products","[]")) }.getOrDefault(JSONArray()); for (i in 0 until a.length()) { val p = a.optJSONObject(i) ?: continue; products += Product(p.optString("id"),p.optString("name"),p.optDouble("price"),p.optInt("stock"),p.optString("description")) } }
    private fun toast(s: String) = Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
}