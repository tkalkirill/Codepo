package org.codepo.experience.others.pyatkov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class VtbQueueOnStackTest {
    @Test
    void test() {
        var queue = new VtbQueueOnStack.Queue<Integer>();

        assertEquals(0, queue.size());
        assertNull(queue.poll());

        queue.add(1);
        assertEquals(1, queue.size());

        queue.add(2);
        assertEquals(2, queue.size());

        assertEquals(1, queue.poll());
        assertEquals(1, queue.size());

        queue.add(3);
        assertEquals(2, queue.size());

        assertEquals(2, queue.poll());
        assertEquals(1, queue.size());

        assertEquals(3, queue.poll());
        assertEquals(0, queue.size());

        assertNull(queue.poll());
    }
}
