package class2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class No10814 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        ArrayList<SimplePair> users = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            SimplePair temp = new SimplePair(scanner.nextInt(), scanner.next());

            users.add(temp);
        }

        users.sort(Comparator.naturalOrder());

        for(int i = 0; i < N; i++) {
            System.out.println(users.get(i));
        }
    }
}

class SimplePair implements Comparable<SimplePair>{
    int x;
    String y;

    public SimplePair(int x, String y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
    @Override
    public int compareTo(SimplePair o) {
        return Integer.compare(x, o.x);
    }
}
