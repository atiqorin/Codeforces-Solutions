import java.io.*;
import java.util.*;

public class A_D2_201 {
    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] as = new int[N];
        for(int i = 0; i< N; i++) {
            as[i] = in.nextInt();
        }
        Arrays.sort(as);
        int temp = as[N-1];
        as[N-1] = as[0];
        as[0] = temp;
        StringBuilder sb = new StringBuilder();
        sb.append(as[0]);
        for (int i = 1; i< N;  i++) {
            sb.append(" "+ as[i]);
        }
        System.out.println(sb.toString());;
   }
}