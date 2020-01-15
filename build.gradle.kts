
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.intellij") version "0.4.10"
    kotlin("jvm") version "1.3.41"
    kotlin("kapt") version "1.3.41"
}

group = "Alf"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("junit:junit:4.12")
    implementation("com.google.dagger:dagger:2.24")
    kapt("com.google.dagger:dagger-compiler:2.24")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    setPlugins("Kotlin")
    version = "2019.2"
}
tasks.getByName<org.jetbrains.intellij.tasks.PatchPluginXmlTask>("patchPluginXml") {
    changeNotes("""
      Add change notes here.<br>
      <em>most HTML tags may be used</em>""")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}