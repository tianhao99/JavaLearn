package LeetCode.TH299;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution_299
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/8 20:16
 * @Version 1.0
 */
public class Solution_299 {
    @Test
    public void test(){
        String hint = getHint("1122", "2211");
        System.out.println(hint);
    }
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        HashMap<Character,Integer> list = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)){
                bulls++;
                secret = secret.substring(0,i) + secret.substring(i+1);
                guess = guess.substring(0,i) + guess.substring(i+1);
                i--;
            }else{
                list.put(secret.charAt(i),list.get(secret.charAt(i)) == null? 1:list.get(secret.charAt(i))+1);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (list.containsKey(guess.charAt(i)) && list.get(guess.charAt(i)) != 0){
                cows++;
                list.put(guess.charAt(i),list.get(guess.charAt(i))-1);
            }
        }
        return bulls + "A" + cows +"B";
    }
}
