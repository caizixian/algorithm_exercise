class TrieNode {
    TrieNode[] branch;
    boolean mark;

    // Initialize your data structure here.
    public TrieNode() {
        branch = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String a, TrieNode root) {
        if (a.length() > 0) {
            TrieNode b = root.branch[a.charAt(0) - 'a'];
            if (b == null) {
                root.branch[a.charAt(0) - 'a'] = new TrieNode();
            }
            if (a.length() == 1) {
                root.branch[a.charAt(0) - 'a'].mark = true;
            }
            insert(a.substring(1), root.branch[a.charAt(0) - 'a']);
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String a, TrieNode root) {
        if (a.length() == 0) {
            return root.mark;
        }
        TrieNode b = root.branch[a.charAt(0) - 'a'];
        if (b == null) {
            return false;
        } else {
            return search(a.substring(1), b);
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    private boolean startsWith(String a, TrieNode root) {
        if (a.length() == 0) {
            return true;
        }
        TrieNode b = root.branch[a.charAt(0) - 'a'];
        if (b == null) {
            return false;
        } else {
            return startsWith(a.substring(1), b);
        }
    }
}