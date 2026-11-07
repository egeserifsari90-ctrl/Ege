// EgeStore native Android starter.
// Package: com.egestore.app
// This is a locally usable storefront shell, not a production commerce backend.

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories { google(); mavenCentral() }
}
rootProject.name = "EgeStore"
include(":app")
