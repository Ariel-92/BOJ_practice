package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class No1927 {
    public static void main(String[] args) throws IOException {
        int[] nodes = new int[100002];
        int currentCount = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(currentCount == 0) {
                    sb.append(0).append('\n');
                }
                else {
                    sb.append(nodes[0]).append('\n');

                    nodes[0] = nodes[currentCount - 1];
                    nodes[currentCount - 1] = 0;

                    int index = 0;
                    while(index < 50000) {
                        int leftIndex = index * 2 + 1;
                        int rightIndex = index * 2 + 2;
                        int left = nodes[leftIndex] == 0 ? Integer.MAX_VALUE : nodes[leftIndex];
                        int right = nodes[rightIndex] == 0 ? Integer.MAX_VALUE : nodes[rightIndex];

                        int minvalue = Math.min(left, right);
                        boolean isMinLeft = left < right;
                        if(nodes[index] < minvalue) {
                            break;
                        } else {
                            int temp = nodes[index];
                            int childIndex = isMinLeft ? leftIndex : rightIndex;
                            nodes[index] = nodes[childIndex];
                            nodes[childIndex] = temp;
                            index = childIndex;
                        }
                    }
                    currentCount--;
                }
            }
            else {
                if(currentCount == 0) {
                    nodes[0] = x;
                } else {
                    nodes[currentCount] = x;

                    int index = currentCount;
                    while(index > 0) {
                        int parent = index / 2 - (index % 2 == 1 ? 0 : 1);
                        if(nodes[index] < nodes[parent]) {
                            int temp = nodes[index];
                            nodes[index] = nodes[parent];
                            nodes[parent] = temp;

                            index = parent;
                        }
                        else {
                            break;
                        }
                    }
                }
                currentCount++;
            }
        }

        System.out.println(sb);
    }
}
