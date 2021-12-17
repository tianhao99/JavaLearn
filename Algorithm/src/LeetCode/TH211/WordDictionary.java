package LeetCode.TH211;

import java.util.*;

/**
 * @ClassName WordDictionary
 * @Description TODO:暴力会超时，此处将存储的单词按长度分类，避免了超时。最好的解法是【前缀树】
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 * @Author sth_199509@163.com
 * @Date 2021/10/19 21:59
 * @Version 1.0
 */
public class WordDictionary {
    private Map<Integer, Set<String>>  map;//创建一个二维哈希表
    public WordDictionary() {
        map = new HashMap<>();
    }

    //添加单词
    public void addWord(String word) {
        if (map.get(word.length()) == null){//如果没有该长度的，创建一个HashSet
            map.put(word.length(),new HashSet<>());
        }
        map.get(word.length()).add(word);//存在不创建，不存在创建，然后添加元素
    }
    //搜索单词
    public boolean search(String word) {
        if (map.get(word.length()) == null)//没有该长度的，肯定不存在，直接返回
            return false;
        if (ConChar(word)){//判断是否存在相等的
            return true;
        }
        return false;
    }

    private boolean ConChar(String word){
        label:
        for (String str : map.get(word.length())){//遍历HashSet中的元素
            for (int i = 0; i < str.length(); i++) {//逐个对比字母，存在不相等同时不是'.'直接退出，继续下一个单词
                if(str.charAt(i) != word.charAt(i) && str.charAt(i)!='.' && word.charAt(i)!='.'){
                    continue label;//继续外层循环
                }
            }
            return true;//成功对比到最后，没有跳出，证明相等
        }
        return false;//执行到最后，表名HashSet中没有匹配的，返回false
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */