package leetcode151withexplain;

/**
 * ��������������һ������ÿһ���ڵ������һ��ָ����һ����ָ�룬����һ��randomָ�룬���ָ��ĳһ���ڵ㡣����һ������������Ҳ��ܸı�ԭ����ֵ��
 *
 * ����˼·��ͦ�м��ɵ�   ��������ԭ�������ÿһ���ڵ���涼����һ������ڵ㣻Ȼ���ڸ������е�����ָ�룬�˴����Ƶ�ʱ��ǳ��������ǰ�ڵ㣨ԭ�ڵ㣩����һ���ڵ������ڵ�͵��ڵ�ǰ�ڵ������ڵ����һ���ڵ㣻
 * Ȼ���ٰ�����ָ���ԭ�������ӾͿ����ˡ�
 */
public class CopyListwithRandomPointer014 {
	
	//randomlist�ڵ����ݽṹ
	class RandomListNode {
		 int label;
		 RandomListNode next, random;
		 RandomListNode(int x) { this.label = x; }
	};
	
	
	public RandomListNode copyRandomList(RandomListNode head) {  
        if (head == null) return null; 
        
        RandomListNode tempHead = head;  
        RandomListNode next = null; 
        
        //����������нڵ㸴��һ�ݳ���
        //Create the copy of every node in the list and insert   
        //it in original list between current and next node.     
        while (tempHead != null) {  
            RandomListNode n = new RandomListNode(tempHead.label);  
            next = tempHead.next;  
            tempHead.next = n;  
            n.next = next;  
            tempHead = next;  
        }  
        
        //�����е�����ָ�븴��һ��
        RandomListNode newListHead = head.next;  
        //Copy the arbitrary link for result    
        tempHead = head;  
        while (tempHead != null) {
            if(tempHead.random != null){
                tempHead.next.random = tempHead.random.next;
            }
            if(tempHead.next != null){
                tempHead = tempHead.next.next;
            }
        }  
          
        //�ָ���ԭ���Ľṹ
        tempHead = head;  
        RandomListNode temp = tempHead.next;  
        //restore the original and copy linked lists   
        while(tempHead != null && temp != null) {  
            tempHead.next = temp.next;  
            if (temp.next == null) {  
                break;  
            }  
            temp.next = temp.next.next;  
            tempHead = tempHead.next;  
            temp = temp.next;  
        }  
        return newListHead;       
    }  
}
