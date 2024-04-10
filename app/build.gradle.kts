plugins {
    id("java")
    id("application")
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(project(":lib"))
}

application {
    mainClass = "org.example.app.App"
}
