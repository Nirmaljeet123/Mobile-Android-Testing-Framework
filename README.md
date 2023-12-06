
# Mobile Automation Framework with Appium 2.0, Java, and TestNG-POM

## Overview

This repository contains a mobile test automation framework built using Java as the scripting language and TestNG-POM as the framework model. This framework aims to streamline the automation of mobile applications on Android platforms by incorporating the Page-Object-Model (POM) principles. Its design promotes effective collaboration among developers, testers, and product owners.

## Table of Contents

- [Introduction](#introduction)
- [Key Features](#key-features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Setup](#setup)
- [Project Structure](#project-structure)
- [Writing and Organizing Tests](#writing-and-organizing-tests)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Comprehensive Reporting](#comprehensive-reporting)
- [Additional Essential Software](#additional-essential-software)
- [Contributing](#contributing)

## Introduction

This framework is tailored to streamline and elevate the process of automating mobile application testing for Android-based mobile apps using the Appium TestNG-POM framework. Embracing the Page Object Model design pattern, this framework organizes mobile app elements and their associated functionalities into reusable classes.

## Key Features

- **Modular Structure:** Organize mobile test code into reusable components using a modular approach.
- **Appium Integration:** Seamlessly integrate with the powerful Appium testing framework for Android and iOS.
- **Mobile Element Abstraction:** Abstract mobile elements for simplified maintenance and improved code readability.
- **Configuration Management:** Easily manage mobile test configurations through flexible configuration files.
- **Logging and Reporting:** Access comprehensive logging and reporting features for effective test result tracking.
- **Cross-Platform Testing:** Leverage Appium's capabilities for cross-platform mobile testing.
- **Ease of Contribution:** Contribute to framework enhancement with clear contributing guidelines.

## Getting Started

### Prerequisites

Before running the tests, ensure you have the following software components installed:

- [Java Development Kit (JDK >=8)](link-to-jdk) - The programming language that powers the framework.
- [Android Studio](link-to-android-studio) - Necessary for Android app testing and creating an emulator.
- [Appium (>=2.0)](link-to-appium) - The mobile automation framework for Android and iOS. (npm install -g appium@next)
- [Appium Drivers](link-to-appium-drivers) - uiautomator2 for Android
- [npm](link-to-npm) - The node package installer.

### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/appium-java-testng.git

2. Create a virtual environment (recommended):
    
     ```bash
    cd appium-java-testng

3. Install the required dependencies:
   ```bash
     mvn clean install


##  Project Structure
The framework employs a modular structure for efficient management and organization of your test suite. Here's a brief overview of the core directories:

**allure-results**: Stores Allure reports generated after test execution.
**config.properties**: Configuration properties settings for test execution.
**actions**: Contains actions, alerts, and gesture actions of app elements.
**basePackage**: Contains Appium Driver setup, start, and stop actions.
**pageObjects**: Houses Page Objects, encapsulating interactions with app screens.  
**utils**: Stores reporting listeners, waits, and read data utilities for test execution.  
**com.android**: Hosts test modules that utilize Page Objects.    
**app**: Place your test APK files here.   
**src/test/resources**: Contains test data.  
**testng.xml**:Xml runner for framework.  
**testngParallel.xml**: xml runner for parallel execution.


```bash
   Mobile-Android-Testing/
   ├── allure-results
   ├── config.properties
   ├── src
      ├── main
         ├── java
            ├── actions
                       ├──Actions.java
                       └── ...    
            ├── basePackage
                       ├──BaseClass.java
                       └── ...
            ├── pageObjects
                       ├──HomePage.java
                       └── ...
            ├── utils
                       ├──Listeners.java
                       └── ...
    ├── src
      ├── main
         ├── resources
            ├── app
    ├── src
      ├── test
         ├── java
            ├── com
                   ├──android
                             ├──CapturePicture.java
                             └── ...
    ├── src
      ├── test
         ├── resources
            ├── BoxTestData.xls                       
   ├── testng.xml
   ├── testngParallel.xml

```

## Writing and Organizing Tests
Create test classes under the "com.android" directory. Utilize the respective Page Objects to interact with app elements. Leverage TestNG annotations for test orchestration.

## Configuration
Update the src/test/resources/BoxTestData.xlsx and config.properties files with your Appium server details, device configurations, and other relevant settings. Like:

```properties
path = \\src\\main\\resources\\box.apk
appActivity = com.box.android.activities.login.SplashScreenActivity
appPackage = com.box.android
platformName = Android
automationName = UiAutomator2
emailId = abc@gmail.com
password = abc@123
```

**Note**: This framework is basically built for the Box application. You can download it from the Play Store or download it from this link.

## Running Tests  
Open the command prompt and go to the project directory. Execute the following Maven command to run the tests:

```bash
mvn test
```
You can also run specific test classes or methods by specifying them as parameters. For example:

```bash
mvn test -Dtest=TestClass#testMethod
```
or simply run testng.xml as a TestNG Suite.

## Comprehensive Reporting
**Allure Reports**: Test execution outcomes are meticulously captured in Allure reports, available in the allure-results directory. These reports provide a clear and comprehensive overview of test results, assisting in identifying issues and gauging overall test coverage.

After running the tests, refresh the project folder, open a command prompt, go to the project directory, and write the below command:

```bash
allure serve allure-results
```
## Integrating with Eclipse IDE
This framework seamlessly integrates with the Eclipse IDE, providing an enriched development experience with features such as code completion, debugging, and seamless navigation. Open the project directory in Eclipse IDE workspace to leverage these capabilities.

## Additional Essential Software
In addition to the core framework, the following software components are indispensable:

**Eclipse**: A powerful IDE that streamlines project management and coding tasks.   
**Git**: The version control system of choice for collaborative development.    
**Appium Desktop**: A GUI application for managing the Appium server and inspecting app elements.   
**Android Studio**: An IDE crucial for Android development, necessary for Android testing.

## Contributing
Enthusiastically invite and welcome contributions to this framework! Please feel free to submit issues and pull requests for enhancements, bug fixes, or the addition of new features. Your input and collaboration are highly valued.

Make sure to replace placeholder values such as <yourusername>, /path/to/your/app.apk, <platform-version>, <device-name>, and <your-device-udid> with your actual information. Additionally, customize the content as per your project structure and requirements.








