package leetcode151withexplain;

/**
 * �������⣺����һ������ɾ��������Ӻ������ĵ�k��Ԫ��
 * Given linked list: 1->2->3->4->5, and n = 2 the linked list becomes 1->2->3->5.
 *
 * ����˼·���������㷨������ͨ������ָ�룬�������ܹ��ҵ������ĵ�k��Ԫ�ء�ע�������������������k��Ԫ��������ͷ�ڵ㣻���⣬ѭ��������ʱ���жϵ�������aheadNode.next == null
 */
public class RemoveNthNodeFromEndofList132 {
	
	//����Ľڵ�
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		     val = x;
		     next = null;
		 }
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		//����ָ�룬һ����ǰ�棬һ���ں���
        ListNode aheadNode = head;
        ListNode afterNode = head;
        
        //ǰ�������n��
        for(int i = 0; i < n;i++){
            aheadNode = aheadNode.next;
        }
        
        //���aheadNodeΪ��  ��˵���պõ����  ��ô�ӽ�β���ĵ�n��Ԫ��������ͷ�ڵ�
        if(aheadNode == null){
            return head.next;
        }
        
        //������ǣ���ô�����ڵ�ͬ���������,�ж�������aheadNode.next == null
        while(aheadNode.next != null){
            aheadNode = aheadNode.next;
            afterNode = afterNode.next;
        }
        
        //ָ��������
        afterNode.next = afterNode.next.next;
  
        return head;
    }
}
