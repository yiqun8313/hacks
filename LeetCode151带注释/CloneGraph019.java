package leetcode151withexplain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ����������ǿ�¡һ��ͼ��ͼ�����ݽṹ�Ѿ������� 
 * 
 * ����˼·������ͼ�Ŀ�����ȱ���������⣬ͨ��һ��linklist��ģ�¶��У��Ƚ��ȳ���ͨ��һ��isFound������¼ס�ڵ���û�б����ʹ�������Ѿ������ʹ�����ô��ֱ��������
 * ��nodemap�洢�ڵ㣬����������ٵ��ҵ��ڵ㡣
 * 
 * ע��ϸ�ڣ�1��ͷ�����������ã����Ǳ����ھӵ�ʱ�����nodemap���Ѿ����ڣ���ô��ֱ�Ӽ��뵽�ھ��У���������ڣ��½��ڵ㣬���뵽�ھ��У����һ�Ҫѹ�뵽������
 * 
 * nodemap��isfound�е�����֮������Ϊ�������ڼ�¼�Ƿ�֮ǰ�Ѿ����ʹ��ˡ�
 *
 */
public class CloneGraph019 {
	
	//���ݽṹ
	class UndirectedGraphNode {
		 int label;
		 List<UndirectedGraphNode> neighbors;
		 UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	
	
	    Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();  
	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {  
	        //�����������
	        if (node == null) {  
	            return null;  
	        }  
	        
	        //ģ�������ȱ����еĶ���
	        LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();  

	        
	        nodeMap.clear();
	        
	        //�Ƿ��Ѿ������ʹ�
	        Set<Integer> isFound = new HashSet<Integer>();
	          
	        //���ڵ�ŵ�����λ�ã�ѹ�����
	        stack.addLast(node);
	        
	        //����еĵ�һ���ڵ�
	        UndirectedGraphNode head = null;  
	          
	        //���ù�����ȱ����ķ�ʽ��ȡ���еĽڵ�
	        while (!stack.isEmpty()) {
	        	
	        	//��ȡ���еĵ�һ��Ԫ��
	            UndirectedGraphNode first = stack.getFirst();  
	            stack.removeFirst();  
	              
	            int label = first.label;  
	              
	            //�½��ڵ�
	            UndirectedGraphNode n = nodeMap.get(label);  
	            if (n == null) {  
	                n = new UndirectedGraphNode(label);  
	                nodeMap.put(label, n);  
	            }  
	              
	            //��һ���ڵ�����⴦��
	            if (head == null) {  
	                head = n;  
	            }  
	              
	            if (!isFound.contains(label)) {
	            	//���ڵ�ѹ�뵽�Ƿ��ѱ����ʹ��б���
	                isFound.add(label);  
	                
	                //��ȡԭ�ڵ�������ھ�
	                ArrayList<UndirectedGraphNode> neighbors = (ArrayList<UndirectedGraphNode>) first.neighbors;  
	                  
	                //����ÿһ���ھӽڵ㣬Ȼ����nodemap�м��룬��������Ϊn���ھ�
	                for (UndirectedGraphNode nb : neighbors) {  
	                    UndirectedGraphNode nn = nodeMap.get(nb.label);  
	                    if (nn == null) {  
	                        nn = new UndirectedGraphNode(nb.label);  
	                        nodeMap.put(nb.label, nn);  
	                          
	                        stack.addLast(nb);  
	                    }  
	                    n.neighbors.add(nn);         
	                }  
	            }  
	              
	              
	        }  
	          
	        return head;  
	    }

}
