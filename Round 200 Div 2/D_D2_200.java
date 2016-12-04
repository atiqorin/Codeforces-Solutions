import java.io.*;
import java.util.*;

public class D_D2_200 {
    public static String filename = "test";

    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader(filename+".in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String seq = in.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<seq.length();i++){
            if(!stack.isEmpty() && seq.charAt(i) == stack.peek()){
                stack.pop();
            } else {
                stack.push(seq.charAt(i));
            }
        }

        if (stack.isEmpty())
            System.out.println("Yes");
        else
            System.out.println("No");
        in.close();
        out.close();
        System.exit(0);
    }
}