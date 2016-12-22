import java.io.*;
import java.util.*;

public class E_D2_200 {
    public static String filename = "test";
    
    public static void main(String [] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader(filename+".in"));
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        long[] h = new long[N];
        long[] p = new long[M];
        for(int i=0; i< N; i++){
            h[i] = in.nextLong();
        }
        for(int i=0; i< M; i++){
            p[i] = in.nextLong();
        }

        long ans = -1;
        long lo = 0;
        long hi = (long)1E11;

        while (lo <= hi){
            long target = (lo+hi) / 2;

            if(check(h,p,target)){
                ans = target;
                hi = target - 1;
            } else {
                lo = target + 1;
            }
        } 
        System.out.println(ans);
        in.close();
        System.exit(0);
    }

    public static boolean check(long[] h, long[] p, long target){
        int i=0, j=0;

        while(i<h.length && j< p.length){
            long maxRight = h[i] + target;

            if(p[j] < h[i]){
                if( h[i] - p[j] > target) 
                    return false;
                long left = h[i] - p[j];
                maxRight = h[i] + Math.max(Math.max(target - left *2, (target -left)/2), 0);
            }
            while (j<p.length && p[j] <= maxRight)
                j++;
            i++;       
        }
        return j == p.length;
    }
}