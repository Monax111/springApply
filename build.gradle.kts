plugins {

    kotlin("jvm") version PluginDefaultVersions.kotlin
    id("io.spring.dependency-management") version PluginDefaultVersions.dependencyManagement

    id("ru.tim.dependency-management")
}

group = "com.extimample"
version = "0.0.1-SNAPSHOT"

allprojects {
    repositories {
        jcenter()
        mavenCentral()
        gradlePluginPortal()
    }
}

subprojects {
    apply(plugin = "org.gradle.java")
    apply(plugin = "io.spring.dependency-management")

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR5")
        }
    }

}
