package org.codepo.experience.others.pyatkov;

import static org.codepo.experience.others.pyatkov.TbankMatrixColoring.painting;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TbankMatrixColoringTest {
    @Test
    void test0() {
        int[][] matrix = {
                {1, 1, 1, 3, 3, 4}
        };

        assertEquals(3, painting(matrix));
    }

    @Test
    void test1() {
        int[][] matrix = {
                {1, 1, 1, 1},
                {2, 2, 1, 2},
                {2, 2, 2, 2}
        };

        assertEquals(2, painting(matrix));
    }

    @Test
    void test2() {
        int[][] matrix = {
                {1, 1, 2, 3},
                {1, 2, 2, 1},
                {1, 1, 2, 1}
        };

        assertEquals(4, painting(matrix));
    }
}
