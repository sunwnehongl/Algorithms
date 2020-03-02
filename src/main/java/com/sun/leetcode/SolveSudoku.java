package com.sun.leetcode;

import java.util.*;

/**
 * @Auther: swh
 * @Date: 2020/2/29 22:06
 * @Description:
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveSudoku {
    public static void main(String[] args) {
        char[][] data = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        char[][] data1 ={
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}
        };
        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solveSudoku(data1);
        for (int x= 0;x<=8;x++ ) {
            for (int y= 0;y<=8;y++ ) {
                System.out.print(" "+data1[x][y]);
            }
            System.out.println(" ");
        }
    }

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 1);
    }

    private boolean solveSudoku(char[][] board,int start) {

        if (start > 81) {
            return true;
        }
        int i = (start - 1) / 9;
        int j = (start - 1) % 9;
        int basic = Integer.valueOf('0');
        if (board[i][j] == '.') {
            List<Integer> list = getNum(board, start);
            for (int k = 0; k < list.size(); k++) {
                board[i][j] = (char) (basic +list.get(k));
                if (solveSudoku(board,start+1)) {
                    return true;
                }else{
                    board[i][j] = '.';
                }
            }
            return false;
        }else{
            return solveSudoku(board, start + 1);
        }
    }

    private List<Integer> getNum(char[][] board, int start) {
        int i = (start - 1) / 9;
        int j = (start - 1) % 9;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != '.') {
                set.add(Integer.parseInt(String.valueOf(board[i][k])));
            }
            if (board[k][j] != '.') {
                set.add(Integer.parseInt(String.valueOf(board[k][j])));
            }
        }
        int iStart = i - i % 3;
        int jStart = j - j % 3;
        for (int x= iStart;x<=iStart+2;x++ ) {
            for (int y= jStart;y<=jStart+2;y++ ) {
                if (board[x][y] != '.') {
                    set.add(Integer.parseInt(String.valueOf(board[x][y])));
                }
            }
        }
        for (int z = 1; z <= 9; z++) {
            if (!set.contains(z)) {
                list.add(z);
            }
        }
        return list;
    }

}
