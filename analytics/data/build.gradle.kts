plugins {
    alias(libs.plugins.running.android.library)
    alias(libs.plugins.running.android.room)
}

android {
    namespace = "hu.tb.analytics.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.koin)

    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)
}