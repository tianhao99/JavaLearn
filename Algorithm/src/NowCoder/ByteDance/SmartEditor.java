package NowCoder.ByteDance;

import java.util.*;

/**
 * @ClassName SmartEditor
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/10/12 16:09
 * @Version 1.0
 */
public class SmartEditor {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<String> strs = new ArrayList<>();
        int n = scan.nextInt();
        for(int i = 0;i < n;i++){
            strs.add(scan.next());
        }
        for(String str : strs){
            System.out.println(SmartEditor(str));
        }


    }

    public static String SmartEditor(String str){
        int a = 0;
        int b = 1;
        int c = 2;
        int d = 3;
        if(str.length() == 3){
            if(str.charAt(a) == str.charAt(b) && str.charAt(a) == str.charAt(c)){
                return str.substring(0,c);
            }
            return str;
        }else if(str.length() < 3){
            return str;
        }
        while(true){
            if(str.charAt(a) == str.charAt(b) && str.charAt(a) == str.charAt(c)){
                str = str.substring(0,c) + str.substring(c+1);
            }else if(d < str.length() && str.charAt(a) == str.charAt(b) && str.charAt(c) == str.charAt(d)){
                str = str.substring(0,c) + str.substring(d);
            }else{
                a = b;
                b = c;
                c = d;
                d = d+1;
            }

            if(d > str.length()){
                break;
            }
        }
        return str;
    }

}
