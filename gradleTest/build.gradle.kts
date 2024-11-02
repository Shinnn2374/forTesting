plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(22)
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

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	implementation("com.google.code.gson:gson:2.11.0")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testCompileOnly("org.projectlombok:lombok")
	testAnnotationProcessor("org.projectlombok:lombok")
	testImplementation("io.rest-assured:rest-assured:5.5.0")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.2")
	testImplementation("junit:junit:4.13.2")

	testImplementation("io.qameta.allure:allure-junit5:2.12.1")
	testImplementation("io.qameta.allure:allure-commandLine:2.12.1")
	testImplementation("io.qameta.allure:allure-assertj:2.12.1")
	testImplementation("io.qameta.allure:allure-rest-assured:2.12.1")
	testImplementation("io.qameta.allure:allure-java-commons:2.12.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
