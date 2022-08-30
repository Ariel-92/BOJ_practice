package CLASS1;

import java.util.Scanner;

public class No10951 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String result = "";
        while(scanner.hasNextInt()){
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            int sum = A + B;
            result = result + sum + '\n';
        }

        System.out.print(result);
    }
}
