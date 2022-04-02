package LeetCode.TH399;


import java.util.*;

/**
 * @ClassName Solution
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/4/2 14:27
 * @Version 1.0
 */
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        HashMap<String, Integer> variables = new HashMap<>();
        int n = equations.size();
        // 统计变量个数，重复的不计，按先后顺序put（x,0-n);为节点编号
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))){
                variables.put(equations.get(i).get(0),nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))){
                variables.put(equations.get(i).get(1),nvars++);
            }
        }
        // 创建每个点的权值表
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));
            // a-->b,权值为a/b=4，b-->a，权值为1.0/4
            edges[va].add(new Pair(vb,values[i]));
            edges[vb].add(new Pair(va,1.0/values[i]));
        }

        // 开始求解问题queries
        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        // 遍历每一个问题
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            // 图中存在，才能算，不存在不操作直接赋值ret[i] = -1；
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))){
                // 将问题中的a、b取出来[取出来的是代号]
                int ia = variables.get(query.get(0));
                int ib = variables.get(query.get(1));
                // 同一个数，返回1，，a/b==1
                if(ia == ib){
                    result = 1.0;
                }else{

                    LinkedList<Integer> points = new LinkedList<>();
                    points.offer(ia);
                    double[] ratios = new double[nvars];
                    // flag数组全置为-1，访问过的置为对应权值
                    Arrays.fill(ratios,-1.0);
                    ratios[ia] = 1.0;
                    // 开始搜索，
                    while (!points.isEmpty() && ratios[ib] < 0){
                        // ia出队
                        int x = points.poll();
                        // 遍历ia 的每一条边
                        for(Pair pair : edges[x]){
                            int y = pair.index;
                            double val = pair.value;
                            // 没访问过，访问并flag数组置为对应权值
                            if(ratios[y] < 0){
                                ratios[y] = ratios[x] * val;
                                // BFS，入队
                                points.offer(y);
                            }
                        }
                    }
                    // 找到了，ratios数组存的就是权值，或者根本不存在，存的-1
                    result = ratios[ib];
                }
            }
            ret[i] = result;
        }
        return ret;
    }
}

class Pair{
    int index;
    double value;
    Pair(int index,double value){
        this.index = index;
        this.value = value;
    }
}
