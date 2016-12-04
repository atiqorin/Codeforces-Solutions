import java.io.*;
import java.util.*;

public class C_D2_200 {
    public static String filename = "test";
    static long calc(long a, long b){
        if(a <b){
            return calc(b,a);
        }
        if(b==1)
            return a;
        else {
            return a/b+calc(b,a%b);
        }
    }
    public static void main(String [] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader(filename+".in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new
            OutputStreamWriter(System.out)));
        String[] line = in.readLine().split(" ");
        long a = Long.parseLong(line[0]);
        long b = Long.parseLong(line[1]);

        System.out.println(calc(a,b));
        in.close();
        out.close();
        System.exit(0);
    }
}