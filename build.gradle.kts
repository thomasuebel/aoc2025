plugins {
    id("java")
    id("jacoco")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // run coverage report after tests
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
        csv.required.set(false)
    }
}

// Optionally enforce coverage rules in the future using the task below
// tasks.jacocoTestCoverageVerification {
//     violationRules {
//         rule {
//             limit {
//                 counter = "INSTRUCTION"
//                 value = "COVEREDRATIO"
//                 minimum = "0.80".toBigDecimal()
//             }
//         }
//     }
// }