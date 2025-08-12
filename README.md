# Mobile Automation Framework

This repository contains a Mobile Automation Testing Framework designed for Android and iOS applications using **Appium** and **Java**.  
The framework supports cross-platform testing, BDD approach, CI/CD integration, and detailed reporting.

---

## 🚀 Tech Stack

### 📱 Mobile Automation
- Appium
- Android Studio (for Android builds)
- Xcode (for iOS builds)

### 💻 Programming & IDEs
- Java
- IntelliJ IDEA

### 🧪 Testing Frameworks
- Cucumber BDD
- TestNG

### ⚙️ Build & CI/CD
- Maven
- Jenkins

### 📊 Reporting
- Extent Reports
- Masterthought Cucumber Reports

---

## 📂 Project Structure

|-- src
| |-- main/java # Core utilities and reusable functions
| |-- test/java # Test scripts and step definitions
|-- resources
| |-- features # Cucumber feature files
| |-- config # Configuration files
|-- pom.xml # Maven build file
|-- README.md



---

## 🏃‍♂️ How to Execute Tests

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-repo/mobile-automation-framework.git

mvn clean install

mvn test

mvn test -DfilePath=iOSTestng
