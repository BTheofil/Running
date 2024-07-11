plugins {
    alias(libs.plugins.running.android.library)
    alias(libs.plugins.running.jvm.ktor)
}

android {
    namespace = "hu.tb.core.data"
}

dependencies {
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}