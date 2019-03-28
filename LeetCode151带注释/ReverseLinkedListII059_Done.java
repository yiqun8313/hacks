package leetcode151withexplain;

import java.util.ArrayList;

/**
 *  �������⣺����һ������  ��ָ��m��n֮��Ľڵ���з�ת 
 *
 *  For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	return 1->4->3->2->5->NULL.
	
	һ��˼·��ͨ��ջ��ʵ��  ���ڽ���m��n֮�������ѹ��ջ��Ȼ�󵯳������ӵ�������� 
 */
public class ReverseLinkedListII059_Done {
	
	//����ڵ�
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		     val = x;
		     next = null;
		 }
	}
	
	 public ListNode reverseBetween(ListNode head, int m, int n) {
	        
	        if(head == null) return head;
	        if(head.next == null) return head;
	        
	        //act as stack to store numbers
	        ArrayList<ListNode> likeQueue = new ArrayList<ListNode>();
	        
	        
	        //��m��n֮�������ѹ�뵽ջ��
	        int i = 1;
	        ListNode tempHead = head;
	        while(tempHead != null){
	            
	            if(i >= m && i <= n){
	                likeQueue.add(tempHead);
	            }
	            
	            i++;
	            tempHead = tempHead.next;
	        }
	        
	        
	        //ͬʱ����ԭ�����ջ���������   ��m��n֮���ʱ��  ������ջ�е�����
	        int j = 1;
	        ListNode anotherHead = new ListNode(0);
	        ListNode newHead = anotherHead;
	        while(head != null){
	            
	            if(j >= m && j <= n){
	            	anotherHead.next = new ListNode(likeQueue.get(likeQueue.size()-1).val);
	            	likeQueue.remove(likeQueue.size()-1);
	            }else{
	            	anotherHead.next = new ListNode(head.val);
	            }
	            
	            anotherHead = anotherHead.next;
	            j++;
	            head = head.next;
	        }
	        
	        return newHead.next;
	   }
	
	   //ͨ���ĸ�ָ��  
	   public ListNode reverseBetween1(ListNode head, int m, int n) {
	        ListNode before = null, start, end, after = null;
	        ListNode ptr = head;
	        
	        //���before
	        for(int i = 1; i < m; i++){
	            before = ptr;
	            ptr = ptr.next;
	        }
	        
	        start = end = ptr;
	        //ͨ��ǰ������ʵ�ַ�ת
	        for(int i = m; i <= n; i++){
	            after = ptr.next;
	            ptr.next = end;
	            end = ptr;
	            ptr = after;
	        }
	        
	        //�����������
	        if(before == null){
	            head = end;
	        }else{
	        	before.next = end;
	        }
	        
	        start.next = after;
	        return head;
	    }
}
