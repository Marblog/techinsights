import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springBootVersion = "3.0.2"
val springCloudAlibabaVersion = "2022.0.0.0"
val springdocVersion = "1.7.0"
val mybatisPlusVersion = "3.5.3.2"
val okhttpVersion = "4.9.1"
val pageHelperVersion = "1.4.7"
val jakartaVersion = "2.1.1"
val servletApiVersion = "4.0.1"
val poiVersion = "5.0.0"
val logbackVersion = "1.4.5"
val javaxMail = "1.6.2"
val fastJson = "2.0.40"
var springCloudVersion = "2022.0.0"
val logbackAdapter = "1.0.0"
plugins {
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10"
    java
    `java-library`
}

allprojects {
    repositories {
        maven("https://maven.aliyun.com/repository/central")
        mavenCentral()
    }
}
extra["springCloudVersion"] = "2022.0.0"
group = "com.techinsights"
version = "1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}
subprojects {
    apply {
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
    }
    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
            mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:$springCloudAlibabaVersion")
        }
        generatedPomCustomization {
            enabled(false)
        }
        resolutionStrategy {
            cacheChangingModulesFor(0, TimeUnit.SECONDS)
        }
    }
    dependencies {
        implementation("javax.mail:javax.mail-api:$javaxMail")
        implementation("com.sun.mail:javax.mail:$javaxMail")
        implementation("com.alibaba.fastjson2:fastjson2:$fastJson")
        implementation("org.apache.poi:poi:$poiVersion")
        implementation("org.apache.poi:poi-ooxml:$poiVersion")
        implementation("org.springframework.boot:spring-boot-starter-data-redis")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("com.baomidou:mybatis-plus-boot-starter:$mybatisPlusVersion")
        implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
        implementation("com.github.pagehelper:pagehelper-spring-boot-starter:$pageHelperVersion")
        implementation("jakarta.annotation:jakarta.annotation-api:$jakartaVersion")
        implementation("org.springdoc:springdoc-openapi-ui:$springdocVersion")
        implementation("javax.servlet:javax.servlet-api:$servletApiVersion")
        testImplementation("junit:junit:4.13.1")
        runtimeOnly("com.mysql:mysql-connector-j")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        implementation("ch.qos.logback:logback-classic:$logbackVersion")
        implementation("com.alibaba.nacos:logback-adapter:$logbackAdapter")
        implementation("com.alibaba.nacos:nacos-client")
        implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
        implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }
}







