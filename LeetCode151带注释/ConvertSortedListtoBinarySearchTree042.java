package leetcode151withexplain;

/**
 *  �������⣺���������е������Ϊƽ�����������
 *  
 *  ������������ÿһ���������������С���Լ������������鶼�����Լ���  ���������������ԣ������������õı���һ����������
 *
 *  �������˼·��ÿһ��������м�λ�þ��Ǹ��ڵ㣬��߾����������������ұ߾���������������Ȼ��ͨ���ݹ���ʵ�֡�
 */
public class ConvertSortedListtoBinarySearchTree042 {

	 //����ڵ����ݽṹ
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; next = null; }
	 }
	 
     //���ڵ�����ݽṹ
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	 public TreeNode sortedListToBST(ListNode head) {  
	        int length = 0;  
	        ListNode node = head;  
	        while(node!=null){  
	            node = node.next;  
	            length++;  
	        }  
	        return sortedListToBST(head, length);  
	 }  
	 
	//������������ͷ��������ĳ��� 
    private TreeNode sortedListToBST(ListNode head, int length){
    	
    	//�����������
        if(length == 0 || head == null){  
            return null;  
        }else if(length == 1){  
            return new TreeNode(head.val);  
        }  
  
        ListNode peak = head;  
        //�ҵ��м�λ��
        int index = (int)(length/2);  
        for(int i = 0; i<index; i++){  
            peak = peak.next;  
        }  
        
        //���õ�ǰ�ڵ����������
        TreeNode node = new TreeNode(peak.val);  
        node.left = sortedListToBST(head, index);  
        node.right = sortedListToBST(peak.next, length - index - 1);  
          
        return node;  
    }
}
