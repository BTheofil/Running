plugins {
    alias(libs.plugins.running.android.library)
    alias(libs.plugins.running.jvm.ktor)
}

android {
    namespace = "hu.tb.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}