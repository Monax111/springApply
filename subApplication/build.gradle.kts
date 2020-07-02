plugins {
    kotlin("jvm")
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("org.springframework.boot") version "2.3.0.RELEASE"

    id("jacoco")
    id("org.sonarqube") version "2.8"

}


dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR5")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}


