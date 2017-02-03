import java.io.*;
import java.util.*;

public class D_D2_201 {
    public static int[] automata;
    static int s1len, s2len, M;
    static String s1, s2, virus;
    static int [][][] dp; 
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        s1 = in.nextLine();
        s2 = in.nextLine();
        virus = in.nextLine();
        s1len = s1.length();
        s2len = s2.length();
        M = virus.length();
        sb = new StringBuilder();
        dp = new int[s1len+1][s2len+1][M+1];
        for(int[][] twoD : dp){
            for(int[] oneD : twoD){
                Arrays.fill(oneD, -1);
            }
        }
        automata = buildAutomata(virus);

        int l = lcsdp(0,0,0);
        if(l==0) {
            System.out.println("0");
        } else {
            print(0,0,0);
            System.out.println(sb);
        }
    }

    public static int[] buildAutomata(String pat) {
        int M = pat.length();
        int atmataIndx = 0;
        int patIndx = 1;
        int[] automata = new int[M];
        while (patIndx < M) {
            if (pat.charAt(atmataIndx) == pat.charAt(patIndx)) {
                atmataIndx++;
                automata[patIndx] = atmataIndx;
                patIndx++;
            } else {
                if (atmataIndx != 0) {
                    atmataIndx = automata[atmataIndx - 1];
                } else {
                    automata[patIndx] = 0;
                    patIndx++;
                }
            }
        }
        return automata;
    }

    public static int lcsdp(int i, int j, int v) {
        int vBefore = v;
        if(i == s1len || j == s2len)
            return dp[i][j][v] = 0;
        if(dp[i][j][v] != -1)
            return dp[i][j][v];

        int ret = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            if(s1.charAt(i) == virus.charAt(v)){
                if(v+1 < M) {
                    ret = lcsdp(i+1, j+1, v+1) + 1;
                }
            }
            else {
                while(v != 0 && s1.charAt(i) != virus.charAt(v)){
                    v = automata[v - 1];
                }
                if(s1.charAt(i) == virus.charAt(v)) {
                    ret = lcsdp(i+1, j+1, v+1) + 1;
                } 
                else {
                    ret = lcsdp(i+1, j+1, v) + 1;   
                }
            }
        }
        ret = Math.max(ret, lcsdp(i+1, j, vBefore));
        ret = Math.max(ret, lcsdp(i, j+1, vBefore));
        return dp[i][j][vBefore] = ret;
    }

    public static void print(int i, int j, int v) {
        int vBefore = v;
        if(i == s1len || j == s2len) return;

        if(s1.charAt(i) == s2.charAt(j)) {
            if(s1.charAt(i) == virus.charAt(v)){
                if(v + 1 < M && dp[i][j][v] == dp[i+1][j+1][v+1] + 1) {
                    sb.append(s1.charAt(i));
                    print(i+1, j+1, v+1);
                    return;
                }
            }
            else {
                while(v != 0 && s1.charAt(i) != virus.charAt(v)){
                    v = automata[v-1];
                }
                if(s1.charAt(i) == virus.charAt(v) && dp[i][j][vBefore] == dp[i+1][j+1][v+1]+1){
                    sb.append(s1.charAt(i));
                    print(i+1, j+1, v+1);
                    return;
                } else {
                    if(dp[i][j][vBefore] == dp[i+1][j+1][v] + 1) {
                        sb.append(s1.charAt(i));
                    }
                    print(i+1, j+1,v);
                    return;
                }
            }
        }
        if(dp[i][j][vBefore] == dp[i+1][j][vBefore]){
            print(i+1,j,vBefore);
            return;
        }
        print(i,j+1,vBefore);
    }
}