import java.io.*;
import java.util.*;

public class C_D2_201 {
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] as = new int[N];
        int max = -1;
        for(int i = 0; i< N; i++) {
            as[i] = in.nextInt();
            max = Math.max(max, as[i]);
        }
        int g = as[0];
        for(int i=0; i< N; i++){
            g = gcd(g, as[i]);
        }
        int round = max/g - N;
        if(round % 2 == 0){
            System.out.println("Bob");
        } else {
            System.out.println("Alice");
        }
   }
}