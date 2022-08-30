package CLASS1;

import java.util.Scanner;

public class No10818 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int max_count = scanner.nextInt();
        int min = scanner.nextInt();
        int max = min;

        for(int i = 0; i < max_count - 1; i++){
            int num = scanner.nextInt();
            if(num < min)
                min = num;
            else if(num > max)
                max = num;
        }

        String result = "" + min + ' ' + max;
        System.out.print(result);
    }
}
