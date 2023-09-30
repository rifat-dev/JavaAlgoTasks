import java.util.Scanner;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String[] line1Arr = line1.split(" ");

        int a = Integer.parseInt(line1Arr[0]);
        int b = Integer.parseInt(line1Arr[1]);

        int minN = Math.min(a, b);
        int maxN = Math.max(a, b);

        while (maxN % minN != 0) {
            int modN = maxN % minN;
            int buff = minN;
            maxN = Math.max(modN, buff);
            minN = Math.min(modN, buff);
        }

        System.out.println(minN);

        in.close();
    }
}