package com.tractorjunction.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        // Log details of the failed test
        System.out.println("=== TEST FAILED ❌ ===");
        System.out.println("Test Name: " + result.getName());
        System.out.println("Test Class: " + result.getTestClass().getName());
        System.out.println("Error Message: " + result.getThrowable().getMessage());
        System.out.println("Stack Trace: ");
        result.getThrowable().printStackTrace(System.out);
        System.out.println("==================");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed ✅ : " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
    }
}
