package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidateAddressTest {

    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setUp() throws Exception{
        placeOrderController = new PlaceOrderController();
    }

    @ParameterizedTest
@CsvSource({
            "1 Dai Co Viet,true",
            "8/115 Dai Co Viet,true",
            ",false"
    })
    void validateAddress(String address, boolean expected) {
        boolean isValid = placeOrderController.validateAddress(address);

        assertEquals(expected, isValid);
    }
}
