package algorithm.template;


import java.util.*;

class SentenceSimilarity {
    // 并查集的合并操作
    private void union(Map<String, String> parent, String word1, String word2) {
        String root1 = find(parent, word1);
        String root2 = find(parent, word2);
        if (!root1.equals(root2)) {
            parent.put(root1, root2);
        }
    }

    // 并查集的查找操作，带路径压缩
    private String find(Map<String, String> parent, String word) {
        if (!parent.containsKey(word)) {
            parent.put(word, word); // 初始化节点的根节点为自己
        }
        if (!parent.get(word).equals(word)) {
            parent.put(word, find(parent, parent.get(word))); // 路径压缩
        }
        return parent.get(word);
    }

    // 判断两个句子是否相似
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        // 使用 HashMap 来存储每个单词的根节点
        Map<String, String> parent = new HashMap<>();

        // 将所有相似关系建立并查集
        for (List<String> pair : pairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            union(parent, word1, word2);
        }

        // 检查每对单词是否具有相同的根节点
        for (int i = 0; i < words1.length; i++) {
            String root1 = find(parent, words1[i]);
            String root2 = find(parent, words2[i]);
            if (!root1.equals(root2)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SentenceSimilarity solution = new SentenceSimilarity();

        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
        List<List<String>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList("great", "fine"));
        pairs.add(Arrays.asList("acting", "drama"));
        pairs.add(Arrays.asList("skills", "talent"));
        System.out.println(solution.areSentencesSimilarTwo(words1, words2, pairs)); // Output: true

        String[] words3 = {"great"};
        String[] words4 = {"great"};
        List<List<String>> pairs2 = new ArrayList<>();
        System.out.println(solution.areSentencesSimilarTwo(words3, words4, pairs2)); // Output: true
    }
}
