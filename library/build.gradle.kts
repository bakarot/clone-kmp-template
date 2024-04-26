plugins {
    id(libs.plugins.commonMppLib.get().pluginId)
    id("maven-publish")
}
version = "0.0.7"
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
                username = "hieu-dd"
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
