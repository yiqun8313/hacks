package leetcode151withexplain;

/**
 * �������⣺����һ������ָ��  ���������ظ��Ľڵ㣬ȥ���ظ��ڵ㣬ֻʣ��һ���Ϳ���
 * 
 *  For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.
	
	����˼·��ͨ������ָ��   һ����¼ǰ��Ľڵ�  һ����¼����һ�����ظ��Ľڵ�  Ȼ�������������  �ƶ�ָ��Ϳ�����
 *
 */
public class RemoveDuplicatesfromSortedList069 {
	
	//����ڵ�  ���ݽṹ
    public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		    val = x;
		    next = null;
		 }
	 }
    
    //�����ظ��ڵ�
    public ListNode deleteDuplicates(ListNode head) {
       	if(head == null || head.next == null){
    		return  head;
    	}
    	
       	//�������ڵ����������preNode��¼ǰ���Ԫ�أ�nextNode��¼��һ�����ظ���Ԫ��
    	ListNode preNode = head;
    	ListNode nextNode = head;
    	//preNode����һ��node�������
    	while(preNode != null && preNode.next != null){
    		nextNode = preNode.next;
    		while((nextNode != null) && (nextNode.val == preNode.val)){
    			nextNode = nextNode.next;
    		}
    		preNode.next = nextNode;
    		if(preNode != null){
    			preNode = preNode.next;
    		}
    	}
    	
        return head;     
    }
}
