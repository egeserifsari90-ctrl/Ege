package com.egestore.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(0xFFF7F8FA.toInt())
        }
        val title = TextView(this).apply {
            text = "EgeStore"
            textSize = 32f
            setTypeface(null, Typeface.BOLD)
            setTextColor(0xFF18243A.toInt())
            gravity = Gravity.CENTER
        }
        val note = TextView(this).apply {
            text = "Alışveriş uygulaması başlangıç sürümü\n\nÜrün kataloğu, sepet, ödeme ve sipariş takibi henüz sunucuya bağlanmadı."
            textSize = 16f
            setTextColor(0xFF39465C.toInt())
            gravity = Gravity.CENTER
            setPadding(0, 24, 0, 0)
        }
        root.addView(title, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        root.addView(note, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        setContentView(root)
    }
}
