package Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName test
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2022/4/1 22:59
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        int n = 6;
        for(int i = 0;i < n;){
            int j = i;


            i = j;
        }
        System.out.println(1234567);

//        List<String> list1 = new ArrayList<>();
//        list1.add(0,"abc,");
//        list1.add(0,"oo,");
//        list1.add(1,"dd,");
//        list1.add(2,"pp,");
//        list1.forEach(System.out::print);
//        System.out.println();
//
//        int[][] people = new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
//        for(int[] a : reconstructQueue(people)){
//            System.out.println(Arrays.toString(a));
//        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(0, person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
