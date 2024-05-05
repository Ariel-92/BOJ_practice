package silver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class No7795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> bList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> answerList = new ArrayList<>();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            aList.add(new ArrayList<>());
            for(int j = 0; j < N; j++) {
                aList.get(i).add(sc.nextInt());
            }
            bList.add(new ArrayList<>());
            for(int j = 0; j < M; j++) {
                bList.get(i).add(sc.nextInt());
            }
        }

        for (int i = 0; i < T; i++) {
            // 정렬
            aList.get(i).sort(Comparator.naturalOrder());
            bList.get(i).sort(Comparator.naturalOrder());

            int aIndex = 0;
            int bIndex = 0;
            int answer = 0;
            while(aIndex < aList.get(i).size()) {
                if(aList.get(i).get(aIndex) > bList.get(i).get(bIndex)) {
                    if(bIndex == bList.get(i).size() - 1) {
                        answer += bIndex + 1;
                        aIndex++;
                    } else {
                        bIndex++;
                    }
                } else {
                    answer += bIndex;
                    aIndex++;
                }
            }
            answerList.add(answer);
        }

        for (int i = 0; i < T; i++) {
            System.out.println(answerList.get(i));
        }
    }
}
