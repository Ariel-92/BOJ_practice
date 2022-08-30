package CLASS1;

import java.util.Scanner;

public class No2562 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int maxNum = -1;
        int maxidx = 0;

        for(int i = 0; i < 9; i++){
            int number = scanner.nextInt();
            if(maxNum < number){
                maxNum = number;
                maxidx = i + 1;
            }
        }

        System.out.println(maxNum);
        System.out.println(maxidx);
    }
}
