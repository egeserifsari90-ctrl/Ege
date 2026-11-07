# Build note

This starter defines a minimal native Android launcher activity using Android Gradle Plugin and Kotlin. The Gradle wrapper JAR and executable script are not checked in yet; they must be generated with a trusted Gradle installation using `gradle wrapper --gradle-version 8.9`, then committed.

Release signing is not configured in the module yet. Before a signed release is possible, wire Gradle signingConfig to the protected environment variables from GitHub Actions and confirm a real upload keystore is available. Never create a publicly shared or hard-coded signing password.
