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
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("io.github.bonigarcia:webdrivermanager:5.6.4")
	implementation("org.seleniumhq.selenium:selenium-api:3.141.59")
	implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
	implementation("com.codeborne:selenide:5.20.3")
	testImplementation("junit:junit:4.13.2")
	implementation("org.seleniumhq.selenium:selenium-chrome-driver:3.141.59")
	testImplementation("org.aspectj:aspectjweaver:1.9.5")
	testImplementation("io.qameta.allure:allure-junit5:2.12.1")
	implementation("io.qameta.allure:allure-commandline:2.12.1")
	testImplementation("io.qameta.allure:allure-assertj:2.12.1")
	testImplementation("io.qameta.allure:allure-rest-assured:4.4.0")
	testImplementation("io.qameta.allure:allure-java-commons:2.12.1")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
