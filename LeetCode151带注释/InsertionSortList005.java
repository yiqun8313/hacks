package leetcode151withexplain;

/**
 * ��������в������򣬺�֮ǰ�ᵽ�Ķ�������й鲢�����࣬���ǰѴ�ͳ����Ĳ���Ӧ�õ����������档
 * 
 * �����˺ܾã�������ǲ���ֵ�Ľ���������ֱ�Ӿ���ָ��ĸı䣬�൱���鷳�͸��ӡ�
 * 
 * ����˼·��ģ������Ĳ������򣬼����ѭ���ӵڶ���Ԫ��������ɨ�裬�ڴ�ѭ���Ǵӿ�ʼԪ�ص�����㵱ǰԪ�ء�ֻ���������е����ֲ����λ�õ�ʱ�򣬱�����Ҳ��ͨ�����ϵĽ�����ֵ��ʵ�ֵġ�
 * 
 * ʱ�临�Ӷȣ�O��n^2��  �������������O��n��
 *
 */
public class InsertionSortList005 {
	
	public static void main(String[] args){
		InsertionSortList005 object = new InsertionSortList005();
		ListNode head = new ListNode(5);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(1);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		object.insertionSortList(head);
	}
	
	//���ݽṹ
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	         val = x;
	         next = null;
	    }
	}
	
	
	 public ListNode insertionSortList(ListNode head) {
	        if(head == null || head.next == null) return head;
	        
	        //ģ������Ĳ�������
	        ListNode i = head.next;
	        while(i != null){
	            ListNode j = head;
	            //ͨ��ѭ���ҵ�����λ��
	            while(j.val < i.val && j != i){
	                j = j.next;
	            }
	            
	            //�������ҵ�����λ�ã���ô�Ͳ��ϵ������ƶ�����ڵ��������ֵ
	            if(j != i){
	                int ivalue = i.val;
	                int jvalue;
	                while(j != i){
	                    jvalue = j.val;
	                    j.val = ivalue;
	                    ivalue = jvalue;
	                    j = j.next;
	                }
	                j.val = ivalue;
	            }
	            
	            
	            i = i.next;
	        }
	        
	        return head;
	    }
}
