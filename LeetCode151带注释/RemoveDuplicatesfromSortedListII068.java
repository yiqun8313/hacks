package leetcode151withexplain;

/**
 * �������⣺����һ������  ɾ�������ظ��ڵ�
 * 
 *  For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.
	
	����˼·��
 *
 */
public class RemoveDuplicatesfromSortedListII068 {
	//����ڵ�  ���ݽṹ
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		     val = x;
		     next = null;
		 }
	}
	
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode answer = new ListNode(0);
        ListNode tempanswer = answer;
        ListNode leftNode = head;
        ListNode rightNode = head.next;
        //��������ָ��  ���α���  
        while(leftNode != null && rightNode != null){
        	//����һ��ָ�����һ��ָ����ȵ�ʱ��
            if(rightNode.val == leftNode.val){
            	//ѭ��ֱ����һ���ڵ㲻Ϊnull
                while(rightNode != null && rightNode.val == leftNode.val){
                    rightNode  = rightNode.next;
                }
                
                //������ڵ�λ�ò���null����ôѭ������
                if(rightNode != null){
                    leftNode = rightNode;
                    rightNode = leftNode.next;
                }else{
                	//����leftnodeΪnull
                    leftNode = null;
                }
            }else{
            	//����ȣ���ô���ҵ���һ���㣬������������
                tempanswer.next = leftNode;
                tempanswer = tempanswer.next;
                
                leftNode = leftNode.next;
                rightNode = leftNode.next;
            }
        }
        
        if(leftNode != null && rightNode == null){
	         tempanswer.next = leftNode;
	         tempanswer = tempanswer.next;
	    }
        
	    tempanswer.next = null;
        
        return answer.next;
    }
}
