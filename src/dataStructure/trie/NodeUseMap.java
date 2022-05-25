package dataStructure.trie;

import java.util.HashMap;
import java.util.Map;

public class NodeUseMap {
    private final Map<Character, NodeUseMap> childNode = new HashMap<>();
    private boolean isEndOfWord;

    public Map<Character, NodeUseMap> getChildNode() {
        return childNode;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}