
//水仙花数：一个三位数,其各位数字立方和等于该数本身。例如:153=1*1*1 + 5*5*5 + 3*3*3.这就说明153是一个水仙花数；
public class NarcissisticNumber {
    public static void main(String[] args){
        for (int i = 100; i <1000; i++) {
            int unit = i % 100 % 10; //个位
            int ten = i % 100 / 10;  //十位
            int hundred = i / 100;   //百位
            if(unit*unit*unit + ten*ten*ten + hundred*hundred*hundred == i){
                System.out.println(i);
            }
        }
    }
}
