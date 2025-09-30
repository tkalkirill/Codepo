package org.codepo.experience.others.pyatkov;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Среди отрезков найти 2 не пересекающихся:
 * <pre>
 * Пример:
 *  [[1,20], [10, 15], [2, 10], [2, 8]] -> [10, 15], [2, 8]
 *  [[2, 8], [2, 10], [10, 15], [1,20]] -> [10, 15], [2, 8]
 * </pre>
 * <pre>
 * Решения:
 *  0(n*log(n))) - сортировка + проход с проверкой пересечения
 *  [[1,20], [10, 15], [2, 10], [2, 8]] -> [10, 15], [2, 8]
 *  [[2, 8], [2, 10], [10, 15], [1,20]] -> [10, 15], [2, 8]
 * </pre>
 */
class TbankFindNonIntersectingSegments {
    static int[][] find(int[][] segments) {
        if (segments.length < 2) {
            return new int[][]{};
        }

        Arrays.sort(segments, Comparator.comparingInt(o -> o[1]));

        for (int i = 0; i < segments.length; i++) {
            for (int j = i + 1; j < segments.length; j++) {
                if (segments[i][1] < segments[j][0]) {
                    return new int[][]{segments[i], segments[j]};
                }
            }
        }

        return new int[][]{};
    }
}
