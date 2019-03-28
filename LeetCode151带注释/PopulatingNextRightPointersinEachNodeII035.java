package leetcode151withexplain;


/**
 * �������⣺��34������  ֻ�����ڵ�����������������  �������������������
 * 
 * ����˼·��
 * ͨ���ϲ�ı������ҵ��Լ������Һ���Ҫָ���λ�ã����ҵ����ڵ��next�����Һ��ӣ�Ȼ�����øýڵ�����Һ��ӵ�nextָ��
 * 
 * Ȼ��ݹ���ø÷�����
 * 
 * ע��㣺��������
 *
 */
public class PopulatingNextRightPointersinEachNodeII035 {

	//���ݽṹ  ����ָ��  ������������һ��
		public class TreeLinkNode {
			 int val;
			 TreeLinkNode left, right, next;
			 TreeLinkNode(int x) { val = x; }
		}
	
	 public void connect(TreeLinkNode root) {
	        
	        if(root == null){
	            return;
	        }
	        
	        TreeLinkNode currentNode = root.next;
	        
	        //�����ҵ���һ���ڵ�λ��
	        TreeLinkNode nextPoint = null;
	        
	        while(currentNode != null){
	        	//����   ����
	            if(currentNode.left != null){
	                nextPoint = currentNode.left;
	                break;
	            }
	            
	            if(currentNode.right != null){
	                nextPoint = currentNode.right; 
	                break;
	            }
	            currentNode = currentNode.next;
	        }
	        
	        //�����Һ��ӵ�ָ��
	        if(root.right != null){
	            root.right.next = nextPoint;
	        }
	        
	        //��������ָ��  ���ʱ��Ҫ�����Լ����Һ����Ƿ�Ϊ��
	        if(root.left != null){
	            root.left.next = root.right != null? root.right:nextPoint;
	        }
	 
	        //�ݹ���ø÷���  ����������ʹ��
	        connect(root.right);
	        connect(root.left);
	 
	    }
}
