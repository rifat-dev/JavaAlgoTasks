import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskE3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        buildMaxHeap(numbers, N);
        sortHeap(numbers, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
            if (i < numbers.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
        
        br.close();
    }

    private static void maxHeapify(int numbers[], int len, int indx) {
        int largeIndx = indx;
        int leftIndx = indx * 2 + 1;
        int rightIndx = indx * 2 + 2;

        if (leftIndx < len && numbers[leftIndx] > numbers[largeIndx]) {
            largeIndx = leftIndx;
        }

        if (rightIndx < len && numbers[rightIndx] > numbers[largeIndx]) {
            largeIndx = rightIndx;
        }

        if (largeIndx != indx) {
            int bufVal = numbers[indx];
            numbers[indx] = numbers[largeIndx];
            numbers[largeIndx] = bufVal;

            maxHeapify(numbers, len, largeIndx);
        }
    }

    private static void buildMaxHeap(int numbers[], int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeapify(numbers, len, i);
        }
    }

    private static void sortHeap(int numbers[], int len) {
        for (int i = len - 1; i >= 0; i--) {
            int bufVal = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = bufVal;

            maxHeapify(numbers, i, 0);
        }
    }
}
