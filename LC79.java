// class Solution {
//     public boolean exist(char[][] board, String word) {
//         int m = board.length;
//         int n = board[0].length;

//         int i=0;
//         int b[][] = new int[m][n];

//         for(int j=0;j<m;j++){
//             for(int k=0;k<n;k++){
//                 if(word.charAt(0)==board[j][k]){
//                     if(fun(j,k,0,word,board,b)) return true;
//                 }
    
//             }
//         }

//         return false;
//     }

//     public boolean fun(int i,int j,int k,String w,char[][] a, int[][] b){
        
//         if(i<0 || j<0 || i>=a.length || j>=a[0].length) return false;
        
//         if(k+1==w.length()){
//             if(a[i][j]==w.charAt(k)){
//                 return true;
//             }
//             return false;
//         }

//         if(a[i][j]==w.charAt(k)){
//             b[i][j]=1;
//             for(int l=-1;l<=1;l++){
//                 if(i+l>=0 && (i+l<a.length && b[i+l][j]!=1)){
//                     if(fun(i+l,j,k+1,w,a,b)) return true;
//                 }

//                 if(j+l>=0 && (j+l<a[0].length && b[i][j+l]!=1)){
//                     if(fun(i,j+l,k+1,w,a,b)) return true;
//                 }
//             }
//             b[i][j]=0;
//         }

//         return false;
//     }
// }




class Solution211 {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        char[] wordChar = word.toCharArray();
        if (wordChar.length > n * m)
            return false;
        int counts[] = new int[256];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                counts[board[i][j]]++;
            }
        }
        int len = wordChar.length;
        for(int i=0; i<len/2; i++)
        {
            if(counts[wordChar[i]]>counts[wordChar[len-1-i]]){
                for(int j=0; j<len/2; j++)
                {
                    char temp = wordChar[j];
                    wordChar[j]=wordChar[len-1-j];
                    wordChar[len-1-j]=temp;
                }
                break;
            }
        }
        for (char c : wordChar) {
            if (--counts[c] < 0)
                return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit(board, wordChar, 0, i, j, n, m, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean visit(char[][] board, char[] word, int start, int x, int y,
            int n, int m, boolean[][] visited) {
        if (start == word.length)
            return true;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y])
            return false;
        if (word[start] != board[x][y])
            return false;
        visited[x][y] = true;
        boolean found = visit(board, word, start + 1, x + 1, y, n, m, visited)
                || visit(board, word, start + 1, x - 1, y, n, m, visited)
                || visit(board, word, start + 1, x, y + 1, n, m, visited)
                || visit(board, word, start + 1, x, y - 1, n, m, visited);
        visited[x][y] = false;
        return found;
    }
}