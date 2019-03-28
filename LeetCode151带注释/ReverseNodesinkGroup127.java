package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �������⣺����һ�������k,��������ÿk��Ԫ�ط�ת����һ���µ�����
 * 
 *  For example,
	Given this linked list: 1->2->3->4->5
	For k = 2, you should return: 2->1->4->3->5
	For k = 3, you should return: 3->2->1->4->5
	
	ϣ���ó����Ŀռ䡣
	
	����˼·��ͨ��һ��ջ�����������С������ͨ��arraylist��ģ�µģ����������ҵ�ÿһ��Ԫ�ء�
 * 
 *
 */
public class ReverseNodesinkGroup127 {
	//��������ݽṹ
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
	        val = x;
		    next = null;
	     }
	}
	
	
	public ListNode reverseKGroup(ListNode head, int k) {
		
        if(k == 0) return head;
        //�����������
        if(head == null) return head;
        if(head != null && head.next == null) return head;
        ListNode answer = new ListNode(0);
        ListNode connector = answer;
        int tempNum = 0;
        //use a stack to store the elements
        //ģ��ջ���ڷ�ת�ַ���
        ArrayList<ListNode> stack = new ArrayList<ListNode>();
        while(true){
            tempNum = 0;
            int i = k;
            //ÿ�ζ�����k��Ԫ�أ�Ȼ����뵽stack��
            for(; i > 0; i--){
            	//�������Ϊnull�����  ֱ������  Ҳ����˵����k��Ԫ�ص�ʱ�������
                if(head == null){
                    break;
                }else{
                    stack.add(head);
                    head = head.next;
                }
            }
            
            //�����ҵ���k��Ԫ��
            if(i == 0){
            	//��ת�����ӵ��������
                while(stack.size() != 0){
                    connector.next = stack.get(stack.size()-1);
                    connector = connector.next;
                    stack.remove(stack.size()-1);
                }
            }else{
            	//�����˳�����ӵ��������
                while(stack.size() != 0){
                    connector.next = stack.get(0);
                    connector = connector.next;
                    stack.remove(0);
                }
                //���������������ָ��null
                connector.next = null;
                break;
            }
        }
        
        return answer.next;
    }
	
}
