//https://leetcode.com/problems/word-search/
class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isWord;

        public TrieNode(){
            children = new TrieNode[256];
            isWord = false;
        }
    }
    TrieNode root;
    private TrieNode buildTrie(String word){
        TrieNode branch = root;
        for(char c: word.toCharArray()){
            if(branch.children[c-'a'+64] == null){
                branch.children[c-'a'+65] = new TrieNode();
            }
            branch = branch.children[c-'a'+65];
        }
        branch.isWord = true;
        return root;
    }
    public boolean exist(char[][] board, String word) {
        root = new TrieNode();
        TrieNode trie = buildTrie(word);

        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(trie.children[board[i][j] -'a'+64] != null && dfs(board, trie, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, TrieNode trie, int i, int j){
        if(trie.isWord){
            return true;
        }
        if(i <0 || j <0 || i> board.length-1 || j > board[0].length -1 
            || trie.children[board[i][j] -'a' +65] == null){
            return false;
        }
        char currChar = board[i][j];
        char temp = board[i][j];
        board[i][j] = ' '; // acts as visited mark

        if(dfs(board, trie.children[currChar - 'a' + 65], i+1, j) ||
        dfs(board, trie.children[currChar - 'a' +65], i-1, j) ||
        dfs(board, trie.children[currChar - 'a' +65], i, j+1) ||
        dfs(board, trie.children[currChar - 'a' +65], i, j-1)
        ){
            return true;
        }

        board[i][j] = temp;
        return false;
    }
}
