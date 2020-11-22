import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("org.springframework.boot") version "2.3.5.RELEASE"
    kotlin("plugin.spring") version "1.3.72"
    id( "com.bmuschko.docker-spring-boot-application") version "6.6.1"
}

group = "com.extimample"
version = "0.0.1-SNAPSHOT"


repositories {
    jcenter()
    mavenCentral()
}


dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.RELEASE")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter")
    implementation("org.springframework:spring-context-support")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("io.springfox:springfox-boot-starter:3.0.0")

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("io.github.microutils:kotlin-logging:1.4.9")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j:1.3.2")
    implementation("io.projectreactor.addons:reactor-extra")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.data:spring-data-r2dbc:1.1.2.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("io.r2dbc:r2dbc-postgresql:0.8.4.RELEASE")

    implementation("com.github.ben-manes.caffeine:caffeine:2.8.6")

    implementation("org.redisson:redisson:3.13.6")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.testcontainers:testcontainers:1.15.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.assertj:assertj-core:3.10.0")
    testImplementation( "org.mockito:mockito-core:2.23.0")
    testImplementation("org.mockito:mockito-junit-jupiter:2.23.0")
    testImplementation("com.nhaarman:mockito-kotlin:1.6.0")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.2.5")
    testImplementation("io.kotest:kotest-assertions-core-jvm:4.2.5")
    testImplementation("io.kotest:kotest-property-jvm:4.2.5")

    testImplementation("io.kotest:kotest-extensions-testcontainers:4.2.5")
    testImplementation("org.testcontainers:postgresql:1.15.0")
    testImplementation("net.java.dev.jna:jna:5.2.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform{
        systemProperty("image",tasks.dockerBuildImage.get().images.get().first())
    }
    dependsOn(tasks.dockerBuildImage)
}

docker{
    springBootApplication {
        baseImage.set("openjdk:11-jre-slim")
        ports.set(setOf(8080))
        images.set(setOf("demo:local"))
    }
}