package CLASS1;

import java.util.Scanner;

public class No8958 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String result = "";
        int max_count = scanner.nextInt();
        // nextInt 다음 nextLing 입력 받을 때 같은 라인에서 입력 받음
        // 다음 라인에서 입력받기 위해서 nextLine을 한 번 추가
        scanner.nextLine();

        for(int i = 0; i < max_count; i++){
            String answers = scanner.nextLine();
            int score = 0;
            int current = 0;
            for(int answer_idx = 0; answer_idx < answers.length(); answer_idx++){
                if(answers.charAt(answer_idx) == 'O'){
                    current++;
                    score += current;
                }
                else
                    current = 0;
            }
            result = result + score + '\n';
        }
        System.out.print(result);
    }
}
