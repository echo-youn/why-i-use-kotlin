plugins {
    java
//    kotlin("jvm") version "1.9.0"
}

group = "com.nexon.liveapi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
}

//kotlin {
//    jvmToolchain(17)
//}
