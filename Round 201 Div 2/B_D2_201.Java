import java.io.*;
import java.util.*;

public class B_D2_201 {
    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] as = new int[N];
        int[] diff = new int[N];
        int count = 0;
        for(int i = 0; i< N; i++) {
            as[i] = in.nextInt();
            if(as[i] == i)
                count++;
        }
        if(count == N){
            System.out.println(N);
            return;
        }
        int changeable = 0;
        for(int i = 0; i< N; i++){
            if(as[i] != i && as[as[i]] == i){
                changeable = 2;
            }
        }
        if(changeable != 0){
            System.out.println(count + 2);
        } else {
            System.out.println(count + 1);
        }
   }
}