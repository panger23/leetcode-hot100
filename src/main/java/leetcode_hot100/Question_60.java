package leetcode_hot100;

class Question_60 {
    char[] words;
    int l; // 单词长度
    char[][] board; // 图
    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 记录四个方向
    public boolean exist(char[][] board, String word) {
        int[] cnt = new int[128];
        for(char[] row : board){ // 数组代替哈希表
            for(char c : row){
                cnt[c]++;
            }
        }

        this.board = board;
        this.words = word.toCharArray();
        this.l = words.length;

        int[] wordCnt = new int[128];
        for(char c : words){  // 优化1
            if(++wordCnt[c] > cnt[c]){
                return false;
            }
        }
        if(cnt[words[words.length - 1]] < cnt[words[0]]){ // 优化2
            words = new StringBuilder(word).reverse().toString().toCharArray();
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(dfs(i,j,0)){
                    return true; // 搜到了！
                }
            }
        }
        return false; // 没搜到
    }
    public boolean dfs(int x,int y,int l){
        if(board[x][y] != words[l]) return false; // 匹配失败
        if(l == words.length - 1) return true; // 匹配成功！
        board[x][y] = 0; // 标记访问过
        // 不选这个行
        for(int[] d : DIRS){ // 四个方向
            int i = x + d[0];
            int j = y + d[1];
            if(i>=0&&i<board.length&&j>=0&&j<board[i].length&&dfs(i,j,l+1)){
                return true;
            }
        }
        board[x][y] = words[l]; // 回溯
        return false;
    }
}