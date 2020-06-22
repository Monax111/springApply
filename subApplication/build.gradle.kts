plugins {
    java
    kotlin("jvm")
    id("org.springframework.boot") version PluginDefaultVersions.spring

    id("jacoco")
    id("org.sonarqube") version PluginDefaultVersions.sonarqube

}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.cloud:spring-cloud-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}


dependencies {
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-web-services")
}

