import java.io.*;
import java.util.ArrayList;

public class TaskG1 {
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> memNumber = new ArrayList<>();
        ArrayList<ArrayList<String>> memFunc = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = reader.readLine().split(" ");
        int t = Integer.parseInt(line1[0]);

        for (int i = 0; i < t; i++) {
            String[] curLine = reader.readLine().split(" ");
            int n = Integer.parseInt(curLine[0]);

            ArrayList<Integer> curRowNumber = new ArrayList<>();
            ArrayList<String> curRowOper = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                String inputLine = reader.readLine();
                String[] inputArr = inputLine.split(" ");
                String operator = inputArr[0];
                int number = Integer.parseInt(inputArr[1]);
                curRowOper.add(operator);
                curRowNumber.add(number);
            }

            memFunc.add(curRowOper);
            memNumber.add(curRowNumber);
        }

        ArrayList<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < memNumber.size(); i++) {
            int minBord = 15;
            int maxBord = 30;

            for (int j = 0; j < memNumber.get(i).size(); j++) {
                if (memFunc.get(i).get(j).equals("<=")) {
                    maxBord = Math.min(maxBord, memNumber.get(i).get(j));
                } else if (memFunc.get(i).get(j).equals(">=")) {
                    minBord = Math.max(minBord, memNumber.get(i).get(j));
                }

                if (minBord > maxBord) {
                    ansList.add(-1);
                } else {
                    ansList.add(minBord);
                }
            }
        }

        for (int item: ansList) {
            System.out.println(item);
        }
    }
}