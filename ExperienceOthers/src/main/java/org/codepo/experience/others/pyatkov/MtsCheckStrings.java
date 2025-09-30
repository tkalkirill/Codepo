package org.codepo.experience.others.pyatkov;

/**
 * Напистаь фнкцию check(String, String), которая сравнивает две строки с точностью до одного символа.
 * <pre>
 * check("aab", "ab") == true
 * check("aab", "cab") == true
 * check("aab", "aab") == true
 * check("aab", "a") == false
 * check("aab", "ccb") == false
 * </pre>
 * <p>
 * Нужно использлвать подход с двумя указателями.
 */
class MtsCheckStrings {
    static boolean check(String s0, String s1) {
        if (Math.abs(s0.length() - s1.length()) > 1) {
            return false;
        }

        if (s0.length() == s1.length()) {
            boolean foundDifference = false;

            for (int i = 0; i < s0.length(); i++) {
                if (s0.charAt(i) != s1.charAt(i)) {
                    if (foundDifference) {
                        return false;
                    }

                    foundDifference = true;
                }
            }

            return true;
        }

        if (s1.length() > s0.length()) {
            String temp = s0;
            s0 = s1;
            s1 = temp;
        }

        int i = 0, j = 0;

        boolean foundDifference = false;

        while (i < s0.length() && j < s1.length()) {
            if (s0.charAt(i) == s1.charAt(j)) {
                i++;
                j++;
            } else {
                if (foundDifference) {
                    return false;
                }

                foundDifference = true;

                i++;
            }
        }

        return true;
    }

    static boolean checkCopilot(String s0, String s1) {
        if (Math.abs(s0.length() - s1.length()) > 1) {
            return false;
        }

        int i = 0, j = 0;

        boolean foundDifference = false;

        while (i < s0.length() && j < s1.length()) {
            if (s0.charAt(i) != s1.charAt(j)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;

                if (s0.length() > s1.length()) {
                    i++;
                } else if (s0.length() < s1.length()) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }

        return true;
    }
}
