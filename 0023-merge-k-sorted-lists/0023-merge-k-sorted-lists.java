/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode merge(ListNode left,ListNode right){
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        while(left!=null && right!=null){
            if(left.val<right.val){
                temp.next=left;
                left=left.next;
            }
            else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }
        temp.next=(left==null)?right:left;
        return dummy.next;
    }
    ListNode divide(int low,int high,ListNode lists[]){
        if(low>high)
            return null;
        if(low==high)
            return lists[high];

        int mid=low+(high-low)/2;

        ListNode left=divide(low,mid,lists);
        ListNode right=divide(mid+1,high,lists);

        return merge(left,right);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(0,lists.length-1,lists);
    }
}