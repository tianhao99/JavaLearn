//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode point = null;
        int temp = 0;
        while(l1 != null || l2 != null){
            //短的链表空了，就取0，不影响计算
            int n1 =  l1 == null ? 0:l1.val;
            int n2 =  l2 == null ? 0:l2.val;
            int sum = n1 + n2 + temp;
            if (head == null){//第一次，创建头节点
                head = point = new ListNode(sum % 10);
            }else{//赋值，向下遍历
                point.next = new ListNode(sum % 10);
                point = point.next;
            }
            temp = sum / 10;//小于10，结果时0；大于10，结果是1；
            //不空的，向下遍历
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        //最后一位，大于10，进1
        if (temp > 0)
            point.next = new ListNode(temp);
        return head;
    }
}