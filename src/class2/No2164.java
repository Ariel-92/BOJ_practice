package class2;

import java.util.ArrayList;
import java.util.Scanner;

public class No2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        // 숫자가 하나 남을 때까지 반복
        while(list.size() > 1) {
            // 리스트에서 원소를 하나씩 삭제하는 경우 timeout으로 문제풀이 실패
            // 한바퀴 돌았을 때 결과만 만들어서 복사하는 방법으로 변경
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 1; i < list.size(); i += 2) {
                temp.add(list.get(i));
            }
            if(list.size() % 2 == 1) temp.add(0, list.get(list.size() - 1));
            list = temp;
        }

        System.out.println(list.get(0));
    }
}
