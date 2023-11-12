plugins {
    id("java-library")
    kotlin("jvm") version "1.8.0"
}

group = "org.dartrhevan.fieldaccessor"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.apache.velocity/velocity
    implementation("org.apache.velocity:velocity:1.7")
    implementation("org.apache.velocity:velocity-tools:2.0")


    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    api(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}