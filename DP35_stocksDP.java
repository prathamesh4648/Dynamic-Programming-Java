public class DP35_stocksDP {
    public static int stocks(int s[]){
        int mini=s[0];
        int profit=0;
        for(int i=1; i<s.length; i++){
            int cost=s[i]-mini;
            profit=Math.max(cost,profit);
            mini=Math.min(mini,s[i] );
        }

        return profit;

    }   


    public static void main(String args[]){
        int st[]={7,1,5,3,6,4};
        System.out.println(stocks(st));
    }
}
