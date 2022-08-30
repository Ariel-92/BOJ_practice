package CLASS1;

import java.util.Scanner;

public class No1152 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] result = str.split(" ");
        int count = result.length;
        if(str.charAt(0) == ' ')
            count--;
        if(count < 0)
            count = 0;
        System.out.println(count);
    }
}
