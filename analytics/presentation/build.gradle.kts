plugins {
    alias(libs.plugins.running.android.feature.ui)
}

android {
    namespace = "hu.tb.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}