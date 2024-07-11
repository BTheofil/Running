plugins {
    alias(libs.plugins.running.android.library)
}

android {
    namespace = "hu.tb.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}