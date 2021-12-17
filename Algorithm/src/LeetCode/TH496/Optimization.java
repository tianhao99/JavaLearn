package LeetCode.TH496;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * @ClassName Optimization
 * @Description TODO:元素入栈之前，先入哈希表，因为此时栈顶元素就是下一个更大元素，直接记录
 * @Author sth_199509@163.com
 * @Date 2021/10/26 20:19
 * @Version 1.0
 */
public class Optimization {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                //该元素大于栈顶，出栈----直到小于栈顶，或者栈空
                stack.pop();
            }
            //【此时num小于栈顶元素，栈顶元素就是它的下一个更大元素，入哈希表，再入栈】
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
