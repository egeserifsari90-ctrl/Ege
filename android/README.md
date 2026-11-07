# Android packaging

This folder is reserved for the native Android application. The current website prototype is not a native Android app and should not be submitted to Google Play as though it were one.

Before producing a release AAB:
1. Implement a native Android app (or a suitable trusted web wrapper with a compliant app experience).
2. Add a stable application ID, launcher icon, versioning, network security configuration, and app links as appropriate.
3. Connect to a production backend with authenticated owner/admin access.
4. Implement server-side catalog, inventory, orders, secure payment provider, notifications, and courier tracking.
5. Add and test privacy controls and all Play Console disclosures.
6. Generate a signed Android App Bundle with a protected upload key.

Never store API secrets, keystores, or passwords in source control.
