package leetcode151withexplain;

/**
 * �������⣺���������������飬�ҵ��������������λ������λ��Ҳ��������������ƽ��ֵ����ϣ��ʱ�临�Ӷ�Ϊlog(m+n)
 * 
 * ����˼·��������ȷ��λ�����󷨣���������������֣���ô�����м�λ�õ����֣������ż�������֣���ô�����м��������ֵ�ƽ��ֵ��
 * �����˼·����ͨ�����ַ����������������ҵ���k���������������ʱ�򣬾��Ǿ���Ҫ������������ȡ�������֣�����ǵ�k������ϣ��ÿ��������ȡ��k/2��Ԫ�ء�
 * ������鱾�����������k/2������ô�����Ҫȫȡ������һ��ȡʣ��Ԫ�صĶ��١�Ȼ��ͨ���ݹ���õķ�ʽ��ȡ�Ϳ����ˡ�
 * 
 *
 */
public class MedianofTwoSortedArrays150 {
	
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int k = m + n;
		//���������  ��ô�ҵ��м�Ԫ��
        if ((k & 1) > 0){
            return findKth(A,0, m, B,0, n, k / 2 + 1);
        }else{
        //�����ż��  ���м���������ƽ����
            return (findKth(A,0, m, B,0, n, k / 2) + findKth(A,0, m, B,0, n, k / 2 + 1)) / 2;
        }   
    }
	
	
	/**
	 * �������������ҵ���k����
	 * @param A
	 * @param pluseNuma A���鿪ʼ�����Ļ�׼λ��
	 * @param m
	 * @param B
	 * @param pluseNumb
	 * @param n
	 * @param k
	 * @return
	 */
	public double findKth(int A[],int pluseNuma, int m, int B[],int pluseNumb, int n, int k){
		//�㷨�ļ��������m <= n
        //m is equal or smaller than n
        if (m > n)
            return findKth(B,pluseNumb, n, A,pluseNuma, m, k);
        
        //�������Ϊ0  ��ô�ʹ�b���ҵ����
        if (m == 0)
            return B[pluseNumb+k-1];
        
        //����ҵ����������еĵ�k��Ԫ��Ϊ��1������0��Ԫ��  ��ôȥ����Ԫ�ص���Сֵ�Ϳ�����
        if (k <= 1)
            return min(A[pluseNuma], B[pluseNumb]);

        //��A������������ݻ�������k��һ��
        int pa = min(k/2, m);
        int pb = k - pa;
        //A��С��B�е����
        if (A[pluseNuma+pa-1] < B[pluseNumb+pb-1]){
        	//A��Ԫ�ؼ���
            return findKth(A,pluseNuma+pa, m - pa, B,pluseNumb, n, k - pa);
        }
        else if(A[pluseNuma+pa-1] > B[pluseNumb+pb-1]){
        	//b��Ԫ�ط�Χ����
            return findKth(A, pluseNuma,m, B,pluseNumb+pb, n - pb, k - pb);
        //������ȵ����
        }else
            return A[pluseNuma+pa-1];
    }
	
	public int min(int a,int b){
		if(a < b) return a;
		return b;
	}
}
