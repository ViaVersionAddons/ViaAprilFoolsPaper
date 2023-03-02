import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.7.22"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("maven-publish")
    id("io.papermc.paperweight.userdev") version "1.4.1"
    id("xyz.jpenilla.run-paper") version "2.0.1"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
}

group = "net.satellyte"
version = "1.0.0"
description = "My Kotlin Paper Plugin"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://maven.lenni0451.net/releases")
    maven("https://repo.viaversion.com/")
}

dependencies {
    implementation(kotlin("stdlib"))
    paperDevBundle("1.19.2-R0.1-SNAPSHOT")
    implementation("net.axay:kspigot:1.19.0")
    compileOnly("com.viaversion:viaversion:4.6.0-1.19.4-pre3-SNAPSHOT")
    implementation("net.raphimc:ViaAprilFools:2.0.4")
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

tasks {

    assemble {
        dependsOn(reobfJar)
    }

    compileJava {
        options.encoding = "UTF-8"
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }

    shadowJar { }
}

bukkit {
    name = "ViaAprilFoolsPaper"
    description = description
    main = "dev.igalaxy.viaaprilfoolspaper.ViaAprilFoolsPaper"
    version = version
    apiVersion = "1.19"
    depend = listOf("ViaVersion", "ViaBackwards")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "viaaprilfoolspaper"
            from(components["java"])
        }
    }
}