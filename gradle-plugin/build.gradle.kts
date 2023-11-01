plugins {
    kotlin("jvm") version "1.8.0"
//    application
    `java-gradle-plugin`
}

group = "org.dartrhevan.fieldaccessor"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("hello") {
            id = "com.example.hello"
            implementationClass = "org.dartrhevan.fieldaccessor.GreetingPlugin"
        }
//        create("goodbye") {
//            id = "com.example.goodbye"
//            implementationClass = "com.example.goodbye.GoodbyePlugin"
//        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(kotlin("stdlib-jdk8"))
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