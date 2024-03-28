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
include(":core:data:appconfig:impl")
include(":core:data:appconfig:di")
include(":core:data:appconfig:api")
include(":features:home:api")
include(":features:home:impl")
include(":features:home:di")
include(":core:ui")
