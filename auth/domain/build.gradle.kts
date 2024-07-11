plugins {
    alias(libs.plugins.running.jvm.library)
}

dependencies {
    implementation(projects.core.domain)
}