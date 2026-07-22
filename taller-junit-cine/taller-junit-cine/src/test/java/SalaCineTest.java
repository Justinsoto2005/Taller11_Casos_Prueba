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
    @DisplayName
}
