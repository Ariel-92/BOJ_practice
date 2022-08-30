package CLASS1;

import java.util.Scanner;

enum State{ASCENDING, DESCENDING, MIXED, DEFAULT}

public class No2920 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        State state = State.DEFAULT;

        for(int i = 1; i < 9; i++){
            int num = scanner.nextInt();
            if(state == State.DEFAULT){
                if(num == i)
                    state = State.ASCENDING;
                else if(num == 9 - i)
                    state = State.DESCENDING;
                else
                    state = State.MIXED;
            }
            else if(state == State.ASCENDING){
                if(num != i)
                    state = State.MIXED;
            }
            else if(state == State.DESCENDING){
                if(num != 9 - i)
                    state = State.MIXED;
            }
        }

        switch (state){
            case ASCENDING:
                System.out.println("ascending");
                break;
            case DESCENDING:
                System.out.println("descending");
                break;
            case MIXED:
                System.out.println("mixed");
                break;
        }
    }
}
