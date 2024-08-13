package New2024;


// https://leetcode.cn/problems/implement-magic-dictionary/
class MagicDictionary {

    public TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String word: dictionary) {
            insertTrie(word);
        }
    }

    public boolean magicDfs(String searchWord, TrieNode node, int pos, boolean isModify) {
        // 到叶子节点递归结束
        if (pos == searchWord.length()) {
            return node.isEnd && isModify;
        }

        int index = searchWord.charAt(pos) - 'a';
        // 字典树中存在searchWord的当前字符，递归下一个字符
        if (node.children[index] != null) {
            // 此处不能直接return，因为可能还没修改过
            if (magicDfs(searchWord, node.children[index], pos+1, isModify)) {
                return true;
            }
        }

        // 没有修改过时，修改当前pos为任意一个进行递归
        if (!isModify) {
            for (int i = 0; i < 26; i++) {
                // 没有变更过字母时，假设变更当前字母
                if (i != index && node.children[i] != null) {
                    // 此处不能直接return，因为可能换一个字母进行修改就成功了
                    if (magicDfs(searchWord, node.children[i], pos+1, true)) {
                        return true;
                    }
                }
            }
        }

        // 没有任何可能时才返回false
        return false;
    }

    public boolean search(String searchWord) {
        return magicDfs(searchWord, root, 0, false);
    }

    public void insertTrie(String word) {
        // 写入前缀树
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            // 不为空则写入
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        // 叶子节点
        cur.isEnd = true;
    }
}

class TrieNode {
    public boolean isEnd = false;
    public TrieNode[] children;
    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
    }

}
