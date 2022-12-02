package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class No18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int B = Integer.parseInt(temp[2]);

        int[][] grounds = new int[500][500];
        int minLevel = 256;

        for(int height = 0; height < N; height++) {
            String[] input = br.readLine().split(" ");
            for(int width = 0; width < M; width++) {
                grounds[height][width] = Integer.parseInt(input[width]);
                if(minLevel > grounds[height][width])
                    minLevel = grounds[height][width];
            }
        }

        ArrayList<Pair18111> answers = new ArrayList<>();

        for(int level = 256; level >= minLevel; level--) {
            int tempB = B;
            int tempTime = 0;
            for(int height = 0; height < N; height++) {
                for(int width = 0; width < M; width++) {
                    if(grounds[height][width] > level) {
                        int diff = grounds[height][width] - level;

                        tempB += diff;
                        tempTime += diff * 2;
                    }
                }
            }

            boolean levelCheck = true;
            for(int height = 0; height < N; height++) {
                if(!levelCheck)
                    break;
                for(int width = 0; width < M; width++) {
                    if(!levelCheck)
                        break;
                    if(grounds[height][width] < level) {
                        int diff = level - grounds[height][width];

                        if(tempB < diff) {
                            tempB = 0;
                            levelCheck = false;
                            break;
                        }

                        tempB -= diff;
                        tempTime += diff;
                    }
                }
            }




            if(levelCheck) {
                answers.add(new Pair18111(tempTime, level));
            }
        }

        answers.sort(Comparator.naturalOrder());

        System.out.println(answers.get(0));
    }
}

class Pair18111 implements Comparable<Pair18111> {
    int first, second;

    public Pair18111(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return first + " " + second;
    }

    @Override
    public int compareTo(Pair18111 o) {
        if(first == o.first)
            return Integer.compare(o.second, second);
        return Integer.compare(first, o.first);
    }
}
