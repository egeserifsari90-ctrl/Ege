# EgeStore release readiness

## Current prototype
The Android app currently includes a local product catalogue, local product creation/deletion, a local cart and demo checkout. Product data is stored on the device.

## Important limitations
This is not yet a production e-commerce service. It has no customer/admin authentication, cloud database, shared inventory, payment gateway, refunds, shipping integration, courier tracking, or real order notifications. Demo checkout does not collect money and must not be described as a real purchase.

## What a production release still requires
1. Choose and deploy a secure backend and database.
2. Add customer accounts, admin authorization, server-side inventory and order processing.
3. Integrate a supported payment provider using its official checkout/API; never store card data in the app.
4. Add shipping, returns, customer support and order notification workflows.
5. Complete privacy policy, data-safety declarations, content rating, target audience and all Play Console app-content declarations.
6. Perform security, device compatibility and end-to-end payment/order tests.

## Signed Android App Bundle
The signed release workflow expects owner-managed GitHub Actions secrets:
- ANDROID_KEYSTORE_BASE64
- ANDROID_KEYSTORE_PASSWORD
- ANDROID_KEY_ALIAS
- ANDROID_KEY_PASSWORD

For optional Google Play internal-track upload it additionally expects:
- PLAY_STORE_SERVICE_ACCOUNT_JSON
- repository variable PLAY_PACKAGE_NAME=com.egestore.app

Do not commit signing keystores or service-account credentials. The Play service account must be explicitly authorized in the publisher's Play Console project. Upload is disabled by default.

A verified Play Console account, eligible account owner, app registration and required review declarations are still required. A guardian/eligible adult must own and administer the publisher account where age rules require it.
