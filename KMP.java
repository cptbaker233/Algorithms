package com.igeek.kmp;

import java.util.Arrays;

/**  
* @typename KMP  
* @author NFUE  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2019年4月28日 下午7:21:48    
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
    
    //KPM算法获得匹配的下标
    public static int getIndex(String longger, String shorter) {
        if (shorter.length() > longger.length()) {      //如果子串长度大于主串,则返回-1
            return -1;
        } else if (longger.length() == shorter.length()){
            if (longger.equals(shorter)) {              //如果长度相同,则主串子串相同返回0,不相同返回-1
                return 0;
            } else {
                return -1;
            }
        } else {                                        //主串长度比子串长的情况下
            int i = 0;                                  //i为主串索引, j为子串索引
            int j = 0;
            int[] next = getNext(shorter);              //根据编写的方法获取next数组
            while (i < longger.length()) {              //循环跳出条件是遍历到主串结尾,如果不匹配最后跳出返回-1
                System.out.printf("主串:%s, 子串:%s\n", i, j);
                if (longger.charAt(i) == shorter.charAt(j)) {   //分别比对主串的i和子串的j是否相同, 相同则判断如果j为子串的最后一个索引,返回子串0处主串的索引
                    if (j == shorter.length() - 1) {
                        return i - shorter.length() + 1;
                    }
                    i ++;                               //相同则继续判断下一位
                    j ++;
                } else {                                //主串的i和子串的j不相同则j回朔到next数组对应的索引
                    j = next[j];
                }
                if (j == 0 && shorter.charAt(j) != longger.charAt(i)) {         //如果判断结束之后j的值为0且ij对应字符不等,则无需继续判断,主串索引+1
                    i ++;
                }
            }
            return -1;
        }
    }
    
    //获得next数组的方法
    public static int[] getNext(String ori) {
        int[] next = new int[ori.length()];     //先根据传入字符串创建next数组
        next[0] = 0;                            //第一项定为0
        for (int i = 1; i < ori.length() ; i ++) {
            String temp = ori.substring(0, i);  //temp为对应的索引i前一位的字符串的截取
            int len = temp.length() - 1;        //如果temp数组的长度为1,则子串直接从第一项即0开始比较;
            while (len > 0) {
                String left = temp.substring(0, len);
                String right = temp.substring(temp.length() - len, temp.length());
                if (!left.equals(right)) {
                    len --;         //先从最长的开始比较,如果不相同则截取长度len减一继续比较
                } else {
                    break;          //如果匹配成功,则跳出循环把len赋值给next数组对应的索引
                }
            }
            next[i] = len;      
        }
        return next;
    }
}
