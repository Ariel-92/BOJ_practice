package class2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class No11651 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pair> positions = new ArrayList<>();

        int N = scanner.nextInt();

        for (int i = 0; i < N; ++i) {
            positions.add(new Pair(scanner.nextInt(), scanner.nextInt()));
        }

        positions.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            sb.append(positions.get(i));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

class Pair implements Comparable<Pair> {
    int first, second;

    public Pair(int first, int last) {
        this.first = first;
        this.second = last;
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
    public int compareTo(Pair o) {
        if(second == o.second) return Integer.compare(first, o.first);
        return Integer.compare(second, o.second);
    }
}
