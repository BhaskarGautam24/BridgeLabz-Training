import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TempConverterTest {

   //convert cel to fer
    static double celToFer(double cel) {
        return (  cel*9/5)+32;
    }

    // Convert fer to cel
    static double ferToCel(double fah) {
        return (  fah-32)*5/9;
    }

    @Test
    void testCelToFer () {
        assertEquals(32,celToFer(0),0.001);
        assertEquals(212,celToFer(100),0.001);
        assertEquals(98.6,celToFer(37),0.001);
    }

    @Test
    void testferToCel () {
        assertEquals(0,ferToCel(32),0.001);
        assertEquals(100,ferToCel(212),0.001);
        assertEquals(37,ferToCel(98.6),0.001);
    }
}
