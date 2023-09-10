package com.parsakav.pgukala;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class StandardTests {

    @BeforeAll
    static void initAll() {
        // initializes resources before all test methods
    }

    @BeforeEach
    void init() {
        // initializes resources before each test method
    }

    @Test
    void successTest() {
        // this test will pass
    }

    @Test
    void failTest() {
        fail("this test will fail");
    }

    @Test
    @Disabled
    void skippedTest() {
        // this test is skipped temporarily
    }

    @AfterEach
    void tearDown() {
        // releases resources after each test method
    }

    @AfterAll
    static void tearDownAll() {
        // releases resources after all test methods
    }
}