package LeetCode.TH382;

/**
 * @ClassName Solution
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/1/16 5:48 AM
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.List;


/**
 * Definition for singly-linked list.
  */

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class Solution {
    ListNode linked;
    List<Integer> list = new ArrayList<>();
    public Solution(ListNode head) {
        linked = head;
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int rand = (int)(Math.random() * list.size());
        return list.get(rand);
    }
}

