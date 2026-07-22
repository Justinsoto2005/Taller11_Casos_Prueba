import org.junit.jupiter.api.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ReservaServiceTest {
    SalaCine sala;
    ReservaService servicio;

    @BeforeEach
    void setUp() {
        sala = new SalaCine("Sala Grande", 10);
        for (int i = 1; i <= 7; i++) {
            sala.agregarAsiento(new Asiento("A" + i, "ESTANDAR"));
        }
        servicio = new ReservaService(sala);
    }

    @Test
    @DisplayName("CP-07: 5% descuento para 2 boletos")
    void reservaDescuento5() {
        double total = servicio.reservarAsientos(Arrays.asList("A1", "A2"));
        assertEquals(9.5, total);
    }

    @Test
    @DisplayName("CP-08: 15% descuento en límite de 6 boletos")
    void reservaDescuento15() {
        double total = servicio.reservarAsientos(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6"));
        assertEquals(25.5, total);
    }

    @Test
    @DisplayName("CP-09: Error si excede límite de 6 boletos")
    void reservaExcedeLimite() {
        assertThrows(IllegalArgumentException.class, () -> 
            servicio.reservarAsientos(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7"))
        );
    }
}