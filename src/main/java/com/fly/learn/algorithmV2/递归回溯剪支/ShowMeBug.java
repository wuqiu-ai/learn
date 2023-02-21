package com.fly.learn.algorithmV2.递归回溯剪支;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: peijiepang
 * @date 2021/7/28
 * @Description:
 */
public class ShowMeBug {

    static class Node {
        int id;
        int parentId;
        String name;

        public Node(int id, int parentId, String name) 				{
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }
    }

    //AA
    //  BB
    //     FF
    //     GG
    //  CC
    //     DD
    //        HH
    //     EE
    //        II
    //JJ
    //  KK
    //   LL
    //       MM
    //          NN
    //              OO
    public static void main(String[] args) {
        List<Node> nodeList = Arrays.asList(
            new Node(1, 0, "AA"),
            new Node(2, 1, "BB"),
            new Node(3, 1, "CC"),
            new Node(4, 3, "DD"),
            new Node(5, 3, "EE"),
            new Node(6, 2, "FF"),
            new Node(7, 2, "GG"),
            new Node(8, 4, "HH"),
            new Node(9, 5, "II"),
            new Node(10, 0, "JJ"),
            new Node(11, 10, "KK"),
            new Node(12, 10, "LL"),
            new Node(13, 12, "MM"),
            new Node(14, 13, "NN"),
            new Node(15, 14, "OO")
        );
        print(nodeList);
    }

    public static void print(List<Node> nodeList) {
        //todo
        if(null == nodeList || nodeList.size() == 0){
            return;
        }
        Iterator<Node> iterator = nodeList.iterator();
        Set<Integer> hashSet = new HashSet<>();


//        // 重置字符缩进
//        StringBuilder tabStr = new StringBuilder();
//        // 第一次遇到0构建map
//        Map<Integer,List<Node>> map = new HashMap<>();
//        Set<Integer> removeIds = new HashSet<>();
//        for(int i=0;i<nodeList.size();i++){
//            Node node = nodeList.get(i);
//            if(node.parentId == 0){
//                tabStr = new StringBuilder();
//                map.clear();
//                for(int j = i+1;j<nodeList.size();j++){
//                    Node temp1 = nodeList.get(j);
//                    if(temp1.parentId == 0){
//                        break;
//                    }
//                    if(null == map.get(temp1.parentId)){
//                        List<Node> listTemp = new ArrayList<>();
//                        listTemp.add(temp1);
//                        map.put(temp1.parentId,listTemp);
//                    }else{
//                        map.get(temp1.parentId).add(temp1);
//                    }
//                }
//            }
//
//            if(!removeIds.contains(node.id)){
//                removeIds.add(node.id);
//                System.out.println(tabStr.toString() +node.name);
//                // 构建该节点的子节点
//                tabStr.append("  ");
//                List<Node> nodes = map.get(node.id);
//                if(null != nodes && nodes.size() > 0){
//                    for(Node temp:nodes){
//                        System.out.println(tabStr + temp.name);
//                    }
//                    tabStr.append("  ");
//                }
//            }
//        }
    }

    public static void dfs(){

    }

}
