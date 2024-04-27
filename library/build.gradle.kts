plugins {
    id(libs.plugins.commonMppLib.get().pluginId)
    id("maven-publish")
}
version = "0.0.2"
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
            url = uri("https://maven.pkg.github.com/bakarot/clone-kmp-template")
            credentials {
                username = "bakarot"
                password = "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"
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
