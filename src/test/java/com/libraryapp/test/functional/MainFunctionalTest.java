package com.libraryapp.test.functional;

import static com.libraryapp.test.utils.TestUtils.businessTestFile;
import static com.libraryapp.test.utils.TestUtils.currentTest;
import static com.libraryapp.test.utils.TestUtils.testReport;
import static com.libraryapp.test.utils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

import mainapp.MyApp;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
public class MainFunctionalTest {

    @AfterAll
    public static void afterAll() {
        testReport();
    }

    @Test
    @Order(1)
    public void testGitInitialized() throws IOException {
        try {
            String output = MyApp.isGitInitialized();
            yakshaAssert(currentTest(), output.equals("true"), businessTestFile);
        } catch (Exception ex) {
            yakshaAssert(currentTest(), false, businessTestFile);
        }
    }

    @Test
    @Order(2)
    public void testAmendedCommitExists() throws IOException {
        try {
            String output = MyApp.isAmendedCommitPresent();
            yakshaAssert(currentTest(), output.equals("true"), businessTestFile);
        } catch (Exception ex) {
            yakshaAssert(currentTest(), false, businessTestFile);
        }
    }

    @Test
    @Order(3)
    public void testRevertCommitExistsAndFileNotPresent() throws IOException {
        try {
            String output = MyApp.isRevertCommitPresentAndFileNotPresent();
            if (output.equals("true")) {
                yakshaAssert(currentTest(), true, businessTestFile);
            } else {
                yakshaAssert(currentTest(), false, businessTestFile);
            }
        } catch (Exception ex) {
            yakshaAssert(currentTest(), false, businessTestFile);
        }
    }
}
