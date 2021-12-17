package LeetCode.TH500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Solution_500
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/31 23:25
 * @Version 1.0
 */
public class Solution_500 {
    public String[] findWords(String[] words) {
        Map<Character,Integer> map = new HashMap<>();
        String str1 = "qwertyuiopQWERTYUIOP";
        String str2 = "asdfghjklASDFGHJKL";
        String str3 = "zxcvbnmZXCVBNM";
        ArrayList<String> strs = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i),1);
        }
        for (int i = 0; i < str2.length(); i++) {
            map.put(str2.charAt(i),2);
        }
        for (int i = 0; i < str3.length(); i++) {
            map.put(str3.charAt(i),3);
        }

        outFor:
        for (int i = 0; i < words.length; i++) {
            int num = map.get(words[i].charAt(0));
            for (int j = 0; j < words[i].length(); j++) {
                if (map.get(words[i].charAt(j)) != num){
                    continue outFor;
                }
            }
            strs.add(words[i]);
        }

       return strs.toArray(new String[0]);
    }
}
