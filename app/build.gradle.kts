plugins {
    application
}

application {
    mainClass.set("com.example.AppKt")
}

dependencies {
    implementation(project(":model"))
}
