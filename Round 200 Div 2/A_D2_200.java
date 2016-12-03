import java.io.*;
import java.util.*;

public class A_D2_200 {
    public static String filename = "test";
    
    public static void main(String [] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader(filename+".in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new
            OutputStreamWriter(System.out)));
        int N = Integer.parseInt(in.readLine());
        String last = in.readLine();
        int ans = 1;
        for (int i = 1; i < N; i++) {
            String cur = in.readLine();
            if(last.equals("10")){
                if(!cur.equals("10"))
                    ans++;
            } else {
                if(cur.equals("10"))
                    ans++;
            }
            last = cur;
        }
        System.out.println(ans);
        in.close();
        out.close();
        System.exit(0);
    }
}