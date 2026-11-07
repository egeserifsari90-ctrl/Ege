# EgeStore Android Release Setup

GitHub username provided for Play Console display/account lookup: **Ege02oyuncu**. A Google Play account cannot be registered or accessed based on a username alone; the account owner must authenticate to Play Console and grant access.

## Android project
- Application ID: `com.egestore.app`
- Gradle wrapper scripts and wrapper properties are present.
- The wrapper JAR is fetched from the Gradle distribution and must be generated/committed by the Gradle wrapper task or created from a trusted official Gradle distribution; do not add an unverified binary copied from an arbitrary repository.
- Native app is currently a minimal shell, not a complete shopping application.

## Signing
Signing is wired to environment variables in Gradle. Generate an upload keystore under your own control using a trusted local JDK / Android Studio environment, then add the following GitHub Actions secrets:
- `ANDROID_KEYSTORE_BASE64`
- `ANDROID_KEYSTORE_PASSWORD`
- `ANDROID_KEY_ALIAS`
- `ANDROID_KEY_PASSWORD`

Do not send the keystore or passwords in chat and never commit them to the repository. Keep a secure offline backup. If you lose the upload key, app updates may be blocked.

## Play Console
Create the app in the Play Console account you control with package name `com.egestore.app`. Configure a service account with access limited to this app, then add:
- Secret `PLAY_STORE_SERVICE_ACCOUNT_JSON`
- Repository variable `PLAY_PACKAGE_NAME` = `com.egestore.app`

The workflow can upload a draft to the internal testing track after the signing and Play secrets exist. It will not publish to production.

## Current truth
No signed AAB was produced during repository editing. No keystore was created or saved. No Play Console app registration or upload was performed. This repository is not yet a production-ready e-commerce application.
