import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "ee.veikokaap.idea.plugins"
version = "0.1-SNAPSHOT"

repositories {
  mavenCentral()
}

plugins {
  id("java")
  id("org.jetbrains.intellij") version "0.4.9"
  kotlin("jvm") version "1.3.41" apply false
}

dependencies {
  compile(kotlin("stdlib-jdk8"))
  testCompile("junit:junit:4.12")
}

val javaVersion = JavaVersion.VERSION_1_8
val kotlinVersion = "1.3"

tasks.withType(KotlinCompile::class.java).all {
  sourceCompatibility = javaVersion.name
  targetCompatibility = javaVersion.name
  
  kotlinOptions {
    jvmTarget = javaVersion.name
    apiVersion = kotlinVersion
    languageVersion = kotlinVersion
  }
}

java {
  sourceCompatibility = javaVersion
  targetCompatibility = javaVersion
}

intellij.version = "2019.1.2"
