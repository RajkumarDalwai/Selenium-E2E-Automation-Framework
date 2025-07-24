pipeline {
    agent any
    tools {
        maven 'apache-maven-3.9.9'
        jdk 'JDK21'
    }
    parameters {
        choice(name: 'executionType', choices: ['suite', 'individual'], description: 'Choose suite or specific test class execution')
        choice(name: 'testSuite', choices: ['smoke', 'regression'], description: 'Test Suite to execute (used if suite selected)')
        choice(name: 'tests', choices: [
            'com.tractorjunction.tests.SearchTests',
            'com.tractorjunction.tests.PageRedirectionTests',
            'com.tractorjunction.tests.LanguageSwitcherTests',
            'com.tractorjunction.tests.SeoElementsTests',
            'com.tractorjunction.tests.UsedTractorListingTests',
            'com.tractorjunction.tests.LoginTests',
            'com.tractorjunction.tests.CompareTests',
            'com.tractorjunction.tests.LocationMasterTests',
            'com.tractorjunction.tests.LeadFormTests',
            'com.tractorjunction.tests.EMICalculatorTests'
        ], description: 'Select the test class to run (used if executionType is individual)')
        choice(name: 'environment', choices: ['test', 'uat', 'prod'], description: 'Environment to run tests on')
        choice(name: 'browser', choices: ['chrome', 'firefox', 'edge'], description: 'Browser to run tests on')
        booleanParam(name: 'headless', defaultValue: true, description: 'Run in headless mode')
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
                    try {
                        if (params.executionType == 'suite') {
                            def suiteXml = "testng/testng-${params.testSuite}.xml"
                            bat """
                                mvn test ^
                                    -DsuiteXmlFile=${suiteXml} ^
                                    -Dbrowser=${params.browser} ^
                                    -Dheadless=${params.headless} ^
                                    -Denvironment=${params.environment}
                            """
                        } else {
                            bat """
                                mvn test ^
                                    -Dtest=${params.tests} ^
                                    -Dbrowser=${params.browser} ^
                                    -Dheadless=${params.headless} ^
                                    -Denvironment=${params.environment}
                            """
                        }
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        error "Test execution failed: ${e.message}"
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