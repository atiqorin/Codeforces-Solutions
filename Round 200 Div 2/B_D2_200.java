import java.io.*;
import java.util.*;

public class B_D2_200 {
    public static String filename = "test";
    
    public static void main(String [] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader(filename+".in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new
            OutputStreamWriter(System.out)));
        String[] line = in.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);
        boolean found = false; 
        int av=-1,bv=-1,cv=-1;
        for(int i=0; i<=a; i++){
            av = i;
            bv = b-i;
            cv = c-bv;
            if(cv+i == a && av >=0 && bv >= 0 && cv >= 0){
                found=true;
                break;
            }
        }
        if(found)
            System.out.printf("%d %d %d\n",av,bv,cv);
        else
            System.out.println("Impossible");
        in.close();
        out.close();
        System.exit(0);
    }
}