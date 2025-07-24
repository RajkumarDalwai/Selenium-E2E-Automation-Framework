pipeline {
    agent any

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
                    if (params.executionType == 'suite') {
                        def suiteXml = "testng/testing-${params.testSuite}.xml"
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
                }
            }
        }
    }

    post {
        always {
            echo "Publishing JUnit Test Results..."
            junit 'target/surefire-reports/*.xml'

            echo "Generating Allure Report..."
            allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
        }
    }
}
