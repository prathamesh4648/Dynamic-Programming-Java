import java.util.*;

public class DP45_longest_string_chain {
    public static int chain(String s[],int n){
        int maxi=1;
        Arrays.sort(s,Comparator.comparingInt(String::length));
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(check(s[i],s[j]) && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;

                }
            }
            maxi=Math.max(maxi,dp[i]);

        }
        return maxi+1;
    }

    public static boolean check(String s1,String s2){
        if(s1.length()!=s2.length()+1){return false;}
        int first = 0;
        int second = 0;

        while (first < s1.length()){
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }
            else {
                first++;
            }
        }
        if (first == s1.length() && second == s2.length()){
            return true;
        }
        else return false;
    }
    public static void main(String args[]){
        String arr[]={"a","ab","abc","acbd","djhdash"};
        System.out.println(chain(arr,5));
    }
}

