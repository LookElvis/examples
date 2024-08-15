package New2024;


// https://leetcode.cn/problems/implement-magic-dictionary/
class MagicDictionary {

    public TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        // 构建字典树
        for (String word: dictionary) {
            insert(word);
        }
    }

    public void insert(String word) {
        // 指向root
        TrieNode cur = root;
        // 将单词从root开始插入到字典树中
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.child[index] == null) {
                // 为空则增加到字典中
                cur.child[index] = new TrieNode();
            }
            // 遍历到
            cur = cur.child[index];
        }
        // 到叶子节点，isEnd为true
        cur.isEnd = true;

    }

    public boolean search(String searchWord) {
        // bfs搜索
        return magicBfs(searchWord, root, 0, false);
    }

    public boolean magicBfs(String searchWord, TrieNode cur, int pos, boolean isModify) {
        // 递归到最后一个字符时，判断是否修改过并返回结果
        // 字典树上的字母为边，因此为length而不需要-1
        if (pos == searchWord.length()) {
            return cur.isEnd && isModify;
        }

        int index = searchWord.charAt(pos) - 'a';
        // 字典树中有当前字符，继续向下寻找
        if (cur.child[index] != null) {
            if (magicBfs(searchWord, cur.child[index], pos+1, isModify)) {
                return true;
            }
        }

        // 字典树中没有当前字符且没有变更过时，尝试将当前字符变更为其它25个字符
        if (!isModify) {
            for (int i = 0; i < 26; i++) {
                // 变更时需要保证变更的字符在字典树中存在
                if (i != index && cur.child[i] != null) {
                    if (magicBfs(searchWord, cur.child[i], pos+1, true)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

class TrieNode {
    public boolean isEnd;
    public TrieNode[] child;
    public TrieNode() {
        isEnd = false;
        child = new TrieNode[26];
    }
}