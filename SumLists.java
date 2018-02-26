package CrackingTheCodingInterview;

public class SumLists {
    public ListNode addLists(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }

        ListNode result = new ListNode(0);

        int value = carry;
        if(l1 != null){
            value += l1.data;
        }

        if(l2 != null){
            value += l2.data;
        }

        result.data = value % 10;

        if(l1 != null || l2 != null){
            ListNode more = addLists(l1 == null ? null : l1.next,
                                    l2 == null ? null : l2.next,
                                    value >= 10 ? 1 : 0);
            result.next = more;
        }

        return result;
    }
}
