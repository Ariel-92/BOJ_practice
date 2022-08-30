package class2;

import java.util.ArrayList;
import java.util.Scanner;

public class No7568 {
    // 이 문제 풀이의 포인트는 비교했을 때 덩치가 크다 작다로 구분 안되는 사람을 그룹화는 것이 아닌
    // 자신보다 큰사람의 숫자대로 랭크를 매겨야 한다는 것
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputCount = scanner.nextInt();
        ArrayList<ArrayList<Integer>> mans = new ArrayList<>();

        for(int i = 0; i < inputCount; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(scanner.nextInt()); // 몸무게
            temp.add(scanner.nextInt()); // 키
            mans.add(temp);
        }

        for(int current = 0; current < inputCount; current++) {
            int rank = 1;
            for(int compare = 0; compare < inputCount; compare++) {
                if(current == compare)
                    continue;

                if(mans.get(compare).get(0) > mans.get(current).get(0)
                && mans.get(compare).get(1) > mans.get(current).get(1))
                    rank++;
            }
            System.out.print(rank + " ");
        }
    }
}
