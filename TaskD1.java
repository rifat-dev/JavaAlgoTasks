import java.io.*;

public class TaskD1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = reader.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int q = Integer.parseInt(line1[2]);

        int[][] table = new int[n+1][m+1];
        int counter = 0;

        for (int i = 0; i < q; i++) {
            String[] curLine = reader.readLine().split(" ");
            int e = Integer.parseInt(curLine[0]);
            int s = Integer.parseInt(curLine[1]);

            if (table[s][e] == 0) {
                table[s][e] = 1;
                counter++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(n * m - counter).append("\n");

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (table[i][j] == 0) {
                    sb.append(j).append(" ").append(i);
                    sb.append("\n");
                }
            }
        }

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}