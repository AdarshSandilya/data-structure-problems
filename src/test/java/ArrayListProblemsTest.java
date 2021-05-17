import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListProblemsTest {

    @Test
    void getMaxProduct_should_return_maximum_product_possible() {
        assertEquals("60", ArrayListProblems.getMaxProduct(new int[]{ -5, -2, -3, 4}));
        assertEquals("8", ArrayListProblems.getMaxProduct(new int[]{2, 0, 2, 2, 0}));
        assertEquals("120", ArrayListProblems.getMaxProduct(new int[]{-2, -3, 4, -5, -1}));
        assertEquals("120", ArrayListProblems.getMaxProduct(new int[]{-2, -3, 4, -5, -1,-1}));
    }
}