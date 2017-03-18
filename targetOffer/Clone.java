package tim.targetOffer;

public class Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode cur = pHead;
        RandomListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            RandomListNode node = new RandomListNode(cur.label);
            cur.next = node;
            node.next = tmp;
            cur = tmp;
        }

        cur = pHead;
        RandomListNode newCur = cur.next;
        while (cur != null) {
            if (cur.random != null) {
                newCur.random = cur.random.next;
            }
            cur = newCur.next;
            if (cur != null) {
                newCur = cur.next;
            }
        }

        RandomListNode newHead = pHead.next;
        cur = pHead;
        newCur = cur.next;
        while (cur != null) {
            cur.next = newCur.next;
            cur = cur.next;
            if (cur != null) {
                newCur.next = cur.next;
                newCur = newCur.next;
            }
        }

        return newHead;
    }
}
