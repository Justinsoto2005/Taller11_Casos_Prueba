import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SalaCineTest {
    SalaCine sala;

    @BeforeEach
    public void setUp(){
        sala = new SalaCine("Sala 1",2);
    }

    @Test
    @DisplayName("Agregar asiento vacio")
    public void agregarAsientoValido(){
        sala.agregarAsiento(new Asiento("A1", "ESTANDAR"));
        assertNotNull(sala.buscarAsiento("A1"));
    }

    @Test
    @DisplayName("Error al buscar asiento que no existe")
    public void buscarAsientoInexistente(){
        assertThrows(RuntimeException.class, () -> sala.buscarAsiento("Z99"));
    }

    @Test
    @DisplayName("CP-06: Error al agregar si la sala está llena")
    public void agregarSalaLlena() {
        sala.agregarAsiento(new Asiento("A1", "ESTANDAR"));
        sala.agregarAsiento(new Asiento("A2", "VIP"));
        assertThrows(IllegalStateException.class, () -> sala.agregarAsiento(new Asiento("A3", "4D")));
    }
}
