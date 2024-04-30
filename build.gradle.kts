import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.allopen") version "1.9.22"
    kotlin("plugin.noarg") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22" apply false
    id("org.springframework.boot") version "3.2.3" apply false
    id("io.spring.dependency-management") version "1.1.4" apply false
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}


noArg {
    annotation("com.my.Annotation")
    invokeInitializers = true
}

allprojects {
    group = "jung.demo"
    version = "0.0.1-SNAPSHOT"
    repositories {
        mavenCentral()
    }
}

repositories {
    mavenCentral()
}
subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        //jpa
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-mustache")
        implementation("org.springframework.boot:spring-boot-devtools")

        compileOnly("org.projectlombok:lombok:1.18.30")
        //MySQL
        runtimeOnly("mysql:mysql-connector-java:8.0.32")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation(kotlin("test"))
    }

    tasks.getByName("bootJar") {
        enabled = true
    }

    tasks.getByName("jar"){
        enabled = false
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
