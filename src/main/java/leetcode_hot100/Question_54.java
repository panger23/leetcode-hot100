package leetcode_hot100;

public class Question_54 {

}
class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root; // 新建指针指向根节点
        for(int i = 0;i < word.length();i++){ // 遍历每一个字母
            int u = word.charAt(i) - 'a'; // u = 0,1,2...
            if(p.tns[u] == null) p.tns[u] = new TrieNode();// 如果没有子树，新建这个树
            p = p.tns[u]; // p指向下一个节点
        }
        p.end = true;
    }

    public boolean search(String word) {
        TrieNode p = root; // 新建指针指向根节点
        for(int i = 0;i < word.length();i++){
            int u = word.charAt(i) - 'a';
            if(p.tns[u] == null) return false; // 如果某个字母没找到，说明不存在
            p = p.tns[u]; // p指向下一个节点
        }
        return p.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root; // 新建指针指向根节点
        for(int i = 0;i<prefix.length();i++){
            int u = prefix.charAt(i) - 'a';
            if(p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return true;
    }
}
class TrieNode{
    boolean end;
    TrieNode[] tns = new TrieNode[26];
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */