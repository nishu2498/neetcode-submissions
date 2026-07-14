/**
 * Valid Sudoku
 * 
 * You are given a 9*9 sudoku board. A sudoku board is valid if the following
 * rules are followed:
 * 1. Each row must contain the digits 1-9 without duplicates
 * 2. Each column must contain the digits 1-9 without duplicates
 * 3. Each of the nine 3*3 sub-boxes of the grid must contain the digits
 * 1-9 without duplicates
 * 
 * return true if the sudoku board is valid, otherwise return false
 * 
 * Input: board =
 * [["1","2",".",".","3",".",".",".","."],
 * ["4",".",".","5",".",".",".",".","."],
 * [".","9","8",".",".",".",".",".","3"],
 * ["5",".",".",".","6",".",".",".","4"],
 * [".",".",".","8",".","3",".",".","5"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".",".",".",".",".",".","2",".","."],
 * [".",".",".","4","1","9",".",".","8"],
 * [".",".",".",".","8",".",".","7","9"]]
 *
 * Output: true
 * 
 * Input: board =
 * [["1","2",".",".","3",".",".",".","."],
 * ["4",".",".","5",".",".",".",".","."],
 * [".","9","1",".",".",".",".",".","3"],
 * ["5",".",".",".","6",".",".",".","4"],
 * [".",".",".","8",".","3",".",".","5"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".",".",".",".",".",".","2",".","."],
 * [".",".",".","4","1","9",".",".","8"],
 * [".",".",".",".","8",".",".","7","9"]]
 *
 * Output: false
 * 
 * To solve this problem, we need some data structure that helps us check
 * if there are some duplicate numbers, where we can use hashSet.
 * Now since we have a fixed constraint of 9 * 9 rows by columns,
 * we could have 9 hashSets for rows and 9 hashSets for columns.
 * Also along with that we have 9 boxes of 3*3 grids, so we could have 9 
 * hashSets for those boxes.
 * We can identify which box, current element would belong to using 
 * ((row/3) * 3 + (col/3)) formula
 * 
 * for 9 * 9 bigger square, we can see that it can be further divided 
 * into 3 * 3 small squares, where smaller squares in 0,1,2 rows could be
 * considered as 0th with formula (floor(row/3) * 3 + floor(col/3)),
 * similar cases for identifying the elements in other minor squares.
 * Leetcode_Valid_Sudoku
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // since we already have board size already fixed to 9
        int N = 9;

        // lets create and initialize 3 different hashsets for rows, columns and boxes
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] columns = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for(int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            columns[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        // lets iterate through the board to find numbers in our hashsets
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                // lets find out value first
                char val = board[r][c];

                if (val == '.') {
                    continue;
                }

                // check in rows hashset
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // check in columns hashset
                if (columns[c].contains(val)) {
                    return false;
                }
                columns[c].add(val);

                int index = (r/3) * 3 + (c/3);
                if (boxes[index].contains(val)) {
                    return false;
                }
                boxes[index].add(val);
            }
        }

        return true;
    }
}
