class TrieNode {
    TrieNode[] branch;
    boolean mark;

    // Initialize your data structure here.
    public TrieNode() {
        branch = new TrieNode[26];
    }
}

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        addWord(word, root);
    }

    private void addWord(String a, TrieNode root) {
        if (a.length() > 0) {
            TrieNode b = root.branch[a.charAt(0) - 'a'];
            if (b == null) {
                root.branch[a.charAt(0) - 'a'] = new TrieNode();
            }
            if (a.length() == 1) {
                root.branch[a.charAt(0) - 'a'].mark = true;
            }
            addWord(a.substring(1), root.branch[a.charAt(0) - 'a']);
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String a, TrieNode root) {
        if (a.length() == 0) {
            return root.mark;
        }
        if (a.charAt(0) == '.') {
            // Wildcard
            for (TrieNode n : root.branch) {
                if (n != null) {
                    if (search(a.substring(1), n)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            TrieNode b = root.branch[a.charAt(0) - 'a'];
            if (b == null) {
                return false;
            } else {
                return search(a.substring(1), b);
            }
        }
    }
}