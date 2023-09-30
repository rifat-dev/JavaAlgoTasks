import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskF1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N];
        int leftSum = 0;

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int ans = -1;

        if (N == 1) {
            ans = 0;
            System.out.println(ans);
        } else if (N == 2) {
            System.out.println(ans);
        } else {
            int sumArr = 0;

            for (Integer item: numbers) {
                sumArr += item;
            }

            for (int i = 0; i < N; i++) {
                if (leftSum == sumArr - leftSum - numbers[i]) {
                    ans = i;
                    break;
                }
                leftSum += numbers[i];
            }

            System.out.println(ans);

        }

        br.close();
    }
}