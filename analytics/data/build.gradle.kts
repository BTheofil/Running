plugins {
    alias(libs.plugins.running.android.library)
}

android {
    namespace = "hu.tb.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)

    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)
}