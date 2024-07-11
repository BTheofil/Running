plugins {
    alias(libs.plugins.running.android.library)
    alias(libs.plugins.running.android.room)
}

android {
    namespace = "hu.tb.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)

    implementation(projects.core.domain)
}