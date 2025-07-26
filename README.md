# **Selenium E2E Automation Framework**

## 🧩 Overview

A robust End-to-End (E2E) automation testing framework built using **Selenium**, tailored for validating the **TractorJunction** web application. This framework supports:

* ✅ Cross-browser testing
* ✅ Parallel execution via Selenium Grid
* ✅ Multi-environment support (Test / UAT / Prod)
* ✅ Smoke and Regression Test Suites

It currently automates **85 test cases** covering key functional areas of the application.

---

## 🚀 Features

* **🔀 Cross-Browser Testing**
  Run tests on Chrome, Firefox, and Edge to ensure compatibility across browsers.

* **⚙️ Parallel Execution with Selenium Grid**
  Significantly reduces test execution time by running tests in parallel across nodes.

* **🌐 Multi-Environment Support**
  Easily switch between Test, UAT, and Production using configurable properties.

* **🧪 Test Suites**
  Organized test execution through **Smoke** and **Regression** suites for targeted validation.

<img width="1295" height="740" alt="image" src="https://github.com/user-attachments/assets/ff16d016-6727-4e83-847c-4594e6e69b7e" />



---

## ✅ Test Coverage

| Module                        | No. of Tests | Description                                                                 |
| ----------------------------- | ------------ | --------------------------------------------------------------------------- |
| Login                         | 1            | Validates user login functionality                                          |
| Language Switcher             | 4            | Tests switching between 5 supported languages                               |
| Search Functionality          | 2            | Verifies search input behavior and result display                           |
| Lead Forms                    | 10           | Includes validations for Sell Used and other lead forms                     |
| Page Redirections             | 10           | Validates internal redirection across 10 core pages                         |
| Location Master               | 10           | Location-based dropdown and input validations                               |
| SEO Elements (Multi-language) | 40           | Extensive parameterized SEO checks across 5 languages                       |
| Used Tractor Filters          | 5            | Filter validation based on Price, Brand+Model, Year, Sort, and combinations |
| Compare Page                  | 2            | Compares selected tractors                                                  |
| EMI Calculator                | 1            | Verifies EMI calculation logic                                              |

**🔢 Total Automated Tests: 85**

---

## 📂 Project Structure

```
Selenium-E2E-Automation-Framework/
├── src/
│   ├── main/
│   │   ├── java/com/tractorjunction/
│   │   │   ├── base/               → BaseTest.java
│   │   │   ├── driver/             → DriverFactory, DriverManager
│   │   │   ├── listeners/          → CustomTestListener, RetryAnalyzer
│   │   │   ├── models/             → LeadTestData.java
│   │   │   ├── pages/              → All Page Object files
│   │   │   └── utils/              → ConfigReader, Data Providers, Excel Readers, Validators, etc.
│   ├── main/resources/
│   │   ├── test-data/             → Test data files (Excel/JSON/Image)
│   │   ├── config_*_properties    → Env-specific config (Test/UAT/Prod)
│   │   └── log4j2.xml             → Logging configuration
│   ├── test/
│   │   └── java/com/tractorjunction/tests/
│   │       └── All test classes per module
│   └── test/resources/
├── allure-results/               → Allure report data
├── logs/                         → Execution logs
├── testng-smoke.xml              → Smoke suite
├── testng-regression.xml         → Regression suite
├── docker-compose.yml            → Grid setup for parallel execution
├── Jenkinsfile                   → CI/CD integration
├── pom.xml                       → Maven dependencies and profiles
```

---

## ⚙️ Setup & Execution

1. **Clone the Repository**

   ```bash
   https://github.com/RajkumarDalwai/Selenium-E2E-Automation-Framework.git
   ```

2. **Configure Environments**
   Update environment-specific property files under `src/main/resources/`.

3. **Start Selenium Grid**

   ```bash
   docker-compose up -d
   ```

4. **Execute Test Suites**

   * Smoke Suite: `mvn test -Psmoke`
   * Regression Suite: `mvn test -Pregression`

---

## 📊 Reporting

* **Allure Reports**
  Auto-generated test reports with detailed steps, screenshots, and metrics.
 <img width="1920" height="869" alt="image" src="https://github.com/user-attachments/assets/79ed468c-bb5f-4710-9f9f-54120ca8a993" />


* **Jenkins Integration**
  CI/CD enabled using Jenkinsfile to trigger tests on code commits or scheduled jobs.

---

## 🤝 Contributing

We welcome contributions!

* Fork the repository
* Create feature branches
* Raise issues and submit pull requests

Let's make testing better—together 🚀

---

