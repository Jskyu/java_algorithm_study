package dataStructure.trie;

public class Main {
    public static void main(String[] args) {
        TrieUseMap trieUseMap = new TrieUseMap();
        trieUseMap.insert("abc");
        System.out.println("trieUseMap.search(\"ab\") = " + trieUseMap.search("ab"));
        System.out.println("trieUseMap.search(\"abc\") = " + trieUseMap.search("abc"));
        System.out.println("trieUseMap.search(\"abcd\") = " + trieUseMap.search("abcd"));
    }
}
