package NowCoder.ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Canhu
 * @Description TODO:
 * 小包最近迷上了一款叫做雀魂的麻将游戏，但是这个游戏规则太复杂，小包玩了几个月了还是输多赢少。
 * 于是生气的小包根据游戏简化了一下规则发明了一种新的麻将，只留下一种花色，并且去除了一些特殊和牌方式（例如七对子等），具体的规则如下：
 *
 * 总共有36张牌，每张牌是1~9。每个数字4张牌。
 * 你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌
 * 14张牌中有2张相同数字的牌，称为雀头。
 * 除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）
 * @Author sth_199509@163.com
 * @Date 2021/10/14 10:53
 * @Version 1.0
 */
public class Canhu {
    public static void main(String[] args) {
        //输入数据
        Scanner scan = new Scanner(System.in);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        //初始化
        for (int i = 1; i <= 9; i++) {
            hashMap.put(i,0);
        }
        //录入13张牌
        int temp;
        for (int i = 0; i < 13; i++) {
            temp = scan.nextInt();
            hashMap.put(temp,hashMap.get(temp)+1);
        }
        for (int i = 1; i <= 9; i++) {
            //从新添加一个数据，满足14张牌
            if(hashMap.get(i) < 4){//当牌数等于4的时候，牌数已达上限，不能添加该牌
                hashMap.put(i,hashMap.get(i)+1);
                if (isHuPai(hashMap,14,false)){//能胡牌
                    result.add(i);//将满足条件的牌保存
                }
                hashMap.put(i, hashMap.get(i)-1);//将刚才添加的牌移除，继续循环，判断其他牌是否满足
            }
        }
        //输出结果
        if (result.size() == 0)
            System.out.println(0);
        for (Integer in : result){
            System.out.print(in + " ");
        }
    }
    public static boolean isHuPai(HashMap<Integer,Integer> mainMap,int count,boolean haveQue) {
        HashMap<Integer,Integer> map = new HashMap<>();//每次创建一个新的哈希表，否则更改了原数据，存在两个以上的结果时不能正确输出
        map.putAll(mainMap);//复制内容
        if (count == 0)//牌数清零，返回true
            return true;
        if (haveQue){//有雀头，不断尝试去掉一对刻子或者一组顺子
            for (int i = 1;i <= 9;i++){
                //尝试刻子
                if (map.get(i) >= 3){//大于3，有可能是刻子组合
                    map.put(i, map.get(i)-3);//-3，当做刻子组合
                    if(isHuPai(map,count-3,true))
                        return true;
                    map.put(i, map.get(i)+3);//未能返回，表示不对，恢复原数量
                }

                //尝试顺子
                if (i <= 7 && map.get(i) > 0 && map.get(i+1) > 0 && map.get(i+2) > 0){//连续存在，可能存在顺子
                    map.put(i, map.get(i)-1);//各个值减1
                    map.put(i+1, map.get(i+1)-1);
                    map.put(i+2, map.get(i+2)-1);
                    if (isHuPai(map,count-3,true)){//判断是否满足
                        return true;
                    }
                    map.put(i, map.get(i)+1);//表示上边if未执行，恢复原数据
                    map.put(i+1, map.get(i+1)+1);
                    map.put(i+2, map.get(i+2)+1);
                }
            }
            return false;//遍历完成，都没有返回，表示不能胡牌，返回false
        }else{//没有雀头，选择雀头
            for (int i = 1; i <= 9; i++) {
                if (map.get(i) >=2){
                    map.put(i, map.get(i)-2);
                    if (isHuPai(map,count-2,true))
                        return true;
                    map.put(i, map.get(i)+2);
                }
            }
            return false;//遍历完成，都没有返回，表示不能胡牌，返回false
        }
    }
}
