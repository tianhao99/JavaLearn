package LeetCode.TH335;

/**
 * @ClassName Solution_335
 * @Description TODO:335. 路径交叉
 * 给你一个整数数组 distance 。
 *
 * 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 *
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
 * @Author sth_199509@163.com
 * @Date 2021/10/29 17:02
 * @Version 1.0
 */
public class Solution_335 {
    public boolean isSelfCrossing(int[] distance) {
        for (int i = 3; i < distance.length; i++) {
            if (distance[i] >= distance[i-2] && distance[i-1] <= distance[i-3]){
                return true;
            }
            if (i == 4 && distance[1] == distance[3] && distance[0] + distance[4] == distance[2]){
                return true;
            }
            if (i >= 5 && distance[i-1] >= distance[i-3]-distance[i-5] && distance[i-1] <= distance[i-3] &&
                    distance[i] >= distance[i-2] - distance[i-4] && distance[i-2] >= distance[i-4]){
                return true;
            }

        }
        return false;
    }
    /*               i-2
    case 1 : i-1┌─┐
                └─┼─>i
                 i-3

                    i-2
    case 2 : i-1 ┌────┐
                 └─══>┘i-3
                 i  i-4      (i overlapped i-4)

    case 3 :    i-4
               ┌──┐
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2

*/
}
