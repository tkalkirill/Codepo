package org.codepo.experience.others.pyatkov;

import static org.codepo.experience.others.pyatkov.MtsCheckStrings.check;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MtsCheckStringsTest {
    @Test
    void testCheck() {
        assertTrue(check("aab", "ab"));
        assertTrue(check("ab", "aab"));

        assertTrue(check("aba", "ab"));
        assertTrue(check("ab", "aba"));

        assertTrue(check("aba", "aa"));
        assertTrue(check("aa", "aba"));

        assertTrue(check("pcat", "cat"));
        assertTrue(check("cat", "pcat"));

        assertTrue(check("cpat", "cat"));
        assertTrue(check("cat", "cpat"));

        assertTrue(check("aab", "cab"));
        assertTrue(check("aab", "aab"));

        assertFalse(check("aab", "a"));
        assertFalse(check("a", "aab"));
        assertFalse(check("aab", "ccb"));
    }
}
