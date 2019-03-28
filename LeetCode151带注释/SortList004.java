package leetcode151withexplain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * ���⣺����һ��������nlog(n)ʱ���ڽ������򣬲���Ҫ��ʹ�ó����ռ�
 *
 * ����˼·���ڶ��ַ����ȽϺ�һЩ�����Ǹ��ݹ鲢����ķ�ʽ�����������������
 * 
 * ʱ�为���Ϊnlog(n)
 */
public class SortList004 {
	
		public static void main(String[] args){
			SortList004 object = new SortList004();
			ListNode head = new ListNode(2);
			ListNode node2 = new ListNode(1);
			head.next = node2;
			object.sortList2(head);
		}
	
	
		 //�ṹ�� �ڲ���
		 static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		     }
		  }

		/**
		 * ����Ľⷨ�Ƚ������������Ƚ�ListNode�е�ֵ����ȡ��������List�У�Ȼ�����Collections��������Ȼ���ٰ���ֵ�ŵ���������
		 * @param head
		 * @return
		 */
	    public ListNode sortList(ListNode head) {
	        if(head == null || head.next == null){
	            return head;
	        }
	        ListNode valuesNode = head;
	        List<Integer> values = new ArrayList<Integer>();
	        while(valuesNode != null){
	            values.add(valuesNode.val);
	            valuesNode = valuesNode.next;
	        }
	        
	        Collections.sort(values);
	        
	        ListNode resultNode = head;
	        for(int i = 0; i < values.size(); i++){
	            resultNode.val = values.get(i);
	            resultNode = resultNode.next;
	        }
	        
	        return head;
	        
	    }
	    
	    /*
	     * �����ǵڶ��ַ�������Ϊ�ᵽ�˸��Ӷ���nlog(n)�������뵽�˹鲢������������Ĺ鲢����
	     * �鲢����ĺ������ҵ��м�λ�ã�Ȼ��ݹ���ù鲢����Ȼ����кϲ��� 
	     * ������Ĺ鲢������ҪҪ���߿�ʼ�±�ͽ����±꣬������merge��ʱ����Ҫ����ռ����洢�м���
	     * ����ķ�ʽ��ֻ��Ҫָ����ƶ������Խ�ʡ�˿ռ䣬��������������кϲ���ʱ�򣬱���֪�����Ľ����ģ����ԣ��ҵ��м�λ��֮��Ҫ����Ϊnull.������Ϊ�ĸ�Ū����������
	     */
	    public ListNode sortList2(ListNode head) {
	        if(head == null || head.next == null){
	            return head;
	        }
	        return mergeSort(head);
	    }
	    
	    public ListNode mergeSort(ListNode head){
	        if(head == null || head.next == null) return head;
	        
	        //find mid
	        ListNode slow = head;
	        ListNode fast = head;
	        ListNode pre = null;
	        while(fast != null && fast.next != null){
	            pre = slow;
	        	slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        pre.next = null;
	        ListNode left = mergeSort(head);
	        ListNode right = mergeSort(slow);
	        
	        return merge(left,right);
	    }
	    
	    public ListNode merge(ListNode left,ListNode right){
	        ListNode answer = new ListNode(0);
	        ListNode temp  = answer;
	        while(left != null && right != null){
	            if(left.val < right.val){
	                temp.next = left;
	                left = left.next;
	                temp = temp.next;
	            }else{
	                temp.next = right;
	                right = right.next;
	                temp = temp.next;
	            }
	        }
	        
	        if(left != null){
	            while(left != null){
	                temp.next = left;
	                left = left.next;
	                temp = temp.next;
	            }
	        }
	        
	        if(right != null){
	            while(right != null){
	                temp.next = right;
	                right = right.next;
	                temp = temp.next;
	            }
	        }
	        
	        temp.next = null;
	        return answer.next;
	        
	    }
}
