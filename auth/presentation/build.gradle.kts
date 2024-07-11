plugins {
    alias(libs.plugins.running.android.feature.ui)
}

android {
    namespace = "hu.tb.auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}