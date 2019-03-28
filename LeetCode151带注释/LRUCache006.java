package leetcode151withexplain;

import java.util.HashMap;
import java.util.Map;

/**
 * �������⣺ģ��LRU latest recently userd �������ʹ�á�
 * 
 * �������ʹ�õ�����ǰ�档
 * get�������ڻ�ȡ�Ƿ�cache���и�Ԫ�أ�
 * set��������cache�е�ֵ������Ѿ����ڣ���ô�͸ı�value����������ڣ���ô�Ͱ���Ԫ�طŵ�ͷ����
 * ������������ˣ���ô�Ͱ���������Ԫ��ɾ������
 * 
 * �������˼·��
 * ͨ��˫����ģ����У���ô���и�ͷ��β�ͣ����������ͷ������Ԫ���Լ���β��ɾ��Ԫ�ء�
 * ͨ��һ��map���洢�ڵ��еĽڵ㣬�����ͷ�����ҽڵ㣬�Ӷ��Խڵ�����صĲ�����
 *
 */
public class LRUCache006 {
	   //˫����ڵ�����ݽṹ
	    class Node{
	        Node pre;
	        Node next;
	        int key;
	        int value;
	        Node(int k, int v){
	            key = k;
	            value = v;
	            pre = null;
	            next = null;
	        }
	    }
	    
	    public int cacheCapacity;
	    public int currentSize;
	    public Node head;
	    public Node tail;
	    Map<Integer,Node> map = new HashMap<Integer,Node>();
	    
	    //���캯��   ������ͷ����β��  ˫����
	    public LRUCache006(int capacity) {
	        this.cacheCapacity = capacity;
	        this.currentSize = 0;
	        map.clear();
	        head = new Node(0,0);
	        tail = new Node(0,0);
	        head.next = tail;
	        tail.pre = head;
	    }
	    
	    //��ȡԪ�������Ϊ�գ���������˫�����ͷβ����
	    public int get(int key) {
	        Node keyNode = map.get(key);
	        if(keyNode != null){
	            keyNode.pre.next = keyNode.next;
	            keyNode.next.pre = keyNode.pre;
	            putToHead(keyNode);
	            return keyNode.value;
	        }else{
	            return -1;
	        }
	    }
	    
	    public void set(int key, int value) {
	        Node keyNode = map.get(key);
	        if(keyNode != null){
	            keyNode.value = value;
	            keyNode.pre.next = keyNode.next;
	            keyNode.next.pre = keyNode.pre;
	            putToHead(keyNode);
	        }else{
	            Node newnode = new Node(key,value);
	            map.put(key,newnode);
	            putToHead(newnode);
	            this.currentSize++;
	            if(currentSize > cacheCapacity){
	                map.remove(tail.pre.key);
	                tail.pre.pre.next = tail;
	                tail.pre = tail.pre.pre;
	                this.currentSize--;
	            }
	 
	        }
	    }
	    
	    //��Ԫ�ز��뵽ͷ��
	    public void putToHead(Node p){
	        p.next = head.next;
	        p.pre = head;
	        head.next.pre = p;
	        head.next = p;
	    }
}
