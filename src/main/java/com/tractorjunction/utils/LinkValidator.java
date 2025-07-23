package com.tractorjunction.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkValidator {

    private final WebDriver driver;

    private final Set<String> notFoundLinks = new HashSet<>();
    private final Set<String> serverErrorLinks = new HashSet<>();
    private final Set<String> timeoutLinks = new HashSet<>();
    private final Set<String> missingTrailingSlashLinks = new HashSet<>();
    private int successCount = 0;

    // ✅ Constructor accepting WebDriver
    public LinkValidator(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Validate all links from locator
    public void validateLinks(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        validateLinks(elements);
    }

    // ✅ Validate all links from list of elements
    public void validateLinks(List<WebElement> links) {
        if (links == null || links.isEmpty()) {
            System.out.println("⚠️ No links found to validate.");
            return;
        }

        for (WebElement linkElement : links) {
            String href = linkElement.getAttribute("href");
            validateSingleUrl(href);
        }

        printValidationSummary();
    }

    // ✅ Validate a single URL (reusable)
    public void validateSingleUrl(String href) {
        if (href == null || href.isEmpty() || !href.startsWith("http")) {
            System.out.println("⏭️ Skipping invalid or unsupported URL: " + href);
            return;
        }

        try {
            URL url = new URL(href);
            checkTrailingSlash(url);
            int statusCode = getHttpStatusCode(url);

            if (statusCode == 404) {
                notFoundLinks.add(href);
            } else if (statusCode >= 500) {
                serverErrorLinks.add(href);
            } else {
                successCount++;
                System.out.println("✅ OK: " + href);
            }

        } catch (java.net.SocketTimeoutException e) {
            timeoutLinks.add(href);
            System.out.println("⏱️ Timeout: " + href);
        } catch (Exception e) {
            System.out.println("⚠️ Exception while validating: " + href + " - " + e.getMessage());
        }
    }

    // ✅ Get status code for a URL
    private int getHttpStatusCode(URL url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(20000);
        connection.setReadTimeout(20000);
        connection.setRequestMethod("GET");
        connection.connect();
        return connection.getResponseCode();
    }

    // ✅ Check for missing trailing slash
    private void checkTrailingSlash(URL url) {
        String path = url.getPath();
        boolean isFile = path.matches(".*\\.[a-zA-Z0-9]{2,5}$");
        boolean hasTrailingSlash = path.endsWith("/");

        if (!isFile && !hasTrailingSlash) {
            missingTrailingSlashLinks.add(url.toString());
        }
    }

    // ✅ Final Summary Logger
    public void printValidationSummary() {
        printCategory("❌ 404 - Not Found", notFoundLinks);
        printCategory("❌ 500+ - Server Errors", serverErrorLinks);
        printCategory("⏱️ Timeout Errors", timeoutLinks);
        printCategory("⚠️ Missing Trailing Slash", missingTrailingSlashLinks);
        System.out.println("✅ Total Successfully Validated: " + successCount);
    }

    // ✅ Utility: Print categorized results
    private void printCategory(String label, Set<String> urls) {
        if (!urls.isEmpty()) {
            System.out.println("\n" + label + " (" + urls.size() + "):");
            urls.forEach(url -> System.out.println("  - " + url));
        }
    }
}
