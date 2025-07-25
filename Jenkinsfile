pipeline {
    agent any
    tools {
        maven 'apache-maven-3.9.9'
        jdk 'JDK21'
    }
    parameters {
        choice(name: 'testSuite', choices: ['None', 'smoke', 'regression'], description: 'Test Suite to execute (select None to skip)')
        choice(name: 'tests', choices: ['None', 'SearchTests', 'PageRedirectionTests', 'LanguageSwitcherTests', 'SeoElementsTests', 'UsedTractorListingTests', 'LoginTests', 'CompareTests', 'LocationMasterTests', 'LeadFormTests', 'EMICalculatorTests'], description: 'Select the test class to run (select None to skip)')
        choice(name: 'environment', choices: ['prod', 'test', 'uat'], description: 'Environment to run tests on')
        choice(name: 'browser', choices: ['chrome', 'firefox', 'edge'], description: 'Browser to run tests on')
        booleanParam(name: 'headless', defaultValue: true, description: 'Run in headless mode')
        booleanParam(name: 'runOnGrid', defaultValue: false, description: 'Run tests on Selenium Grid in parallel')
    }
    stages {
        stage('Check Java Version') {
            steps {
                bat 'java -version'
            }
        }
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Test Execution') {
            steps {
                script {
                    // Clean Allure results
                    bat 'rmdir /s /q allure-results || echo No allure-results to delete'

                    def testNameMap = [
                        'SearchTests': 'com.tractorjunction.tests.SearchTests',
                        'PageRedirectionTests': 'com.tractorjunction.tests.PageRedirectionTests',
                        'LanguageSwitcherTests': 'com.tractorjunction.tests.LanguageSwitcherTests',
                        'SeoElementsTests': 'com.tractorjunction.tests.SeoElementsTests',
                        'UsedTractorListingTests': 'com.tractorjunction.tests.UsedTractorListingTests',
                        'LoginTests': 'com.tractorjunction.tests.LoginTests',
                        'CompareTests': 'com.tractorjunction.tests.CompareTests',
                        'LocationMasterTests': 'com.tractorjunction.tests.LocationMasterTests',
                        'LeadFormTests': 'com.tractorjunction.tests.LeadFormTests',
                        'EMICalculatorTests': 'com.tractorjunction.tests.EMICalculatorTests'
                    ]

                    if (params.testSuite != 'None' && params.tests == 'None') {
                        def suiteXml = "testng/testng-${params.testSuite}.xml"
                        def profile = params.runOnGrid ? "grid-parallel" : "suite"
                        def gridOption = params.runOnGrid ? "-DgridUrl=http://localhost:4444/wd/hub" : ""

                        bat """
                            mvn test ^
                                -P${profile} ^
                                -Dtestng.suiteXmlFile=${suiteXml} ^
                                -Dbrowser=${params.browser} ^
                                -Denvironment=${params.environment} ^
                                -Dheadless=${params.headless} ^
                                ${gridOption}
                        """
                    } else if (params.tests != 'None' && params.testSuite == 'None') {
                        def fullTestName = testNameMap[params.tests]
                        if (fullTestName) {
                            bat """
                                mvn test ^
                                    -Psingle-test ^
                                    -Dtest=${fullTestName} ^
                                    -Dbrowser=${params.browser} ^
                                    -Denvironment=${params.environment} ^
                                    -Dheadless=${params.headless} ^
                                    -DgridUrl=http://localhost:4444/wd/hub
                            """
                        } else {
                            error "Invalid test name selected: ${params.tests}"
                        }
                    } else if (params.testSuite != 'None' && params.tests != 'None') {
                        error "Cannot run both a test suite and an individual test. Please select only one."
                    } else {
                        echo "No test or suite selected. Skipping test execution."
                    }
                }
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
        }
    }
}
