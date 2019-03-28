package leetcode151withexplain;

/**
 * �������⣺�����ַ���������ת��Ϊ��������
 * 
 * �жϹ���ǰ������пո�Ҳ�����������ų��֣�Ȼ��ӵ�һ�����ֿ�ʼ�����������ֵĳ��֣����ؽ���Ϳ��ԡ����򷵻�0
 *
 * ����˼·����ǰ����������������������֮����ô�Ͳ������������ַ������ˣ����������������֮��Ͳ����ڳ��������ַ��ˡ�
 * 
 * �뷨���ܶ���Ŀ�ж�������ôһ����Ƿ��ţ�����ʾĳЩ�ַ��Ƿ���ֹ���
 */
public class StringtoIntegeratoi144_ThinkAgain {
	
     public static void main(String[] args){
    	 StringtoIntegeratoi144_ThinkAgain object = new StringtoIntegeratoi144_ThinkAgain();
    	 System.out.println(object.atoi("    -2 3"));
     }
	
	
	 public int atoi(String str) {
		 //�����������
         if(null==str||str.length()==0)
             return 0;
         
         //ת��Ϊ�ַ�����
         char[] arr=str.toCharArray();
         //��¼���
         long res=0;
         //�Ƿ�Ϊ����
         boolean isNegative=false;
         //�Ƿ������һЩ��������
         boolean existed=false;
         
         //��ǰ�������
         for(int i=0;i<arr.length;i++)
         {
         	if(isDigit(arr[i]))//������ֵ�������
         	{
         		res=res*10+(arr[i]-48);
         		if(!existed) existed=true; //��������֮��ͱ�ʾ��existedΪtrue
         	}
         	else if(arr[i]=='-'&&!existed)//�����˸���   ǰ�滹û�����������
         	{
         		isNegative=true;
         		if(!existed) existed=true;
         	}
         	else if(arr[i]=='+'&&!existed)//positive
         	{
         	    if(!existed) existed=true;
         	}
         	else if(arr[i]==' '&&!existed)//blank
         		;
         	else break;	 //illlegal       	
         }
         
         //����Ǹ���  Ҫ�ж��Ƿ�С��������Сֵ
         if(isNegative)
         {
         	res=0l-res;
         	return res<Integer.MIN_VALUE?Integer.MIN_VALUE:(int)res; //consider integer scope
         }
         else {
     		return res>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)res;
     	}
	}
	 
	 //�ж�һ���ַ��Ƿ�Ϊ����
	 private boolean isDigit(char c)
	 {
	     return c >= 48 && c <= 57;
	 }
	 
	 
	 public int atoi1(String str) {
		 long ans = 0;
		 boolean isPositive = true;
		 boolean existOrNot = false;
		 char[] array = str.toCharArray();
		 int aLength = array.length;
		 for(int i = 0; i < aLength; i++){
			 
			 char cur = array[i];
			 if(isDigit1(cur)){
				 ans  = ans * 10 + (cur - 48);
				 if(!existOrNot) existOrNot = true;
			 }else if(cur == '+' && !existOrNot){
				 
				 if(!existOrNot) existOrNot = true;			 
			 }else if(cur == '-' && !existOrNot){
				 isPositive = false;
				 if(!existOrNot) existOrNot = true;
			 }else if(cur == ' ' && !existOrNot){
				 
			 }else{
				 break;
			 }
			 
		 }
		 
		 if(!isPositive){
			 ans = 0 - ans;
			 if(ans <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
			 else return (int)ans;
		 }else{
			 if(ans >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
			 else return (int)ans;
		 }
		 
		 
	 }
	 
	 private boolean isDigit1(char c){
		 if(c >= 48 && c <= 57){
			 return true;
		 }else{
			 return false;
		 }
	 }
	 
}
