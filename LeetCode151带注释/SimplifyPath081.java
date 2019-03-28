package leetcode151withexplain;

import java.util.Stack;

/**
 * �������⣺����һ��unix·��  �����·��
 *
 *  For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
	
	
	����˼·��ͨ��һ��ջ��ģ��·�������ϵ�ѹ���ַ���Ҫʱ�̼�סǰ���һ���ַ���ʲô��Ȼ������ǡ���/����ô��ջ��Ϊ�յ�ʱ���򵯳�һ���ַ���
	�����//���ߡ�/�����ӵģ���ô�Ϳ���ֱ�������ˣ�������ַ�ʲô�ľ�ѹ�뵽ջ�С�
		
 */
public class SimplifyPath081 {
	
	public String simplifyPath(String path) {
		//����ģ��ѹ��
        Stack<String> s = new Stack<String>();
		String str = "";
		
        for(int i = 0; i < path.length(); i++){
        	//�����ǰ�ַ��� /
            if (path.substring(i, i+1).equals("/")){
                //�ж�ǰ����ַ�  �����../��ô�����ⵯ��һ��
            	if(str.equals("..")){
            	   //����
                   if (!s.empty())
                      s.pop();
                //�����./�����ǿգ���ôֱ�������Ϳ���
                }else if (!str.equals(".") && !str.equals("")){
                    s.push(str);
                }
                str = "";
            }else{
            	//str���ڼ�¼��ǰ����/��ʱ�����ֵ
                str += path.substring(i,i+1);
            }
        }
        
        //������һ����..  ��ô���ǵ���һ��
        if (str.equals("..")){
            if (!s.empty())
                s.pop();
        //������뵽ջ��
        }else if (!str.equals(".") && !str.equals("")){
            s.push(str);
        }
        
        //���ջΪ�գ���ô��ֱ�ӷ���
        if (s.empty())
            return "/";
        
        String ret = "";
        while(!s.empty()){
            ret = "/" + s.peek() + ret;
            s.pop();
        }
        
        return ret;
   }
}
