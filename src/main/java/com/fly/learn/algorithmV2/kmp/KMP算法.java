package com.fly.learn.algorithmV2.kmp;

/**
 * @author: peijiepang
 * @date 2021/7/28
 * @Description:
 */
public class KMP算法 {

    public static void main(String[] args) {
        KMP("asdadljaklsd","dad");
    }

    /**
     * KMP算法用于在线性时间复杂度内解决字符串匹配的问题。假设现在有一个主串s="abcacabcaabcabcac"，和一个模式串p="abcab"。
     * 要判断主串s是否包含模式串p，若包含则返回模式串在主串中的下标；若不包含则返回-1。易知暴力匹配算法的时间复杂度为O(m*n)，其中m=s.length()，n=p.length()。
     * KMP算法利用已匹配的信息可以有效减少匹配次数，将时间复杂度降低至O(m+n)。
     * @param s
     * @param p
     * @return
     */
    public static int KMP(String s,String p){
        int[] next = getNext(p);
        int i=0,j=0;
        while(i<s.length() && j<p.length()){
            if(j==-1 || s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else{
                //避免会退到0
                j=next[j];
            }
        }
        if(j==p.length()){
            return i-(p.length());
        }else{
            return -1;
        }
    }

    public static int[] getNext(String s){
        int[] next = new int[s.length()];
        next[0]=-1;
        int i = 0;
        int j = -1;
        while(i<s.length()-1){
            if(j==-1 || s.charAt(i)==s.charAt(j)){
                i++;
                j++;
                next[i]=j;
            }else{
                j=next[j];
            }
        }
        return next;
    }


}
