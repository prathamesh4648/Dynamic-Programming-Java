public class DP31_supsubseq {
    public static void supersub(String s1,String s2){
        int m=s1.length();
        int n=s2.length();
        int dp[][]=new int [m+1][n+1];
        for(int i1=0;i1<=m;i1++){
            dp[i1][0]=0;

        }
        for(int i2=0;i2<=n;i2++){
            dp[0][i2]=0;

        }

        for(int k1=1;k1<=m;k1++){
            for (int k2 = 1; k2 <=n; k2++) {
                if(s1.charAt(k1-1)==(s2.charAt(k2-1))){dp[k1][k2]= 1 + dp[k1-1][k2-1];}

                else{dp[k1][k2]= Math.max(dp[k1-1][k2],dp[k1][k2-1]);}

            }
        }
        
        String s="";
        int i=m;
        int j=n;
        while(i>0 && j>0){ 
            if(s1.charAt(i-1)==(s2.charAt(j-1))){
                s=s+s1.charAt(i-1);
                i--;
                j--;

            }
            else if(dp[i-1][j]>dp[i][j-1]){
                s=s+s1.charAt(i-1);
                i--;
            }
            else{
                s=s+s2.charAt(j-1);
                j--;
            }

            
        }
        while(i>0){
                s=s+s1.charAt(i-1);
                i--;

            }
        while(j>0){
                s=s+s2.charAt(j-1);
                j--;
        }

        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.length());
        System.out.println(sb);

    }   

    public static void main(String args[]){
        
        // System.out.println(supersub("abcde","anbdv",dp));
        supersub("brute", "groot");
    }
}
