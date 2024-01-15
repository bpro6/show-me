package learn.showme.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ShowMeServiceTest {

    @Autowired
    ShowMeService service;

    @Test
    void isValidRomanNum() {

        String ONE = "XiX";

        String TWO = "XXXI";

        assertFalse(service.isValidRomanNum(ONE));
        assertTrue(service.isValidRomanNum(TWO));


    }
}