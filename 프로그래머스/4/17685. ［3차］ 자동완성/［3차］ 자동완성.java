import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count; 
    }

    static TrieNode root = new TrieNode();

    public int solution(String[] words) {
        for (String word : words) {
            insert(word);
        }

        int answer = 0;

        for (String word : words) {
            answer += search(word);
        }

        return answer;
    }

    private void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
            current.count++;
        }
    }

    private int search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            current = current.children[index];

            if (current.count == 1) {
                return i + 1;
            }
        }

        return word.length();
    }
}