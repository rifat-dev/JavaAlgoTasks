import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskE1 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int line1 = Integer.parseInt(reader.readLine());

            StringBuilder stringBuilder = new StringBuilder();
            char[] buffer = new char[8192];
            int totalCharsRead = 0;

            while (totalCharsRead < line1) {
                int charsToRead = Math.min(buffer.length, line1 - totalCharsRead);
                int charsRead = reader.read(buffer, 0, charsToRead);
                if (charsRead == -1) {
                    break;
                }
                stringBuilder.append(buffer, 0, charsRead);
                totalCharsRead += charsRead;
            }

            String line2 = stringBuilder.toString();
//        String line2 = in.nextLine();

            int s = 0;
            int e = line2.length() - 1;
            boolean ans = true;

            while (s < e) {
                if (line2.charAt(s) != line2.charAt(e)) {
                    ans = checkToPalindrom(line2, s + 1, e) || checkToPalindrom(line2, s, e - 1);
                    break;
                }
                s++;
                e--;
            }

            if (ans) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkToPalindrom(String text, int s, int e) {
        while (s < e) {
            if (text.charAt(s) == text.charAt(e)) {
                s++;
                e--;
            } else {
                return false;
            }
        }
        return true;
    }
}