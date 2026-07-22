import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AsientoTest {
    Asiento asiento;

    @BeforeEach
    void setUp() {
    asiento = new Asiento("A1", "VIP");
    }

    @Test
    @DisplayName("CP-01 Constructor crea correctamente un asiento VIP")
    void crearAsientoValido() {
    assertEquals("A1", asiento.getCodigo());
    assertEquals("VIP", asiento.getTipo());
    assertFalse(asiento.isOcupado());
    }

    @Test
    @DisplayName("CP-02 Constructor lanza excepción para tipo inválido")
    void crearAsientoTipoInvalido() {

    assertThrows(IllegalArgumentException.class,
    () -> new Asiento("A2", "INVENTADO"));
    }

    @Test
    @DisplayName("CP-03 Ocupar un asiento ya ocupado")
    void ocuparAsientoOcupado() {
    asiento.ocupar();
    assertThrows(IllegalStateException.class,asiento::ocupar);
    }
}