package leetcode151withexplain;

/*
 * �������⣺���������������������������������ֵĺ͡������ͷ���������λ��
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   Output: 7 -> 0 -> 8
   
          ����˼·��������ļӷ�һ������ͬʱ������������ֱ����һ��Ϊ�գ��������в�Ϊ�յĴ������ͬʱΪ�գ�����������λ�Ĵ���
 * 
 */
public class AddTwoNumbers148 {
	//�������ݽṹ
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		     val = x;
		     next = null;
		 }
	}
	
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//addFlag���ڼ�¼��λ
        int addFlag = 0;
    	int currentNum;
    	
    	//�����������
    	if(l1 == null && l2 == null){
    		return null;
    	}
    	
    	if(l1 == null && l2 != null){
    		return l2;
    	}
    	
    	if(l1 != null && l2 == null){
    		return l1;
    	}
    	
    	ListNode newHead = l1;
    	
    	while(l1.next != null && l2.next != null){
    		currentNum = l1.val + l2.val;
    		
    		if(addFlag == 1){
    			 l1.val = (currentNum+1) % 10;
    		}else{
    			 l1.val = currentNum % 10;
    		}

    		if(currentNum + addFlag >= 10){
    			addFlag = 1;
    		}else{
    			addFlag = 0;
    		}
    		
    		
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	
    	if(l2.next == null && l1.next == null){
    		int tempaddNum = l1.val + l2.val;
    		
    	    l1.val = (tempaddNum+addFlag) % 10;

    		if(tempaddNum+addFlag >= 10){
    			ListNode newNode = new ListNode(1);
    			l1.next = newNode;
    		}
    		return newHead;
    	}
    	
    	if((l1.next == null) && (l2.next != null)){
    		int tempaddNum = l1.val + l2.val;
    		
    		if(addFlag == 1){
    			 l1.val = (tempaddNum + 1) % 10;
    		}else{
    			 l1.val = tempaddNum % 10;
    		}
    		
    		if(tempaddNum + addFlag >= 10){
    			l2.next.val = l2.next.val+1;
    			l1.next = l2.next;
    		}else{
    		    l1.next = l2.next;
    		}
    		
    		addFlag = 0;
    		l1 = l1.next;
    		while(l1.next != null){
    		    if(l1.val >= 10){
    		        l1.val = l1.val % 10;
    		        l1.next.val  = l1.next.val + 1;
    		        addFlag = 1;
    		        l1 = l1.next;
    		    }else{
    		        addFlag = 0;
    		        l1 = l1.next;
    		    }
    		}

    		if(l1.val >= 10){
    		    ListNode nodeL1 = new ListNode(1);
    		    l1.next = nodeL1;
    		}
    		
    		l1.val = l1.val % 10;
    		
    		return newHead;
    	}
    	
    	
    	if((l1.next != null) && (l2.next == null)){
    		int tempaddNum = l1.val + l2.val;
    		
    		if(addFlag == 1){
    			 l1.val = (tempaddNum+1) % 10;
    		}else{
    			 l1.val = tempaddNum % 10;
    		}
    		
    		
    		if(tempaddNum + addFlag >= 10){
    			l1.next.val = l1.next.val+1;  			
    		}
    		
    		addFlag = 0;
    		l1 = l1.next;
    		while(l1.next != null){
    		    if(l1.val >= 10){
    		        l1.val = l1.val % 10;
    		        l1.next.val  = l1.next.val + 1;
    		        l1 = l1.next;
    		    }else{
    		        addFlag = 0;
    		        l1 = l1.next;
    		    }
    		}

    		if(l1.val >= 10){
    		    ListNode nodeL1 = new ListNode(1);
    		    l1.next = nodeL1;
    		}
    		
    		l1.val = l1.val % 10;
    		   		
    		return newHead;
    	}
    	
		return newHead;
           
    }
}
