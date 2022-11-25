package class2;


import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class No10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[10001];

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; ++i) {
            ++numbers[Integer.parseInt(br.readLine())];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 10001; ++i) {
            for(int j = 0; j < numbers[i]; ++j) {
                sb.append(i);
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }
}
