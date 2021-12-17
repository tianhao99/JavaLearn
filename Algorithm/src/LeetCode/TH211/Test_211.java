package LeetCode.TH211;

/**
 * @ClassName Test_211
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/19 21:58
 * @Version 1.0
 */
public class Test_211 {
    public static void main(String[] args) {
        WordDictionary wordList = new WordDictionary();
        wordList.addWord("bad");
        wordList.addWord("dad");
        wordList.addWord("mad");
        System.out.println(wordList.search("wq"));
        System.out.println(wordList.search("mad"));
        System.out.println(wordList.search("m.d"));
        System.out.println(wordList.search("pad"));
        System.out.println(wordList.search("bad"));
        System.out.println(wordList.search(".ad"));
        System.out.println(wordList.search("b.."));
//        wordDictionary.search("pad"); // return False
//        wordDictionary.search("bad"); // return True
//        wordDictionary.search(".ad"); // return True
//        wordDictionary.search("b.."); // return True

    }
}
