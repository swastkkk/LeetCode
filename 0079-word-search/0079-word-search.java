class Solution {
    int Row=0;
    int Column=0;
    boolean[][]visited;
    boolean dfs(int r,int c,int i, String word,char[][] board){
        if(i==word.length())
            return true;
        if(r<0 || c<0 || r>=Row || c>=Column)
            return false;
        if(visited[r][c] || board[r][c]!=word.charAt(i))
            return false;
        visited[r][c]=true;

        boolean res=(dfs(r+1,c,i+1,word,board) || dfs(r-1,c,i+1,word,board) || dfs(r,c-1,i+1,word,board) || dfs(r,c+1,i+1,word,board));

        visited[r][c]=false;
        return res;
    }
    public boolean exist(char[][] board, String word) {
        Row=board.length;
        Column=board[0].length;
        visited=new boolean[Row][Column];
        int i=0;
        for(int r=0;r<Row;r++){
            for(int c=0;c<Column;c++){
               if(dfs(r,c,i,word,board))
                    return true;
            }
        }
        return false;
    }
}