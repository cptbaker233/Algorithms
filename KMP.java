package com.igeek.kmp;

import java.util.Arrays;

/**  
* @typename KMP  
* @author NFUE  
* @Description: TODO(������һ�仰��������������)
* @date 2019��4��28�� ����7:21:48    
* @Company https://github.com/cptbaker233
*    
*/
public class KMP {
    public static void main(String[] args) {
        String mainStr = "abcabdabdaaaaaa";
        String sonStr =  "abdabda";
        System.out.println(Arrays.toString(getNext(sonStr)));
        System.out.println(getIndex(mainStr, sonStr));
    }
    
    //KPM�㷨���ƥ����±�
    public static int getIndex(String longger, String shorter) {
        if (shorter.length() > longger.length()) {      //����Ӵ����ȴ�������,�򷵻�-1
            return -1;
        } else if (longger.length() == shorter.length()){
            if (longger.equals(shorter)) {              //���������ͬ,�������Ӵ���ͬ����0,����ͬ����-1
                return 0;
            } else {
                return -1;
            }
        } else {                                        //�������ȱ��Ӵ����������
            int i = 0;                                  //iΪ��������, jΪ�Ӵ�����
            int j = 0;
            int[] next = getNext(shorter);              //���ݱ�д�ķ�����ȡnext����
            while (i < longger.length()) {              //ѭ�����������Ǳ�����������β,�����ƥ�������������-1
                System.out.printf("����:%s, �Ӵ�:%s\n", i, j);
                if (longger.charAt(i) == shorter.charAt(j)) {   //�ֱ�ȶ�������i���Ӵ���j�Ƿ���ͬ, ��ͬ���ж����jΪ�Ӵ������һ������,�����Ӵ�0������������
                    if (j == shorter.length() - 1) {
                        return i - shorter.length() + 1;
                    }
                    i ++;                               //��ͬ������ж���һλ
                    j ++;
                } else {                                //������i���Ӵ���j����ͬ��j��˷��next�����Ӧ������
                    j = next[j];
                }
                if (j == 0 && shorter.charAt(j) != longger.charAt(i)) {         //����жϽ���֮��j��ֵΪ0��ij��Ӧ�ַ�����,����������ж�,��������+1
                    i ++;
                }
            }
            return -1;
        }
    }
    
    //���next����ķ���
    public static int[] getNext(String ori) {
        int[] next = new int[ori.length()];     //�ȸ��ݴ����ַ�������next����
        next[0] = 0;                            //��һ�Ϊ0
        for (int i = 1; i < ori.length() ; i ++) {
            String temp = ori.substring(0, i);  //tempΪ��Ӧ������iǰһλ���ַ����Ľ�ȡ
            int len = temp.length() - 1;        //���temp����ĳ���Ϊ1,���Ӵ�ֱ�Ӵӵ�һ�0��ʼ�Ƚ�;
            while (len > 0) {
                String left = temp.substring(0, len);
                String right = temp.substring(temp.length() - len, temp.length());
                if (!left.equals(right)) {
                    len --;         //�ȴ���Ŀ�ʼ�Ƚ�,�������ͬ���ȡ����len��һ�����Ƚ�
                } else {
                    break;          //���ƥ��ɹ�,������ѭ����len��ֵ��next�����Ӧ������
                }
            }
            next[i] = len;      
        }
        return next;
    }
}
