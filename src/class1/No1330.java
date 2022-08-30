package CLASS1;

import java.util.Scanner;

public class No1330 {
    public static void main(String[] args){
        int A, B;
        Scanner scanner = new Scanner(System.in);

        A = scanner.nextInt();
        B = scanner.nextInt();

        if(A == B){
            System.out.println("==");
        }
        else if(A > B){
            System.out.println(">");
        }
        else{
            System.out.println("<");
        }
    }
}
