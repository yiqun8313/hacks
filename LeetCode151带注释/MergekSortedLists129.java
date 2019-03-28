package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �������⣺����k������������ϲ�k���������ؽ����������ʱ�临�ӶȺͿռ临�Ӷȡ�
 * 
 * ����˼·������ÿһ�������ַ�����̨����ȡ���Ľ����
 *
 *
 */
public class MergekSortedLists129 {
	
	//����ڵ�  ���ݽṹ
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
		     next = null;
		 }
	}
	
	//����lists�����ÿһ������   ��ѯ��������ĺϲ�
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int listsSize = lists.size();
        if(listsSize == 0) return null;
        if(listsSize == 1) return lists.get(0);
        ListNode currentNode = null;
        for(int i = 0; i < listsSize; i++){
            currentNode = mergeTowList(currentNode,lists.get(i));
        }
        
        return currentNode;
    }
    
    public ListNode mergeTowList(ListNode one, ListNode two){
        if(one == null) return two;
        if(two == null) return one;
        
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(one != null && two != null){
            if(one.val <= two.val){
                temp.next = one;
                one = one.next;
                temp = temp.next;
            }else{
                temp.next = two;
                two = two.next;
                temp = temp.next;
            }
        }
        
        if(one != null){
            temp.next = one;
        }
        
        if(two != null){
            temp.next = two;
        }
        
        return result.next;
    }
}
