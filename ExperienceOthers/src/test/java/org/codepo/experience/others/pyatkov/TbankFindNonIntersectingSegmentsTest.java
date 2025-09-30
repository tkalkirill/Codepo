package org.codepo.experience.others.pyatkov;

import static org.codepo.experience.others.pyatkov.TbankFindNonIntersectingSegments.find;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class TbankFindNonIntersectingSegmentsTest {
    @Test
    void test() {
        assertArrayEquals(
                new int[][]{{2, 8}, {10, 15}},
                find(new int[][]{{1, 20}, {10, 15}, {2, 10}, {2, 8}})
        );
    }
}
