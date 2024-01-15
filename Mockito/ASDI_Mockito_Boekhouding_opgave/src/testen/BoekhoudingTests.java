package testen;

import domein.Aangifte;
import domein.Boekhouding;
import domein.FactuurMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static domein.Boekhouding.BELASTINGSCHAAL_0;
import static domein.Boekhouding.BELASTINGSCHAAL_1;

@ExtendWith(MockitoExtension.class)
class BoekhoudingTests {
    @Mock
    private FactuurMap factuurMapMock;
    @InjectMocks
    private Boekhouding boekhouding;

    private static Stream<Arguments> opsommingGeldigeWaarden() {
        return Stream.of(
                Arguments.of(new double[]{0.0, 0.0, 0.07}, BELASTINGSCHAAL_0), //mingrens BSe Arguments. of new double[]{20.0, 150.0, 29.99}, BELASTINGSCHAAL_®),//maxgrens BS®
                Arguments.of(new double[]{10.78, 30.25, 29.99}, BELASTINGSCHAAL_0),
                Arguments.of(new double[]{150.0, 50.0, 0.0}, BELASTINGSCHAAL_1), //mingrens voor BS1
                Arguments.of(new double[]{130.22, 150.99, 99.99}, BELASTINGSCHAAL_1),
                Arguments.of(new double[]{0.0, 1000.0, 0.0}, BELASTINGSCHAAL_1),
                Arguments.of(new double[]{0.0, 0.0}, BELASTINGSCHAAL_0),//mingrens voor BS®
                Arguments.of(new double[]{170.0, 29.99}, BELASTINGSCHAAL_0), // maxgrens BS®: 199,99
                Arguments.of(new double[]{10.78, 29.99}, BELASTINGSCHAAL_0),
                Arguments.of(new double[]{150.0, 50.0}, BELASTINGSCHAAL_1),//mingrens voor BS1
                Arguments.of(new double[]{150.55, 80.88}, BELASTINGSCHAAL_1),
                Arguments.of(new double[]{0.0, 1000.0}, BELASTINGSCHAAL_1)
        );
    }

    @ParameterizedTest
    @MethodSource("opsommingGeldigeWaarden")
    void testGeldigeWaarden(double[] bedragen, double belastingSchaal) {
        String ondernememingnummer = "BE5555555555";

        // Mock trainen
        Mockito.when(factuurMapMock.geefBedragen(ondernememingnummer))
                .thenReturn(bedragen);

        // Echte methode oproepen
        Aangifte aangifte = boekhouding
                .genereerAangifte(ondernememingnummer);

        // Assertions
        Assertions.assertArrayEquals(bedragen, aangifte.bedragen());
        Assertions.assertEquals(belastingSchaal, aangifte.belastingSchaal());
        // Verify
        Mockito.verify(factuurMapMock)
                .geefBedragen(ondernememingnummer);

    }

    @ParameterizedTest
    @ValueSource(strings = {"BE0000000000", "BE9999999999", "BE5555555555"})
    void testgenereerAangifte_Ondernemingsnummer_Goed(String ondernnemingsNummer) {
        Assertions.assertDoesNotThrow(() -> boekhouding.genereerAangifte(ondernnemingsNummer));
    }

    @ParameterizedTest
    @ValueSource(strings = {"BE000000000", "BA9999999999", " "})
    void testgenereerAangifte_Ondernemingsnummer_Slecht(String ondernnemingsNummer) {
        Assertions
                .assertThrows(IllegalArgumentException.class,
                        () -> boekhouding.genereerAangifte(ondernnemingsNummer));
    }
}
