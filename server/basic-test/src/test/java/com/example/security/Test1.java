package com.example.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Test1 {

    @DisplayName("1. 테스트")
    @Test
    void test_1() {

        assertEquals("test", "test");
    }
}
