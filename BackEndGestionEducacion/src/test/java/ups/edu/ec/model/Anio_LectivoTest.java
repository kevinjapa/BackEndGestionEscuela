package ups.edu.ec.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
public class Anio_LectivoTest {
    @Test
    public void testAnioLectivoAttributes() {
        Anio_Lectivo anioLectivo = new Anio_Lectivo();
        anioLectivo.setId(1);
        anioLectivo.setDescripcion("2023-2024");

        assertEquals(1, anioLectivo.getId());
        assertEquals("2023-2024", anioLectivo.getDescripcion());
    }
}
