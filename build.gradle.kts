plugins {


    id("ru.tim.dependency-management") version "0.0.1"
    kotlin("jvm") version "1.3.61"

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

