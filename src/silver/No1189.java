package silver;

import java.awt.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class No1189 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<char[]> map = new ArrayList<>();
        Map<Point, Node> nodes = new HashMap<>();
        sc.nextLine();

        for(int i = 0; i < R; i++){
            char[] row =  sc.nextLine().toCharArray();
            map.add(row);

            for(int j = 0; j < C; j++){
                if(row[j] == '.') {
                    nodes.put(new Point(i, j), new Node(new Point(i, j)));

                    if(i > 0 && map.get(i - 1)[j] == '.') {
                        nodes.get(new Point(i, j)).addNode(new Point(i - 1, j));
                        nodes.get(new Point(i - 1, j)).addNode(new Point(i, j));
                    }

                    if(j > 0 && row[j - 1] == '.') {
                        nodes.get(new Point(i, j)).addNode(new Point(i, j - 1));
                        nodes.get(new Point(i, j - 1)).addNode(new Point(i, j));
                    }
                }
            }
        }

        int answer = 0;
        Point dest = new Point(0, C - 1);
        Stack<Point> visitedPoint = new Stack<>();
        visitedPoint.push(new Point(R - 1, 0));

        while (visitedPoint.size() > 0) {
            Node current = nodes.get(visitedPoint.peek());

            if(current.hasAllVisited()) {
                current.clearNodeState();
                visitedPoint.pop();
            }
            else {
                Point next = current.nextNode();
                if(visitedPoint.contains(next)) {
                    continue;
                }

                visitedPoint.push(next);
                nodes.get(next).addVisited(current.point);

                if(visitedPoint.size() == K) {
                    nodes.get(next).clearNodeState();
                    visitedPoint.pop();
                    if(next.equals(dest)) answer++;
                }
            }
        }

        System.out.println(answer);
    }
}

class Node {
    Point point;

    Map<Point, Boolean> nodes = new HashMap<>();

    Node(Point point) {
        this.point = point;
    }

    public void addNode(Point next) {
        nodes.put(next, false);
    }

    public void addVisited(Point prev) {
        nodes.put(prev, true);
    }

    public Point nextNode() {
        AtomicReference<Point> next = new AtomicReference<>();
        nodes.forEach((point, val) -> {
            if(!val) {
                next.set(point);
                return;
            }
        });
        nodes.put(next.get(), true);

        return next.get();
    }

    public void clearNodeState() {
        Set<Point> keys = nodes.keySet();

        keys.forEach((key) -> {
            nodes.put(key, false);
        });
    }

    public boolean hasAllVisited() {
        return !nodes.containsValue(false);
    }
}