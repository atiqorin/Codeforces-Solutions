import java.io.*;
import java.util.*;

public class D_D2_201 {
    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String virus = in.nextLine();
        String ans = lcs(s1, s2, virus);
        System.out.println(ans.length() == 0 ? "0": ans);
   }

   public static int[] buildAutomata(String pat) {
       int M = pat.length();
       int atmataIndx = 0;
       int patIndx = 1;
       int[] automata = new int[M];
       while(patIndx < M) {
           if(pat.charAt(atmataIndx) == pat.charAt(patIndx)){
               atmataIndx++;
               automata[patIndx] = atmataIndx;
               patIndx++; 
           } else {
               if(atmataIndx != 0) {
                   atmataIndx = automata[atmataIndx - 1];
               } else {
                   automata[patIndx] = 0;
                   patIndx++;
               }
           }
       }
       return automata;
   }

   public static boolean KMP(String str, String pat) {
       int[] automata = buildAutomata(pat);
       int M = pat.length();
       int N = str.length();

       int atmataIndx = 0;
       int i = 0;
       while(i < N) {
           if(str.charAt(i) == pat.charAt(atmataIndx)){
               i++;
               atmataIndx++;
               if(atmataIndx == M) {
                   return true;
               }
           } else if(i < N) {
               if(atmataIndx != 0) {
                   atmataIndx = automata[atmataIndx - 1];
               } else {
                   i++;
               }
           }
       }
       return false;
   }
   public static String lcs(String a, String b, String virus) {
       int [][] LCS = new int[a.length() + 1][b.length() + 1];

       for (int i = 0; i < a.length(); i++) {
           for (int j = 0; j < b.length(); j++) {
               if(a.charAt(i) == b.charAt(j)){
                   LCS[i + 1][j + 1] = LCS[i][j] + 1;
               } else {
                   LCS[i + 1][j + 1] = Math.max(LCS[i][j + 1], LCS[i + 1][j]);
               }
           }
       }

       StringBuilder sb = new StringBuilder();

       for(int i = a.length(), j = b.length(); i != 0 && j != 0; ) {
           if(a.charAt(i - 1) == b.charAt(j - 1)) {
               if(!KMP(sb.reverse().toString() + a.charAt(i - 1), virus)) {
                    sb.reverse();
                    sb.append(a.charAt(i - 1));
               }
               i--;
               j--;
           } else if(LCS[i][j] == LCS[i - 1][j]) {
               i--;
           } else if(LCS[i][j] == LCS[i][j - 1]) {
               j--;
           }
       }

       return sb.reverse().toString();
   }
}