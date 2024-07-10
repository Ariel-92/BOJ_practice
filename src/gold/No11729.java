package gold;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class No11729 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Hanoi hanoi = new Hanoi(n);

        hanoi.solveProblem();
    }
}

class Hanoi {
    int n;
    int[] blocks = new int[20];
    ArrayList<String> answer = new ArrayList<>();

    Hanoi(int n) {
        this.n = n;
        for(int i = 0; i < n; i++) blocks[i] = 1;
    }

    public void solveProblem() throws IOException {
        for(int i = n - 1; i >= 0; i--) {
            move(i, 3);
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.append(answer.size() + "");
        bufferedWriter.append('\n');
        answer.forEach((str) -> {
            try {
                bufferedWriter.append(str);
                bufferedWriter.append('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bufferedWriter.flush();
    }

    void move(int number, int dest) {
        if(blocks[number] == dest) return;

        int other = dest + blocks[number] == 3 ? 3 : dest + blocks[number] == 4 ? 2 : 1;

        while(true) {
            boolean startCheck = true;
            int destCheckNum = 0;
            boolean destCheck = true;

            for(int i = number - 1; i >= 0; i--) {
                if(blocks[i] == blocks[number]) {
                    startCheck = false;
                    move(i, other);
                }
                if(blocks[i] == dest) {
                    if(destCheckNum < i) destCheckNum = i;
                    destCheck = false;
                }
            }
            if(startCheck && !destCheck) {
                move(destCheckNum, other);
            }

            if(startCheck && destCheck) break;
        }

        answer.add(blocks[number] + " " + dest);
        blocks[number] = dest;
    }
}