plugins {
    alias(libs.plugins.running.android.library)
}

android {
    namespace = "hu.tb.core.data"
}

dependencies {
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}