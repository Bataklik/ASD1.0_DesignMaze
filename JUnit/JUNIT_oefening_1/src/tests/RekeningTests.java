package tests;

import domein.Rekening;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RekeningTests {

    @ParameterizedTest
    @ValueSource(strings = {"063-1547563-60", "999-9999999-48","001-0000001-77"})
    public void Rekening_Nummer_Goed(String nummer) {
        Assertions.assertDoesNotThrow(() -> new Rekening(nummer));
    }

    @ParameterizedTest
    @ValueSource(strings = {"061-1547563-60", "99-9999999-48","null","111"," ","9999-999999-48","999999999948"})
    public void Rekening_Nummer_Slecht(String nummer) {
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Rekening(nummer));
    }
}
