package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No7576 {
    public static void main(String[] args) throws IOException {
        Solve solve = new Solve();
        solve.solve();
    }
}

class Solve {
    int[][] box = new int[1000][1000];
    List<Integer[]> list = new ArrayList<>();

    void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        for (int i = 0; i < M; i++) {
            String[] lineInput = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(lineInput[j]);
                if(box[i][j] == 1) {
                    Integer[] temp = new Integer[2];
                    temp[0] = i;
                    temp[1] = j;
                    list.add(temp);
                }
            }
        }

        int answer = 0;

        while(true) {
            boolean change = false;
            boolean clear = true;

            List<Integer[]> newList = new ArrayList<>();

            for(int index = 0; index < list.size(); index++) {
                int i = list.get(index)[0];
                int j = list.get(index)[1];

                if(i > 0 && box[i - 1][j] == 0) {
                    change = true;
                    clear = false;
                    box[i - 1][j] = 1;
                    Integer[] add = {i - 1, j};
                    newList.add(add);
                }
                if(i + 1 < M && box[i + 1][j] == 0) {
                    change = true;
                    clear = false;
                    box[i + 1][j] = 1;
                    Integer[] add = {i + 1, j};
                    newList.add(add);
                }
                if(j > 0 && box[i][j - 1] == 0) {
                    change = true;
                    clear = false;
                    box[i][j - 1] = 1;
                    Integer[] add = {i, j - 1};
                    newList.add(add);
                }
                if(j + 1 < N && box[i][j + 1] == 0) {
                    change = true;
                    clear = false;
                    box[i][j + 1] = 1;
                    Integer[] add = {i, j + 1};
                    newList.add(add);
                }
            }

            list = newList;

            if(clear) {
                for(int y = 0; y < M; y++) {
                    for(int x = 0; x < N; x++) {
                        if(box[y][x] == 0) {
                            clear = false;
                            break;
                        }
                    }
                    if(!clear) break;
                }
            }

            if(!change && !clear) {
                answer = -1;
                break;
            }

            if(change) {
                answer++;
            }

            if(clear) {
                break;
            }
        }

        System.out.println(answer);
    }
}
