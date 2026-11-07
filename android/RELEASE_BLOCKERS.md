# EgeStore release status

## Implemented prototype
- Native Android storefront UI.
- Local product catalog with name, description, price and stock.
- Add and delete products.
- Local cart and demo order flow.
- Product data persisted on this device.

## Not production-ready
This is a single-device prototype. It has no server, customer accounts, shared inventory, product image upload, real payment processing, fulfillment, delivery tracking, order notifications, or remote admin. Demo order creation does not charge a payment method. Do not accept real customer orders or represent this as a production store.

## Release requirements
A signed release AAB requires an owner-controlled upload key and these GitHub Actions secrets:
- ANDROID_KEYSTORE_BASE64
- ANDROID_KEYSTORE_PASSWORD
- ANDROID_KEY_ALIAS
- ANDROID_KEY_PASSWORD

Play Console upload additionally requires:
- PLAY_STORE_SERVICE_ACCOUNT_JSON secret
- PLAY_PACKAGE_NAME variable set to com.egestore.app
- An eligible Play Console account owner to register the app and authorize the service account.

Never commit keys, credentials, payment secrets, or customer information to Git. The Debug APK is not a Play production release.
