import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskA3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N];
        boolean flag = true;

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N / 2; i++) {
            if ((2 * i + 1 < N && numbers[i] > numbers[2 * i + 1]) || (2 * i + 2 < N && numbers[i] > numbers[2 * i + 2])) {
                System.out.println("NO");
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        }
        
        br.close();
    }
}