package LeetCode.TH541;

public class Test_541 {
    public static void main(String[] args){
        Solution_541 test = new Solution_541();
        String result = test.reverseStr("skjfhkjfhuwiubi",3);
        String result2 = test.reverseStr("abcdefg",2);
        String result3 = test.reverseStr("abcd",2);
        String result4 = test.reverseStr("abcd",1);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
