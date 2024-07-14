plugins {
    alias(libs.plugins.running.android.library)
    alias(libs.plugins.running.jvm.ktor)
}

android {
    namespace = "hu.tb.auth.data"
}

dependencies {
    implementation(libs.bundles.koin)

    implementation(projects.auth.domain)
    implementation(projects.core.domain)
    implementation(projects.core.data)
}