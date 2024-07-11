plugins {
    alias(libs.plugins.running.android.library)
}

android {
    namespace = "hu.tb.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)

    implementation(projects.core.domain)
}