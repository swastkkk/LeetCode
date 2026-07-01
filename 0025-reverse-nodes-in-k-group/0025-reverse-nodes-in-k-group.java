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
    void reverse(ListNode curr,ListNode last){
        ListNode end=last.next;
        ListNode prev=last.next;
        while(curr!=null && curr!=end){
           ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0,head);
          ListNode groupPrev=dummy;
        while(true){
            int i;
            ListNode temp=groupPrev;
            for(i=1;i<=k;i++){
                if(temp==null)
                    break;
                temp=temp.next;
            }
            if(temp==null)
                break;
            
            ListNode groupFirst=groupPrev.next;
            ListNode groupLast=temp;
            ListNode groupNext=groupLast.next;
            reverse(groupFirst,groupLast);
            groupPrev.next=groupLast;
            groupPrev=groupFirst;
        }
        return dummy.next;
    }
}