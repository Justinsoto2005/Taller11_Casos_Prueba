# Taller11_Casos_Prueba
| Clase | ID | Método | Datos de entrada | Salida esperada | Propósito |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Asiento** | CP-01 | Constructor | `codigo="A1", tipo="VIP"` | Objeto creado, `ocupado=false` | Caso normal |
| **Asiento** | CP-02 | Constructor | `codigo="A2", tipo="INVENTADO"` | `IllegalArgumentException` | Caso de error (tipo inválido) |
| **Asiento** | CP-03 | ocupar() | Asiento con `ocupado=true` | `IllegalStateException` | Caso de error (ya ocupado) |
| **SalaCine** | CP-04 | agregarAsiento() | Asiento válido, sala con espacio | Asiento agregado a la lista | Caso normal |
| **SalaCine** | CP-05 | buscarAsiento() | `codigo="Z99"` (no existe) | `NoSuchElementException` | Caso de error (no encontrado) |
| **SalaCine** | CP-06 | agregarAsiento() | Asiento válido, pero sala llena | `IllegalStateException` | Caso límite/error (sala llena) |
| **ReservaService** | CP-07 | reservarAsientos() | Lista con 2 códigos válidos | Subtotal calculado con 5% descuento | Caso normal |
| **ReservaService** | CP-08 | reservarAsientos() | Lista con 6 códigos válidos | Subtotal calculado con 15% descuento | Caso límite (máximo permitido) |
| **ReservaService** | CP-09 | reservarAsientos() | Lista con 7 códigos válidos | `IllegalArgumentException` | Caso de error (excede límite) |