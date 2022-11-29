package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidateRushDeliveryDayTest {

    private PlaceRushOrderController placeRushOrderController;

    @BeforeEach
    void setUp() throws Exception{
        placeRushOrderController = new PlaceRushOrderController();
    }

    @ParameterizedTest
    @CsvSource({
            ", false",
            "002, false",
            "0.5, false",
            "abcde, false",
            "25, false",
            "-1, false",
            "1.5, false",
            "1, true",
            "10,, true",
            "1, true"
    })
    void validateRushDeliveryDay(String rushDay, boolean expected) {
        boolean isValid = placeRushOrderController.validateRushDeliveryDay(rushDay);
        assertEquals(expected, isValid);
    }
}
