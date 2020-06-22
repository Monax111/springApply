pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}
buildscript {
    buildscript {
        repositories {
            mavenLocal()
        }
        val version = "0.0.1"

        dependencies {

            classpath("ru.tim:custom-dependency-management-gradle-plugin:${version}")
            classpath("ru.tim:custom-dependency-management-gradle-plugin:${version}:sources")
        }
    }

}

rootProject.name = "demo"

include("subApplication")
