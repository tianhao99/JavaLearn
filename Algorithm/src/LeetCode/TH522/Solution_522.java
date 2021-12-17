package LeetCode.TH522;

import java.util.*;

/**
 * @ClassName Solution_522
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/22 0:02
 * @Version 1.0
 */
public class Solution_522 {
    public int findLUSlength(String[] strs) {
        // return 1;
        if(strs.length == 0)
            return -1;
        Map<Integer, Map<String,Integer>> map = new HashMap();
        List<Integer> list = new ArrayList();
        for(int i = 0;i < strs.length;i++){
            if(map.get(strs[i].length()) == null){
                map.put(strs[i].length(),new HashMap<>());
            }
            list.add(strs[i].length());
            if (map.get(strs[i].length()).get(strs[i]) == null) {
                map.get(strs[i].length()).put(strs[i], 1);
            }else{
                map.get(strs[i].length()).put(strs[i],map.get(strs[i].length()).get(strs[i])+1);
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        int len;
        for (int i = 0; i < list.size(); i++) {
            len = list.get(i);
            for (int j = 0; j < map.get(len).keySet().size() ; j++) {
                if (map.get(i).values().iterator().next() == 1){
                    return i;
                }
            }
        }
        for(Integer i : list){
            for (int j = 0; j < map.get(i).keySet().size() ; j++) {
                if (map.get(i).values().iterator().next() == 1){
                    return i;
                }
            }
        }
        return -1;
    }
    private boolean isC(String str1,String str2){
        String maxStr;
        String minStr;
        if (str1.length() > str2.length()){
            maxStr = str1;
            minStr = str2;
        }else{
            maxStr = str2;
            minStr = str1;
        }
        for (int i = 0; i < minStr.length(); i++) {
            if (minStr.charAt(i) != maxStr.charAt(i))
                return false;
        }
        return true;
    }
}
