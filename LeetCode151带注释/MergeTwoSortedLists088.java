package leetcode151withexplain;

/**
 * �������⣺�ϲ�����������б���ʵ�ͺϲ���������������� 
 * 
 * ����˼·����ʵ���Ǻͺϲ�����������   �����˺���ʣ��Ĳ��־ͺ�
 *
 */
public class MergeTwoSortedLists088 {
	//����ڵ�
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		//����һ��ͷ�ڵ�
        ListNode result = new ListNode(0);
        ListNode tempNode = result;
        //���α����������������ÿһ���ڵ�
        while(l1 != null && l2 != null){
            
            if(l1.val <= l2.val){
                tempNode.next = l1;
                tempNode = tempNode.next;
                l1 = l1.next;
            }else{
                tempNode.next = l2;
                tempNode = tempNode.next;
                l2 = l2.next;
            }
        }
        
        //������ʣ�ಿ��
        if(l1 != null){
            tempNode.next = l1;
        }
        
        if(l2 != null){
            tempNode.next = l2;
        }
        
        return result.next;
	 }
}
