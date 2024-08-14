package gold;

import java.util.Scanner;

public class No3107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ipv6 = scanner.nextLine();

        String[] ipv6List = ipv6.split(":");

        StringBuilder answer = new StringBuilder();
        int i = 0;
        int max = ipv6List.length;
        boolean hasLastBlank = false;
        if(ipv6List[0].length() == 0) {
            for(int j = 0; j < 8 - (ipv6List.length - 2); j++) {
                answer.append("0000:");
            }

            i = 2;
        }

        else if(ipv6.endsWith("::")) {
            hasLastBlank = true;
        }

        for(; i < max; i++) {
            if(ipv6List[i].length() == 0) {
                for(int j = 0; j < 9 - ipv6List.length; j++) {
                    answer.append("0000:");
                }
            }
            else {
                answer.append(String.format("%4s", ipv6List[i]));
                answer.append(":");
            }
        }

        if(hasLastBlank) {
            for(int j = 0; j < 8 - (ipv6List.length); j++) {
                answer.append("0000:");
            }
        }

        answer.deleteCharAt(answer.length() - 1);

        System.out.println(answer.toString().replace(" ", "0"));
    }
}
