package class3;

import java.util.*;

public class No1260 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Node1260> nodes = new HashMap<>();

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int V = scanner.nextInt();

        nodes.put(V, new Node1260());

        for(int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if(!nodes.containsKey(x)) {
                nodes.put(x, new Node1260());
            }

            if(!nodes.containsKey(y)) {
                nodes.put(y, new Node1260());
            }

            nodes.get(x).addNextNode(y);
            nodes.get(y).addNextNode(x);
        }

        nodes.forEach((integer, node1260) -> {
            node1260.sortNodes();
        });

        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> answer = new ArrayList<>();

        int tempNum = V;
        ArrayList<Integer> tempNexts = nodes.get(V).getNextNodes();
        nodes.get(V).setChecked(true);
        answer.add(V);

        for(int i = tempNexts.size() - 1; i >= 0 ; i--) {
            stack.add(tempNexts.get(i));
        }

        while(true) {
            // DFS
            if(stack.empty())
                break;

            int next = stack.pop();
            if(!nodes.get(next).isChecked) {
                tempNexts = nodes.get(next).getNextNodes();
                nodes.get(next).setChecked(true);
                answer.add(next);

                for(int i = tempNexts.size() - 1; i >= 0 ; i--) {
                    stack.add(tempNexts.get(i));
                }
            }
        }

        answer.forEach(integer -> {
            System.out.print(integer);
            System.out.print(' ');
        });
        System.out.println();

        nodes.forEach((integer, node1260) -> {
            node1260.setChecked(false);
        });

        Queue<Integer> queue = new LinkedList<>();
        tempNexts = nodes.get(V).getNextNodes();
        nodes.get(V).setChecked(true);
        answer = new ArrayList<>();
        answer.add(V);

        for(int i = 0; i < tempNexts.size(); i++) {
            queue.add(tempNexts.get(i));
        }

        while(true) {
            // BFS
            if(queue.isEmpty())
                break;

            int next = queue.poll();

            if(!nodes.get(next).isChecked) {
                tempNexts = nodes.get(next).getNextNodes();
                nodes.get(next).setChecked(true);
                answer.add(next);

                for(int i = 0; i < tempNexts.size(); i++) {
                    queue.add(tempNexts.get(i));
                }
            }
        }

        answer.forEach(integer -> {
            System.out.print(integer);
            System.out.print(' ');
        });
        System.out.println();
    }
}


class Node1260 {
    boolean isChecked = false;
    ArrayList<Integer> nextNodes = new ArrayList<>();

    Node1260() {

    }

    public void addNextNode(int node) {
        nextNodes.add(node);
    }

    public void sortNodes() {
        nextNodes.sort(Integer::compareTo);
    }

    public ArrayList<Integer> getNextNodes() {
        return nextNodes;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}