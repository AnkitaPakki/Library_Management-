package com.example.library;   // <- update this

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LibraryManagementApplication.class)  // <- explicitly point to main class
class LibraryManagementApplicationTests {

    @Test
    void contextLoads() {
    }
}
