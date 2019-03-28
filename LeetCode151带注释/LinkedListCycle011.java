package leetcode151withexplain;

/**
 * �������ж�һ���������Ƿ���ڻ�����ô�Ϳ���ͨ������ָ�룬һ���ߵĿ죬һ���ߵ���������ܹ��غϣ���ô��˵�����ڻ�
 * 
 *
 */
public class LinkedListCycle011 {

	class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	}
	
	public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        if(head.next == head){
            return true;
        }
        
        ListNode circleOrNotOne = head;
        ListNode circleOrNotTwo = head;
        //��������ָ�룬һ��һ��һ�����ߣ�һ�������ߡ�
        while(circleOrNotOne != null && circleOrNotTwo != null){
            circleOrNotOne = circleOrNotOne.next;
            //ע���ж�Ϊ�յ����
            if(circleOrNotTwo.next == null || circleOrNotTwo.next.next == null){
                return false;
            }
            circleOrNotTwo = circleOrNotTwo.next.next;
            if(circleOrNotTwo == circleOrNotOne){
                return true;
            }
        }
        
        return false;
    }
}
