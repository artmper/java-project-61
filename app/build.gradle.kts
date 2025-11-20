plugins {
    id("se.patrikerdes.use-latest-versions") version "0.2.19"
    id("com.github.ben-manes.versions") version "0.53.0"
    application
    id("org.sonarqube") version "7.0.1.6134"
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application { mainClass.set("hexlet.code.App") }
checkstyle {
    toolVersion = "10.12.4"
}
dependencies {

}
repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
    properties {
        property("sonar.projectKey", "artmper_java-project-61")
        property("sonar.organization", "artmper")
    }
}
