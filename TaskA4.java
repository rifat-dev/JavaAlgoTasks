import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    public Node leftNode;
    public Node rightNode;
    public int val;

    public Node(int value) {
        this.val = value;
    }
}

class ToBinTreeConv {
    public int[] array;
    public int n;

    public ToBinTreeConv(int[] arrArg, int nArg) {
        this.array = arrArg;
        this.n = nArg - 1;
    }

    public Node arrayToBSTree(int l, int r) {
        if (l > r) {
            return null;
        }

        int middle = l + (r - l) / 2;
        Node rootNode = new Node(this.array[middle]);

        rootNode.leftNode = arrayToBSTree(l, middle-1);
        rootNode.rightNode = arrayToBSTree(middle+1, r);

        return rootNode;
    }

}

public class TaskA4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        ToBinTreeConv binTree = new ToBinTreeConv(numbers, n);
        Node node = binTree.arrayToBSTree(0, n-1);

        StringBuilder sb = new StringBuilder();

        PreorderTraversal(node, sb);
        sb.append(" ");
        System.out.println(sb.toString());

        br.close();
    }

    public static void PreorderTraversal(Node node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val + " ");
            PreorderTraversal(node.leftNode, sb);
            PreorderTraversal(node.rightNode, sb);
        }
    }
}