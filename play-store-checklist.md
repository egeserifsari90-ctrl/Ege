# Google Play release checklist

## 1. Developer account
- [ ] Sign in to Google Play Console with the account that will own the app.
- [ ] Complete identity and developer-account verification.
- [ ] Pay the Play Console registration fee if required.
- [ ] Confirm account type and contact details.
- [ ] Review current testing requirements shown in Play Console for this account.

## 2. App identity and build
- [ ] Choose a unique Android application ID (package name); it cannot be casually changed after publishing.
- [ ] Create a signed Android App Bundle (.aab) using a protected upload key.
- [ ] Set versionCode and versionName.
- [ ] Test install, upgrades, offline/error states, permissions, and supported screen sizes.
- [ ] Keep signing keys and passwords private; never commit them to GitHub.

## 3. Store presence
- [ ] App name: EgeStore.
- [ ] Prepare short and full descriptions.
- [ ] Upload a 512×512 app icon and required screenshots.
- [ ] Provide a feature graphic if requested.
- [ ] Set category, support email, and support website.
- [ ] Declare ads accurately.

## 4. Privacy, safety, and commerce
- [ ] Publish a publicly accessible privacy policy matching the actual app behavior.
- [ ] Complete Data safety accurately; disclose every SDK and data flow.
- [ ] Complete app access instructions if login is required.
- [ ] Complete content rating and target-audience declarations accurately.
- [ ] Provide account deletion flow if users can create accounts and applicable policy requires it.
- [ ] For physical goods, implement a compliant payment flow suitable for physical purchases.
- [ ] Publish clear shipping, cancellation, refund, warranty, and contact information.
- [ ] Implement secure server-side order management; do not rely on browser-local storage.
- [ ] Verify applicable consumer, tax, privacy, and distance-sales obligations before accepting orders.

## 5. Testing and submission
- [ ] Upload the AAB to an internal testing track.
- [ ] Test on real Android devices.
- [ ] Fix crashes, broken checkout, image upload, and accessibility issues.
- [ ] Complete all Play Console declarations.
- [ ] Submit the release for Google's review.
- [ ] Publish only after Google approves it.

## Important
This repository does not have Play Console credentials and cannot submit or publish the app on its own. The owner must perform authenticated Play Console steps. Play Console requirements can change; follow the current console guidance.
