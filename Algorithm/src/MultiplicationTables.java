
//九九乘法表
public class MultiplicationTables {
    public static void main(String[] args){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i*j) + " ");
            }
            System.out.println();
        }
    }
}
