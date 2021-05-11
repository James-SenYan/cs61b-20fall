import java.util.HashSet;

/**
 * @author Sen Yan
 * @create 2021-04-23-18:39
 */
public class SLList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode result = new ListNode(-1);
        ListNode first = result;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                first.next = new ListNode(l1.val);
                first = first.next;
                l1 = l1.next;
            }else{
                first.next = new ListNode(l2.val);
                first = first.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            first.next = l2;
        }else{
            first.next = l1;
        }
        return result.next;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode first = result;
        int plus = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + plus;
            first.next = new ListNode(sum % 10);
            first = first.next;
            plus = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null){
            while (l2 != null){
                int sum = l2.val + plus;
                first.next = new ListNode(sum % 10);
                first = first.next;
                plus = sum / 10;
                l2 = l2.next;
            }
        }else{
            while (l1 != null){
                int sum = l1.val + plus;
                first.next = new ListNode(sum % 10);
                first = first.next;
                plus = sum / 10;
                l1 = l1.next;
            }
        }
        if(plus != 0){
            first.next = new ListNode(plus);
        }
        return result.next;
    }


    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Object> set = new HashSet<>();
        ListNode result = new ListNode(-1);
        ListNode first = result;
        while (head != null){
            if (set.add(head.val)){
                first.next = new ListNode(head.val);
                first = first.next;
            }
            head = head.next;
        }
        return result.next;
    }
/*
leetcode 23
合并k个升序链表
给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode first = result;
        if (lists.length == 1){
            first.next = lists[0];
        }else{

         }

        return result.next;
    }
}
