plugins {
    java
    idea
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "io.coding.tree.appointmate"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
        implementation.set(JvmImplementation.J9)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["testcontainersVersion"] = "1.17.6"
extra["springModulith"] = "0.4.1"

object Versions {
    const val mapstruct = "1.5.3.Final"
    const val instancio = "2.10.0"
    const val vavr = "0.10.4"
    const val yavi = "0.12.1"
    const val restAssured = "5.3.0"
    const val googlePhoneNumber = "8.13.6"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    implementation("org.springframework.experimental:spring-modulith-starter-core:${property("springModulith")}")
    modules {
        module("org.springframework.boot:spring-boot-starter-logging") {
            replacedBy("org.springframework.boot:spring-boot-starter-log4j2",
                "Use Log4j2 instead of Logback")
        }
    }
    implementation("org.mapstruct:mapstruct:${Versions.mapstruct}")
    implementation("io.vavr:vavr:${Versions.vavr}")
    implementation("am.ik.yavi:yavi:${Versions.yavi}")
    implementation("com.googlecode.libphonenumber:libphonenumber:${Versions.googlePhoneNumber}")
    implementation("org.instancio:instancio-core:${Versions.instancio}")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.springframework.experimental:spring-modulith-actuator")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.experimental:spring-modulith-starter-test")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:mongodb")
    testImplementation("io.rest-assured:spring-mock-mvc:${Versions.restAssured}")
    testCompileOnly("org.projectlombok:lombok")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
        mavenBom("org.springframework.experimental:spring-modulith-bom:${property("springModulith")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}
