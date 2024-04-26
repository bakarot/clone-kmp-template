plugins {
    id(libs.plugins.commonMppLib.get().pluginId)
    id("maven-publish")
}
version = "0.0.6"
android {
    namespace = "kmp.template"
}

kotlin {
    androidTarget {
        publishLibraryVariants("release")
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinStdLib)
                implementation(libs.kotlinSerializationJson)
                implementation(libs.kotlinSerializationCbor)
            }
        }
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/hieu-dd/clone-kmp-template")
            credentials {
                username =
                    project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME_GITHUB")
                password =
                    project.findProperty("gpr.token") as String? ?: System.getenv("TOKEN_GITHUB")
            }
        }
    }
    publications {
        create<MavenPublication>("multiplatform") {
            groupId = "kmp.template"
            artifactId = "library"
            from(components["kotlin"])
        }
    }
}
