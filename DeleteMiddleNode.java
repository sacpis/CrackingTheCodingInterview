package CrackingTheCodingInterview;

public class DeleteMiddleNode {
    public boolean deleteMiddleNode(ListNode n){
        if(n == null || n.next == null){
            return false;
        }

        ListNode next = n.next;
        n.data = next.data;
        n.next = n.next.next;

        return true;
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data){
        this.data = data;
    }
}