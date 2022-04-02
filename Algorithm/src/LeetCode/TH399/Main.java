package LeetCode.TH399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Main
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/4/2 15:17
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] equations = {{"a","b"},{"b","c"},{"bc","cd"}};
        List<List<String>> equationsList = new ArrayList<>();
        for (int i = 0; i < equations.length; i++) {
            equationsList.add(Arrays.asList(equations[i]));
        }

        double[] values = {1.5,2.5,5.0};

        String[][] queries = {{"a","c"},{"c","b"},{"bc","cd"},{"cd","bc"}};
        List<List<String>> queriesList = new ArrayList<>();
        for (String[] strs : queries) {
            queriesList.add(Arrays.asList(strs));
        }


        // 调用
        double[] res = solution.calcEquation(equationsList,values,queriesList);
        for (double r : res){
            System.out.print(r + "\t");
        }



    }
}
