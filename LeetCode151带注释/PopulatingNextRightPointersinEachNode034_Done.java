package leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * �������⣺����һ��������   ��������ÿһ������Ľڵ�nextָ�붼ָ���е���һ��Ԫ��
 * 
 * ������裺��������
 * 
 * Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
	After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
    
    �����˼·����Ȼ��������������ô֮��ʹ������ֹ�ϵ������ÿһ�е�������Ϊ2^i�η���
    
    ��һ��arraylist��¼ס���еĽڵ㣬��һ��arraylist��ģ�¶��У�ͨ��������ȱ������еĽڵ㡣Ȼ�����ÿһ�е������Ŀ��ϵ������nextָ�롣
    
  ����Ҫ��ʹ�ó����ռ�
    
 *
 */
public class PopulatingNextRightPointersinEachNode034_Done {

	//���ݽṹ  ����ָ��  ������������һ��
	public class TreeLinkNode {
		 int val;
		 TreeLinkNode left, right, next;
		 TreeLinkNode(int x) { val = x; }
	}
	
	public void connect(TreeLinkNode root) {
		
        //record every element
        List<TreeLinkNode> allNodes = new ArrayList<TreeLinkNode>();
        //act as the BFS queue
        List<TreeLinkNode> likeQueue = new ArrayList<TreeLinkNode>();
        
        if(root == null){
            return;
        }else{
            likeQueue.add(root);
            allNodes.add(root);
        }
        
        while(likeQueue.size() != 0 && likeQueue.get(0) != null){
            TreeLinkNode queueHead = likeQueue.get(0);
            if(queueHead.left != null){
                allNodes.add(queueHead.left);
                likeQueue.add(queueHead.left);
            }
            
            if(queueHead.right != null){
                allNodes.add(queueHead.right);
                likeQueue.add(queueHead.right);
            }
            likeQueue.remove(0);
        }
        
        int temp = 0;
        int currentPosition = 0;
        int circle = 0;
        while(currentPosition < allNodes.size()){
            temp = currentPosition + (int)(Math.pow(2,circle));
            while(currentPosition < temp){
                if(currentPosition == (temp-1)){
                    allNodes.get(currentPosition).next = null;
                }else{
                    allNodes.get(currentPosition).next = allNodes.get(currentPosition+1);
                }
                currentPosition++;
            }
            circle++;
        }
        
    }
	
	//�����ռ��µķ�ʽ
	public void connect1(TreeLinkNode root) {
        if(root == null) return;
        //��ǰ�ڵ����һ���ڵ�
        TreeLinkNode curNode = root.next;
        //�ҵ���ǰ�ڵ�ĺ��ӽڵ�Ӧ��ָ�����һ���ڵ�
        TreeLinkNode nextNode = null;
        
        //ѭ����ȡ��һ������ָ��ĵ�ַ
        while(curNode != null){
            if(curNode.left != null){
                nextNode = curNode.left;
                break;
            }
            
            if(curNode.right != null){
                nextNode = curNode.right;
                break;
            }
            curNode = curNode.next;
        }
        
        if(root.right != null){
            root.right.next = nextNode;
        }
        
        if(root.left != null){
            root.left.next = (root.right != null)?root.right:nextNode;
        }
        
        connect(root.right);
        connect(root.left);
        
    }
}
