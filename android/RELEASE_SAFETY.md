# EgeStore release status — verified blockers

A production release must never bypass missing app code, signing, credentials, security, privacy declarations, or Play review.

The current repository contains documentation and an Android release workflow only. There is no native Android Gradle project or production backend. The workflow will fail intentionally at its project validation step until those are implemented.

Do not remove validation checks or fake a successful build/upload. They protect the release from submitting an empty or non-functional package.

## Practical next engineering phase
- Create the actual Android app module and Gradle wrapper.
- Implement the user-facing storefront and owner/admin workflow.
- Connect a secure production API for catalog, inventory, orders, payments, shipping and notifications.
- Add privacy controls and accurate disclosures based on actual SDK/data flows.
- Generate a dedicated upload keystore and store all credentials only in GitHub Actions Secrets.
- Upload to internal testing, verify on physical devices, then proceed through Play Console review.

The signed-AAB workflow should remain gated until all above requirements are met.
