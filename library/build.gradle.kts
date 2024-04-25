plugins {
    id(libs.plugins.commonMppLib.get().pluginId)
    id("maven-publish")
}

android {
    namespace = "kmp.template"
}

kotlin {
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
    publications {
        create<MavenPublication>("gpr") {
            from(components["kotlin"])
            groupId = "kmp.template"
            artifactId = "kmp-template"
            version = "0.1.0"

            pom {
                name.set("kmp template")
                description.set("A description of my library")
                url.set("https://github.com/hieu-dd/clone-kmp-template")
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/hieu-dd/clone-kmp-template")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}



