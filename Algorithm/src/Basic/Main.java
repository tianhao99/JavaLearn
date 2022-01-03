package Basic;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/12/27 9:33 PM
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nums = scan.nextInt();
        String temp = scan.nextLine();//读取换行符
        while ((nums--) != 0) {
            while (scan.hasNextLine()) {
                String record = scan.nextLine();
                if("".equals(record)){
                    continue;
                }
                String[] ss = record.split(" ");
                int n = Integer.parseInt(ss[0]);
                int m = Integer.parseInt(ss[1]);
                int[] set = new int[n+1];
                for(int i = 1;i <= n;i++){//初始化set数组，每个人的顶头上司都是自己
                    set[i] = i;
                }
                int[][] data = new int[m+1][2];
                for(int i = 1;i <= m;i++){
                    data[i][0] = scan.nextInt();
                    data[i][1] = scan.nextInt();
                    relation(set,data[i][0],data[i][1]);
                }
                int count = 0;
                for(int i = 1;i<=n;i++){
                    if(set[i] == i) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }
    public static void relation(int[] set,int a,int b){
        int x = find(set,a);
        int y = find(set,b);
        set[x] = y;
    }
    public static int find(int[] set,int a){
        int res = a;
        while(set[res] != res){
            res = set[res];
        }
        while(a != res){
            int j = set[a];
            set[a] = res;
            a = j;
        }
        return res;
    }

}

