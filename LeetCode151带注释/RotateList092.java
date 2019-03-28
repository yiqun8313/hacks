package leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * �������⣺����һ�����������k,�������ұߵ�k��Ԫ�ط�ת��ǰ�� 
 *
 * ����˼·��������ָ�룬һ��ָ������ǰ����n�����������ѭ���������⣩����������ָ��һ�������ߣ���һ��������ʱ����һ���͵���Ҫ���λ�á�Ȼ��ǰ�����ӾͿ����ˡ�
 */
public class RotateList092 {
	
	//����ڵ�  ���ݽṹ
	static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		      val = x;
		      next = null;
		 }
	}
	
	public ListNode rotateRight(ListNode head, int n) {
		
        ListNode  first = head;
        ListNode  second = head;
        ListNode  result = null;
    
        if(head == null) {
            return result;
        }
    
        int i = 0;
        //����ǰ��n�������������Ԫ����ĿС��n,��ô��ѭ����ͷ��ȡ
        while(i < n) {
            if(first.next != null) {
                first = first.next;
            }
            else {
                first = head;
            }
            i++;
        }
    
        //firstָ��ȽϿ죬��ǰ����k�� ������һ���ߣ���ô��firstΪ�յ�ʱ��second�������Ҳ��k���ַ�
        //�ж�������first.next
        while(first.next != null) {
            first = first.next;
            second = second.next;
        }
    
        //���second����һ������գ���ô���Ӧ�ô�seconde����һ����ʼ 
        if(second.next != null) {
            result = second.next;
        }
        else {
            result = head;
        }
    
        
        first.next = head;
        second.next = null;
    
        return result;
   }
	
	
	public static void main(String[] args){
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(node0);
		list.add(node1);
		
		node1.val = 4;
		
		node1.next = node3;
		
		
		node1 = node1.next;
	}
	
}
