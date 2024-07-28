package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No7569 {
    public static void main(String[] args) throws IOException {
        Solve7569 solve7569 = new Solve7569();
        solve7569.solve();
    }
}

class Solve7569 {
    int[][][] box = new int[100][100][100];
    List<Integer[]> ripeTomatoes = new ArrayList<>();

    void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);
        int H = Integer.parseInt(input.split(" ")[2]);

        for(int height = 0; height < H; height++) {
            for(int x = 0; x < M; x++) {
                String[] lineInput = br.readLine().split(" ");

                for(int y = 0; y < N; y++) {
                    box[height][x][y] = Integer.parseInt(lineInput[y]);
                    if(box[height][x][y] == 1) {
                        Integer[] temp = new Integer[3];
                        temp[0] = height;
                        temp[1] = x;
                        temp[2] = y;

                        ripeTomatoes.add(temp);
                    }
                }
            }
        }

        int answer = 0;

        while(true) {
            boolean change = false;
            boolean clear = true;

            List<Integer[]> newTomatoes = new ArrayList<>();

            for(int index = 0; index < ripeTomatoes.size(); index++) {
                int height = ripeTomatoes.get(index)[0];
                int x = ripeTomatoes.get(index)[1];
                int y = ripeTomatoes.get(index)[2];

                for(int add = -1; add < 2; add += 2) {
                    int tempH = height + add;
                    if(tempH >= 0 && tempH < H && box[tempH][x][y] == 0) {
                        change = true;
                        clear = false;
                        box[tempH][x][y] = 1;
                        Integer[] tomato = {tempH, x, y};
                        newTomatoes.add(tomato);
                    }

                    int tempX = x + add;
                    if(tempX >= 0 && tempX < M && box[height][tempX][y] == 0) {
                        change = true;
                        clear = false;
                        box[height][tempX][y] = 1;
                        Integer[] tomato = {height, tempX, y};
                        newTomatoes.add(tomato);
                    }

                    int tempY = y + add;
                    if(tempY >= 0 && tempY < N && box[height][x][tempY] == 0) {
                        change = true;
                        clear = false;
                        box[height][x][tempY] = 1;
                        Integer[] tomato = {height, x, tempY};
                        newTomatoes.add(tomato);
                    }
                }
            }

            ripeTomatoes = newTomatoes;

            if(clear) {
                for(int height = 0; height < H; height++) {
                    for(int x = 0; x < M; x++) {
                        for(int y = 0; y < N; y++) {
                            if(box[height][x][y] == 0) {
                                clear = false;
                                break;
                            }
                        }
                        if(!clear) break;
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