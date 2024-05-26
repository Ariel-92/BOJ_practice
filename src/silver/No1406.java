package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        Stack<Character> answer = new Stack<>();
        Stack<Character> temp = new Stack<>();

        for(int i = 0; i < input.length; i++) {
            answer.push(input[i]);
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            char[] next = br.readLine().toCharArray();

            if (next[0] == 'L' && !answer.isEmpty()) {
                temp.push(answer.pop());
            } else if (next[0] == 'D' && !temp.isEmpty()) {
                answer.push(temp.pop());
            }
            if (next[0] == 'B' && !answer.isEmpty()) {
                answer.pop();
            } else if (next[0] == 'P') {
                answer.push(next[2]);
            }
        }

        br.close();

        StringBuilder stringBuilder = new StringBuilder();

        while(!answer.isEmpty()) {
            stringBuilder.append(answer.pop());
        }
        stringBuilder.reverse();
        while(!temp.isEmpty()) {
            stringBuilder.append(temp.pop());
        }

        System.out.println(stringBuilder);
    }
}