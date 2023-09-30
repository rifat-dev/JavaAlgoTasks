import java.util.Scanner;
import java.util.ArrayList;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String[] line1Arr = line1.split(" ");

        int n = Integer.parseInt(line1Arr[0]);
        int k = Integer.parseInt(line1Arr[1]);
        k %= n;

        String line2 = in.nextLine();
        String[] line2Arr = line2.split(" ");

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (String item: line2Arr) {
            try {
                int curIntItem = Integer.parseInt(item);
                list.add(curIntItem);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }

        if (k >= 0) {
            reverse(list, 0, n-k-1);
            reverse(list, n-k, list.size()-1);
            reverse(list, 0, list.size()-1);
        } else {
            int kAbs = Math.abs(k);
            reverse(list, 0, kAbs-1);
            reverse(list, kAbs, list.size()-1);
            reverse(list, 0, list.size()-1);
        }
        
        for (Integer item : list) {
            System.out.print(item);
            System.out.print(" ");
        }

        in.close();
    }

    public static void reverse(ArrayList<Integer> arrList, int startI, int endI) {
        while (startI < endI) {
            int buff = arrList.get(startI);
            arrList.set(startI, arrList.get(endI));
            arrList.set(endI, buff);

            startI++;
            endI--;
        }

    }
}