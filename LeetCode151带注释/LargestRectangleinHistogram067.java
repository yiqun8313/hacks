package leetcode151withexplain;

import java.util.Stack;

/**
 *  ��������:����һ������������ľ���  
 *  
 *  �������ҲӦ������66����,���Բο��Ǹ�����.
 *  
 *  ջ���Լ�¼ס֮ǰ�Ĳ���,����ջ:һ�� ���ڴ洢�±�,�����ȵ�ʱ��ʹ��;һ�����ڴ洢����Ԫ��,����߶ȵ�ʱ��ʹ��.
 *  
 *  ����߶ȱȵ�ǰ��ջ����Ԫ�ش�,��ô��ѹ��ջ��;���С��ջ��Ԫ��,��ô�͵���Ԫ�ؼ���������.
 *
 */
public class LargestRectangleinHistogram067 {
	public int largestRectangleArea(int[] height){
		 int maxarea = 0;
		 int size = height.length;
		 if(size == 0) return 0;
		 if(size == 1) return height[0];
		 
		 Stack<Integer> indexStack = new Stack<Integer>();
		 Stack<Integer> heightStack = new Stack<Integer>();
		 
		 int temparea = 0;
		 for(int i = 0; i < size; i++){
			 if(indexStack.isEmpty() == true || height[i] > heightStack.peek()){
				 indexStack.push(i);
				 heightStack.push(height[i]);
			 }else if(height[i] < heightStack.peek()){
				 int lastindex = 0;
				 while(indexStack.isEmpty() == false && height[i] < heightStack.peek()){
					 lastindex = indexStack.pop();
					 temparea = heightStack.pop() * (i - lastindex);
					 if(temparea > maxarea){
						 maxarea = temparea;
					 }
				 }
				 
				 indexStack.push(lastindex);
				 heightStack.push(height[i]);				 
			 }
			 
		 }
		 
		 while(!indexStack.isEmpty()){
			 temparea = heightStack.pop() * (size - indexStack.pop());
			 if(temparea > maxarea){
				 maxarea = temparea;
			 }
		 }

		 return maxarea;
	}
	
	public static void main(String[] args){
		LargestRectangleinHistogram067 object = new LargestRectangleinHistogram067();
		int[] a = {2,1,5,6,2,3};
		object.largestRectangleArea(a);
	}
}
