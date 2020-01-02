package ru.job4j.array;

public class MatrixCheck {
    public static boolean isWin(char[][] board) {
        boolean result = false;
        int count = 0;
        // ДЛЯ СТРОК
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board [i] [j] == 'X') {
                    ++count;
                    if (count == 5)
                        return result = true;
                }
                if (j == 4)
                    count = 0;
            }
        }
        // ДЛЯ СТОЛБЦОВ
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board [j] [i] == 'X') {
                    ++count;
                    if (count == 5)
                        return result = true;
                }
                if (j == 4)
                    count = 0;
            }
        }
        return result;
    }
}
