plugins {
    alias(libs.plugins.kotlinPluginSerialization)
    kotlin("jvm")
    id("com.gradleup.shadow") version "8.3.0"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

dependencies {
    compileOnly(libs.paperGlobal)

    runtimeOnly(project(":comshop-impl:1.21.10"))
    implementation(project(":comshop-front"))
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.runServer {
    minecraftVersion("1.21.10")
}

kotlin {
    jvmToolchain(21)
}

tasks.jar {
    manifest {
        attributes["Implementation-Version"] = version
    }
    from(
        configurations.compileClasspath.get().filter {
            it.name.endsWith("kotlin-stdlib.jar")
        }.map {
            if (it.isDirectory) it else zipTree(it)
        }
    )

    // To avoid the duplicate handling strategy error
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    // To add all of the dependencies
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })

}