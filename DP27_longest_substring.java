public class DP27_longest_substring {
    public static int lcs(String s1,String s2){
        int i1=s1.length();
        int i2=s2.length();

        int dp[][]=new int [i1+1][i2+1];
        for(int i=0;i<=i1;i++){
            dp[i][0]=0;

        }
        for (int j = 0; j <= i2; j++) {
            dp[0][j]=0;           
        }
        int ans=0;

        for(int k=1;k<=i1;k++){
            for(int l=1;l<=i2;l++){
                if(s1.charAt(k-1)==s2.charAt(l-1)){
                    dp[k][l]=1+dp[k-1][l-1];
                    ans=Math.max(ans,dp[k][l]);
                }
                else{
                    dp[k-1][l-1]=0;
                }
            }
        }

        return ans;
    }

    public static void main(String args[]){
        System.out.println(lcs("lcdes","hcdeg"));
    }

}
