package tim.leetcode;

import java.util.HashMap;
import java.util.Map;

public class __138_CopyListwithRandomPointer {
    
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode (int x) {
            this.label = x;
        }
    }

    /*
     * One List Version.
     * Time:  O(N), 遍历2遍List
     * Space: O(1)
     */
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        //copy next
        RandomListNode cur = head; 
        while (cur != null) {
            RandomListNode curNext = cur.next;
            RandomListNode node = new RandomListNode(cur.label);
            node.next = curNext;
            cur.next = node;
            cur = curNext;
        }

        //copy random
        cur = head; 
        while (cur != null && cur.next != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //split
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = head.next.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }

        return newHead;
    }
    
    /*
     *  HashMap Version
     *  Time:    O(N), 遍历一边List，但是要查表N次。
     *  Space:   O(N) 
     */
    public RandomListNode copyRandomList2(RandomListNode head) {

        Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newNode;
        while (head != null) {
            if (!map.containsKey(head)) {
                newNode = new RandomListNode(head.label); 
                map.put(head, newNode);
            } else {
                newNode = map.get(head);
            }
            pre.next = newNode;

            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                } else {
                    newNode.random = map.get(head.random);
                }
            }
            pre = pre.next;
            head = head.next;
        }
            
        return dummy.next;
    }
    
    
    
    /*
     * Time: O(N^2) 
     */
    public RandomListNode copyRandomList3(RandomListNode head) {
        
        Map<Integer,Integer> oldMap = new HashMap<Integer,Integer>(); 

        RandomListNode cur = head;
        RandomListNode curTmp = head; 
        for (int i = 0; cur != null; ++i, cur = cur.next) {
            curTmp = head; 
            if (cur.random != null) {
                for (int j = 0; curTmp != cur.random; ++j) {
                    oldMap.put(i, j);
                    curTmp = curTmp.next;
                } 
            } else { 
                oldMap.put(i, -1); 
            }
        }

        RandomListNode newDummy = new RandomListNode(0);
        RandomListNode pre = newDummy;
        cur = head;
        while (cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            pre.next = node;
            pre = pre.next;
            cur = cur.next;
        }

        RandomListNode newCur = newDummy.next;
        RandomListNode newCurTmp = newDummy.next;
        for (int i = 0; newCur != null; ++i) {
            if (oldMap.get(i) == null) {
                continue;
            } 
            int N = oldMap.get(i);
            if (N != -1) {
                newCurTmp = newDummy.next;
                for (int j = 0; j < N; ++j, newCur = newCur.next) {
                    newCurTmp = newCurTmp.next;
                }
                newCur.random = newCurTmp;
            } else {
                newCur.random = null;    
            }
        }

        return newDummy.next;
    }

}

