package leetcode151withexplain;

/**
 * �������⣺����һ������ ���������н����ŵ�����Ԫ�ؽ��з�ת �����µ�����
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * ����˼·��ͨ������ָ������������ָ�����ڼ�¼��ǰ��Ҫת�����������ָ�룻����һ��ָ�����ڼ�¼ǰ�淴ת������һ��ָ�롣����������ȥ��
 * �����ʵ������Ľڵ�ķ�ת��
 * 
 */
public class SwapNodesinPairs128 {

	// ����ڵ�����ݽṹ
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode swapPairs(ListNode head) {
		// �����������
		if (head == null)
			return null;
		if (head != null && head.next == null)
			return head;

		// ��һ���ڵ�
		ListNode startNode = head;
		// �ڶ����ڵ�
		ListNode endNode = head.next;
		// ����ڵ� ָ��ڶ����ڵ�
		ListNode result = endNode;
		// lastNode��ס��һ�ֵ����һ��Ԫ��
		ListNode lastNode;

		// �ȷ�תǰ�����ڵ�
		startNode.next = endNode.next;
		endNode.next = startNode;

		lastNode = startNode;

		// ���������е������ڵ� ���η�ת
		while (startNode.next != null && startNode.next.next != null) {
			startNode = startNode.next;
			endNode = startNode.next;

			startNode.next = endNode.next;
			endNode.next = startNode;

			lastNode.next = endNode;

			lastNode = startNode;

		}

		// ������������������ô��ֱ�Ӽӵ����������
		if ((startNode.next != null) && (startNode.next.next == null)) {
			lastNode.next = startNode.next;
		}

		return result;
	}
}
