pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NewsToDay"
include(":app")
include(":core:domain:newsapi:api")
include(":core:domain:newsapi:impl")
include(":core:domain:newsapi:di")
include(":features:article:api")
include(":features:article:impl")
include(":features:article:di")
include(":features:home:api")
include(":features:home:impl")
include(":features:home:di")
include(":features:onboarding:api")
include(":features:onboarding:di")
include(":features:onboarding:impl")

include(":core:ui")
include(":core:data:api")
include(":core:data:impl")
include(":core:data:di")
include(":core:navigation")
include(":features:profile:api")
include(":features:profile:impl")
include(":features:profile:di")
