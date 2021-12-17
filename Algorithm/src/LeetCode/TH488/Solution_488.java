package LeetCode.TH488;

import java.util.HashMap;

/**
 * @ClassName Solution_488
 * @Description TODO:祖玛游戏
 * board = "WWRRBBWW", hand = "WRBRW"
 * 输出：2
 * 解释：要想清空桌面上的球，可以按下述步骤：
 * - 插入一个 'R' ，使桌面变为 WWRRRBBWW 。WWRRRBBWW -> WWBBWW
 * - 插入一个 'B' ，使桌面变为 WWBBBWW 。WWBBBWW -> WWWW -> empty
 * 只需从手中出 2 个球就可以清空桌面。
 *
 * @Author sth_199509@163.com
 * @Date 2021/11/9 20:46
 * @Version 1.0
 */


//不会做
//public class Solution_488 {
//    public int findMinStep(String board, String hand) {
//        int borLen = board.length();
//        int hanLen = hand.length();
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < borLen; i++) {
//            map.put(hand.charAt(i),map.get(hand.charAt(i)) == null ? 1 : map.get(hand.charAt(i)) + 1);
//        }
//        while(borLen > 0 && hanLen > 0){
//            if ()
//        }
//    }
//}
