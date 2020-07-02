plugins {

    kotlin("jvm") version "1.3.61"
    id("ru.tim.dependency-management") version "0.0.1"

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

