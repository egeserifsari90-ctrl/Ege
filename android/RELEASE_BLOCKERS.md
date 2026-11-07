# EgeStore native Android release — blocking items

## Verified repository state
The repository currently contains release documentation and a workflow only. It does not contain an Android Gradle project, a Gradle wrapper, an Android manifest, or an application module.

The browser prototype is local-browser-only. It is not a production commerce app and must not be packaged or submitted as if it were one.

## Why the release workflow will stop
The workflow checks for `android/gradlew` and `android/app/build.gradle(.kts)`; neither exists. No valid signed AAB can currently be built.

## Required product work before release
1. Implement the actual storefront UI and native Android container.
2. Choose a permanent application ID and versioning scheme.
3. Build authenticated server-side catalog, inventory, and order services.
4. Integrate compliant payments for physical goods, shipping, returns, and customer support.
5. Implement authenticated owner/admin tools and order notifications.
6. Add privacy controls and accurate Play Console disclosures.
7. Test on physical Android devices and resolve release blockers.

## Required owner-controlled GitHub Actions secrets
After creating a real Android project and generating its upload keystore, add:
- `ANDROID_KEYSTORE_BASE64`
- `ANDROID_KEYSTORE_PASSWORD`
- `ANDROID_KEY_ALIAS`
- `ANDROID_KEY_PASSWORD`
- `PLAY_STORE_SERVICE_ACCOUNT_JSON`

Add repository variable:
- `PLAY_PACKAGE_NAME`: exact Android application ID registered in Play Console.

Never commit keystores, passwords, service-account JSON, payment credentials, or customer data to Git.

## Safe release sequence
Run the workflow against the internal testing track first. Review the uploaded draft in Play Console and test with internal testers. Do not select production until the app, declarations, and operational services are ready.

## Current status
No signed AAB has been built, no Play Console upload has occurred, and no app has been submitted for Google review.
