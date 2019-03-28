package leetcode151withexplain;

/**
 *  �������⣺����һ�������x,������С��X�Ľڵ�ŵ���ߣ�����x�Ľڵ�ŵ��ұ�
 *  
 *  ����˼·��ͨ�����������¼סС�ںʹ��ڵ���ֵ��Ȼ�����ӵ�һ��Ϳ����ˡ�
 * 
 *  For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.
 *
 */
public class PartitionList065 {
	
	//����ڵ�   ���ݽṹ
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		     val = x;
		     next = null;
		 }
	}
	
	 public ListNode partition(ListNode head, int x) {
		 
		 	//�����������
	        if(head == null || head.next == null){
	            return head;
	        }
	        
	        int lessNum = 0;
	        int moreNum = 0;
	        
	        //�����ĸ�ָ��  �ֱ����ڼ�¼   С��x�Ľڵ�ʹ���x�Ľڵ�
	        ListNode lessNodeHead = new ListNode(0);
	        ListNode lessNodeTail = new ListNode(0);
	        ListNode moreNodeHead = new ListNode(0);
	        ListNode moreNodeTail = new ListNode(0);
	        
	        //ѭ�������������  �Ѷ�Ӧ�Ľڵ���뵽��Ӧ��������
	        while(head != null){
	        	//����ͷ���Ҫ���⴦��
	            if(head.val < x && lessNum == 0){
	                lessNodeTail = head;
	                lessNodeHead = lessNodeTail;
	                lessNum++;
	                head = head.next;
	                continue;
	            //���ú���뷨 ������������Ԫ��
	            }else if(head.val < x && lessNum > 0){
	                lessNodeTail.next = head;
	                lessNodeTail = lessNodeTail.next;
	                lessNum++;
	            }
	            
	            if(head.val >= x && moreNum == 0){
	                moreNodeTail = head;
	                moreNodeHead = moreNodeTail;
	                moreNum++;
	                head = head.next;
	                continue;
	            }else if(head.val >= x && moreNum > 0){
	                moreNodeTail.next = head;
	                moreNodeTail = moreNodeTail.next;
	                moreNum++;
	            }
	            
	            head = head.next;
	        }
	        //���ú���Ϊ��
	        moreNodeTail.next = null;
	        
	        //�����������
	        if(lessNum > 0 && moreNum > 0){
	            lessNodeTail.next = moreNodeHead;
	        }else if(lessNum == 0 && moreNum > 0){
	            return moreNodeHead;
	        }
	        return lessNodeHead;
	   }
}
