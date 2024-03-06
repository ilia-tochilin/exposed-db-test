plugins {
    kotlin("jvm") version "1.9.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val exposedVersion = "0.48.0"

dependencies {
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
//    implementation("org.jetbrains.exposed:exposed-crypt:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

//    implementation "org.postgresql:postgresql:"

    implementation("org.postgresql:postgresql:42.2.27")


//    implementation("org.jetbrains.exposed:exposed-jodatime:$exposedVersion")
    // or
//    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
    // or
//    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")

//    implementation("org.jetbrains.exposed:exposed-json:$exposedVersion")
//    implementation("org.jetbrains.exposed:exposed-money:$exposedVersion")
//    implementation("org.jetbrains.exposed:exposed-spring-boot-starter:$exposedVersion")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}