package leetcode151withexplain;

/**
 * �����Ƿ��ش��������л�����ʼ��   �����һ����ѧ���⣬������ͨ��һ����ָ���һ����ָ���ҵ���һ����ȵ�λ�á�Ȼ��ӵ�һ���ص���λ�ÿ�ʼ����һ��ָ���head
 * ����ʼ��������ָ����ȵ�ʱ�򣬼�ʱ�뻷�ĵ�һ���ڵ㡣
 * 
 *  ��Ȼ�ˣ�Ҳ����ͨ��map�������ҵ���һ���ظ���Ԫ�ء�
 *
 */
public class LinkedListCycleII010 {
	class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	}
	
	public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        
        if(head.next == head){
            return head;
        }
        
        if(head.next == null){
            return null;
        }
        
        ListNode circleOrNotOne = head;
        ListNode circleOrNotTwo = head;
        while(circleOrNotOne != null && circleOrNotTwo != null){
            circleOrNotOne = circleOrNotOne.next;
            if(circleOrNotTwo.next == null || circleOrNotTwo.next.next == null){
                return null;
            }
            circleOrNotTwo = circleOrNotTwo.next.next;
            
            if(circleOrNotOne == circleOrNotTwo){
                break;
            }
        }
        
        //���ϴ������ҵ��˵�һ���ص��ĵ㣬Ȼ���������һ����ѧ˼·���
        ListNode firstCrossPoint = circleOrNotOne;
        while(head != firstCrossPoint){
            head = head.next;
            firstCrossPoint = firstCrossPoint.next;
        }
        
        return head;
    }
}
