package com.xd;

public class Implement {
    public boolean isValidSudoku(char[][] board) {
        short[] rows = new short[9];
        short[] cols = new short[9];
        short[] boxes = new short[9];
        short cur;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num == '.') continue;
                num -= '1';
                cur = (short) (1 << num);
                /*
                *  011110011                011110011
                * &000001000               &000010000
                * ------------             ------------
                *  000000000                000010000
                * 如果某些位上的值为1，最终&出来的结果是非0，所以不能用 == 0 来进行判断
                * */
                if ((rows[row] & cur) != 0) return false;
                if ((cols[col] & cur) != 0) return false;
                int boxIndex = (col / 3) * 3 + (row / 3);
                if ((boxes[boxIndex] & cur) != 0) return false;
                rows[row] |= cur;
                cols[col] |= cur;
                boxes[boxIndex] |= cur;
            }
        }
        return true;
    }
    public boolean isValidSudoku1(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num == '.') continue;
                num -= '1';
                if (rows[row][num]) return false;
                if (cols[col][num]) return false;
                int boxIndex = (col / 3) * 3 + (row / 3);
                if (boxes[boxIndex][num]) return false;
                rows[row] [num]= true;
                cols[col][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}
