plugins {
    id("java")
    id("application")
}

group = "io.github.noah_devtech"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://jogamp.org/deployment/maven") }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

val processingVersion = "4.3.3"
val joglVersion = "2.5.0"

dependencies {
    // Processing Core
    implementation("org.processing:core:$processingVersion")

    // JOGL & GlueGen
    val joglModules = listOf("jogl", "nativewindow", "newt")

    joglModules.forEach { module ->
        implementation("org.jogamp.jogl:$module:$joglVersion")
    }
    implementation("org.jogamp.gluegen:gluegen-rt:$joglVersion")

    // Native libraries for each platform
    val platforms = listOf("windows-amd64", "macosx-universal", "linux-amd64")
    platforms.forEach { platform ->
        joglModules.forEach { module ->
            runtimeOnly("org.jogamp.jogl:$module:$joglVersion:natives-$platform")
        }
        runtimeOnly("org.jogamp.gluegen:gluegen-rt:$joglVersion:natives-$platform")
    }

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("io.github.noah_devtech.Main")
    applicationDefaultJvmArgs =
        listOf(
            "--add-exports=java.desktop/sun.awt=ALL-UNNAMED",
            "--add-opens=java.desktop/sun.awt=ALL-UNNAMED",
            "--add-exports=java.desktop/sun.java2d=ALL-UNNAMED",
            "--add-opens=java.desktop/sun.java2d=ALL-UNNAMED"
        )
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.run {
    standardInput = System.`in`
}