package leetcode151withexplain;

import java.util.ArrayList;

/*
 * ����������Ǹ���һ������Ȼ��ͨ������
 * Given a singly linked list L: L0��L1������Ln-1��Ln,
   reorder it to: L0��Ln��L1��Ln-1��L2��Ln-2���� 
 */
public class ReorderList009 {
	
	//���ݽṹ
	class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
	}
	
	public void reorderList(ListNode head) {
        
        if(head == null){
            return;
        }
        
        if(head != null && head.next == null){
            return;
        }
        
        ArrayList<ListNode> onetolast = new ArrayList<ListNode>();

        //�����ѭ�����ǽ����еĽڵ�ŵ�onetolast��
        ListNode tempHead = head;
        int listLength = 0;
        while(tempHead != null){
            onetolast.add(tempHead);    
            tempHead = tempHead.next;
            listLength++;
        }
        
        
        ListNode result = new ListNode(0);
        ListNode answer = result;
        int i = 0;
        //Ȼ��ֱ��onetolast��ǰ��ȡֵ��ƴ�����������
        for(int j = 0; j < listLength; j++){
            result.next = onetolast.get(j);
            result = result.next;
            //��ʱ��¼���ڽڵ�ĸ���  ���ڵ�ĸ��������ܽڵ�����ʱ��Ҳ�������ڲ��ü������������ӽڵ��ˣ���ô��������Ϊnull������
            i++;
            if(i == listLength){
            	result.next = null;
            	break;
            }
            result.next = onetolast.get(listLength-1-j);
            result = result.next;
            i++;
            if(i == listLength){
            	result.next = null;
            	break;
            }
        }
        
        head = answer.next;
    }
}
