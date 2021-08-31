import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.30" apply false
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("maven-publish")
    }

    val implementation by configurations

    dependencies {
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
        implementation(kotlin("stdlib-jdk8"))
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

    configure<PublishingExtension> {
        publications {
            create<MavenPublication>("maven") {
                group = "com.example"
                artifactId = project.name
                version = "0.0.1"

                from(components["kotlin"])
            }
        }
    }
}
