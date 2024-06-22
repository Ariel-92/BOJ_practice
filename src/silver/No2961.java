package silver;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class No2961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Node2961> foods = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int newSour = sc.nextInt();
            int newBitter = sc.nextInt();

            foods.add(new Node2961(newSour, newBitter, i, n));
        }

        int answer = 1000000000;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            Stack<Integer> sourStack = new Stack<>();
            Stack<Integer> bitterStack = new Stack<>();
            stack.push(i);

            sourStack.push(foods.get(i).sour);
            bitterStack.push(foods.get(i).bitter);

            int compare  = Math.abs(sourStack.peek() - bitterStack.peek());
            if(compare < answer) {
                answer = compare;
            }

            while(!stack.isEmpty()){
                Node2961 current = foods.get(stack.peek());

                if(current.hasAllvisited()) {
                    current.clearNodes();
                    stack.pop();
                    sourStack.pop();
                    bitterStack.pop();
                }
                else {
                    int next = current.nextNode();
                    if(stack.contains(next) || next <= i) {
                        current.addVisited(next);
                        continue;
                    }

                    stack.push(next);
                    foods.get(next).addVisited(current.foodNum);

                    sourStack.push(sourStack.peek() * foods.get(next).sour);
                    bitterStack.push(bitterStack.peek() + foods.get(next).bitter);

                    int temp = Math.abs(sourStack.peek() - bitterStack.peek());
                    if(temp < answer) {
                        answer = temp;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

class Node2961 {
    int sour = 1;
    int bitter = 0;
    int foodNum;
    Map<Integer, Boolean> nodes = new HashMap<>();

    Node2961(int sour, int bitter, int foodNum, int maxNum) {
        this.sour = sour;
        this.bitter = bitter;
        this.foodNum = foodNum;
        for(int i = 0; i < maxNum; i++){
            nodes.put(i, false);
        }
        nodes.put(foodNum, true);
    }

    public void addVisited(int prev) {
        nodes.put(prev, true);
    }

    public Integer nextNode() {
        AtomicReference<Integer> next = new AtomicReference<>();

        nodes.forEach((num, val) -> {
            if(!val) {
                next.set(num);
                return;
            }
        });

        nodes.put(next.get(), true);
        return next.get();
    }

    public void clearNodes() {
        Set<Integer> keys = nodes.keySet();

        keys.forEach((key) -> {
            nodes.put(key, false);
        });
        nodes.put(foodNum, true);
    }

    public boolean hasAllvisited() {
        return !nodes.containsValue(false);
    }
}