plugins {
    java
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "io.coding.tree.appointmate"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["testcontainersVersion"] = "1.17.6"
extra["springModulith"] = "0.3.0"

object Versions {
    const val mapstruct = "1.5.3.Final"
    const val instancio = "2.7.0"
    const val dataFaker = "1.8.0"
    const val jsonUnitAssertJ = "2.36.1"
    const val vavr = "0.10.4"
    const val yavi = "0.12.1"
    const val restAssured = "5.3.0"
    const val googlePhoneNumber = "8.13.6"
    const val javamoney = "1.4.2"
    const val jacksonDatatypeMoney = "1.3.0"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-mail")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    implementation("org.springframework.experimental:spring-modulith-starter-mongodb")
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
    implementation("net.datafaker:datafaker:${Versions.dataFaker}")
    implementation("org.javamoney:moneta:${Versions.javamoney}")
    implementation("org.zalando:jackson-datatype-money:${Versions.jacksonDatatypeMoney}")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.springframework.experimental:spring-modulith-actuator")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.experimental:spring-modulith-starter-test")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:mongodb")
    testImplementation("net.javacrumbs.json-unit:json-unit-assertj:${Versions.jsonUnitAssertJ}")
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
