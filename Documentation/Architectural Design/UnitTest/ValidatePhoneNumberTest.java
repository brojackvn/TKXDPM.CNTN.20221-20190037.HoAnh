package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidatePhoneNumberTest {

    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setUp() throws Exception{
        placeOrderController = new PlaceOrderController();
    }

    @ParameterizedTest
    @CsvSource({
            ", false",
            "qasbas__, false",
            "01212, false",
            "012345678a, false",
            "01234567800, false",
            "1234510000, false",
            "1234510, false",
            "12345100000, false",
            "123456_123, false",
            "0123456789, true",
    })
    void validatePhoneNumber(String phone, boolean expected) {
        boolean isValid = placeOrderController.validatePhoneNumber(phone);
        assertEquals(expected, isValid);
    }
}
