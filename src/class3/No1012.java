package class3;

import java.util.ArrayList;
import java.util.Scanner;

public class No1012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < T; i++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            Map map = new Map(M, N, K, scanner);

            answer.add(map.solve());
        }

        answer.forEach(item -> System.out.println(item));
    }
}

class Map {
    Node[][] field = new Node[50][50];
    ArrayList<Pair> lists = new ArrayList<>();
    Scanner scanner;

    int M, N;

    Map(int M, int N, int K, Scanner scanner) {
        this.scanner = scanner;
        this.M = M;
        this.N = N;

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                field[i][j] = new Node();
            }
        }

        for (int seed = 0; seed < K; seed++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            field[x][y].cabbage = 1;
            lists.add(new Pair(x, y));
        }
    }

    public int solve() {
        int count = 0;

        for(int i = 0; i < lists.size(); i++)  {
            Pair temp = lists.get(i);

            if(!field[temp.x][temp.y].isChecked) {
                search(temp.x, temp.y);

                count++;
            }
        }

        return count;
    }

    void search(int x, int y){
        if(field[x][y].isChecked)
            return;

        field[x][y].isChecked = true;

        if(x > 0) {
            if(field[x - 1][y].cabbage == 1)
                search(x - 1, y);
        }
        if(x < M - 1) {
            if(field[x + 1][y].cabbage == 1)
                search(x + 1, y);
        }
        if(y > 0) {
            if(field[x][y - 1].cabbage == 1)
                search(x, y - 1);
        }
        if(y < N - 1) {
            if(field[x][y + 1].cabbage == 1)
                search(x, y + 1);
        }
    }
}

class Node {
    public int cabbage = 0;
    public boolean isChecked = false;
    Node() {
        cabbage = 0;
        isChecked = false;
    }
}

class Pair {
    public int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
