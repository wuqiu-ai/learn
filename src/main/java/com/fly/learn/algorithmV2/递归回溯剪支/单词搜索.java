package com.fly.learn.algorithmV2.递归回溯剪支;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *  
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: peijiepang
 * @date 2021/7/27
 * @Description:
 */
public class 单词搜索 {

    public static void main(String[] args) {
        单词搜索 test = new 单词搜索();
        char[][] board = {{'a','a'}};
        String word = "aa";
        test.exist(board,word);
    }

    public boolean exist(char[][] board, String word) {
        // 列
        int columns = board[0].length;
        // 行
        int rows = board.length;
        boolean[][] visited = new boolean[rows][columns];
        // 迭代初始节点
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                boolean result = dfs(board,word.toCharArray(),visited,i,j,0);
                if(result){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param board
     * @param word 匹配字符
     * @param row 初始行
     * @param column 初始列
     * @param begin 匹配到哪个字符
     * @return
     */
    private boolean dfs(char[][] board,char[] word,boolean[][] visited,int row,int column,int begin){
        if(board[row][column] != word[begin]){
            return false;
        }else if(begin == (word.length-1)){
            return true;
        }
        visited[row][column] = true;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean result = false;
        for(int[] dir:directions){
            int newRow = row + dir[0];
            int newColumn = column + dir[1];
            if(newRow >= 0 && newRow < board.length && newColumn >= 0 && newColumn < board[0].length){
                if(!visited[newRow][newColumn]){
                    boolean bol = dfs(board,word,visited,newRow,newColumn,begin + 1);
                    if(bol){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[row][column] = false;
        return result;
    }

}
