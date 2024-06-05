package silver;

import java.awt.*;
import java.util.*;

public class No2667 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        Map<Point, Set<Point>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            String line = sc.nextLine();

            for (int j = 0; j < N; j++) {
                if(line.charAt(j) == '1') {
                    Set<Point> set = new HashSet<>();

                    if(j > 0 && line.charAt(j - 1) == '1') {
                        set.add(new Point(i, j - 1));
                        map.get(new Point(i, j - 1)).add(new Point(i, j));
                    }

                    if(i > 0 && map.containsKey(new Point(i - 1, j))) {
                        set.add(new Point(i - 1, j));
                        map.get(new Point(i - 1, j)).add(new Point(i, j));
                    }

                    map.put(new Point(i, j), set);
                }
            }
        }

        Stack<Point> stack = new Stack<>();
        Queue<Point> queue = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        map.forEach((key, value) -> {
            if(!stack.contains(key)) {
                stack.push(key);
                queue.addAll(value);

                int count = 1;
                while(!queue.isEmpty()) {
                    Point p = queue.poll();

                    map.get(p).forEach((next) -> {
                        if(!stack.contains(next) && !queue.contains(next)) {
                            queue.add(next);
                        }
                    });
                    stack.push(p);
                    count++;
                }
                answer.add(count);
            }
        });

        answer.sort(Comparator.naturalOrder());

        System.out.println(answer.size());
        for(int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
}
