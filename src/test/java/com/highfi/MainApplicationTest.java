package com.highfi;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainApplicationTest {

    @Test
    void should_throw_Null_Pointer_Exception_when_data_is_null() {
        List<String> data = null;
        assertThrows(NullPointerException.class, () -> {MainApplication.createMowers(data);} );
    }
}