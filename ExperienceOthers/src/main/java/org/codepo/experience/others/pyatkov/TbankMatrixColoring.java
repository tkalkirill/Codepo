package org.codepo.experience.others.pyatkov;

/**
 * <pre>
 * Сколько понадобится закрасок, чтобы закрасить матрицу
 *  [1, 1, 2, 3]
 *  [1, 2, 2, 1] -> 4
 *  [1, 1, 2, 1]
 * </pre>
 * <pre>
 * Решение:
 *  Это использовать поиск в глубину.
 *  Нам достаточно вычислить количество "островков" с одинаковым значением.
 *  Берем любую клетку и находим все соседние с таким-же значением поиском в глубину.
 *  Когда пройдем все клетки значит мы узнали число островков таким и будет результат.
 * </pre>
 */
class TbankMatrixColoring {
    static int painting(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int colors = 0;

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }

                colors++;

                dfs(matrix, visited, i, j, matrix[i][j]);
            }
        }

        return colors;
    }

    private static void dfs(int[][] matrix, boolean[][] visited, int i, int j, int value) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) {
            return;
        }

        if (visited[i][j] || matrix[i][j] != value) {
            return;
        }

        visited[i][j] = true;

        dfs(matrix, visited, i + 1, j, matrix[i][j]);
        dfs(matrix, visited, i - 1, j + 1, matrix[i][j]);
        dfs(matrix, visited, i, j + 1, matrix[i][j]);
        dfs(matrix, visited, i, j - 1, matrix[i][j]);
    }
}
