plugins {
    kotlin("jvm") version "1.8.0"
    id("kotlin-kapt")
    id("java-library")
}

group = "org.dartrhevan.fieldaccessor"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api(project(":core"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")


    kapt("com.google.auto.service", "auto-service", "1.0")
    annotationProcessor("com.google.auto.service", "auto-service", "1.0")
    compileOnly("com.google.auto.service", "auto-service", "1.0")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}