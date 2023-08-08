import java.util.*;
import java.util.stream.Collectors;

public class DP50_min_cost_tocutstick {
    private int minCostHelp(int i, int j, int dp[][], int cuts[]) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            mini = Math.min(mini,
                    cuts[j + 1] - cuts[i - 1] + minCostHelp(i, k - 1, dp, cuts) + minCostHelp(k + 1, j, dp, cuts));
        }
        return dp[i][j] = mini;
    }
    public int minCost1(int len, int[] cuts) {
        int n = cuts.length;
        int tmp[] = new int[n + 2];
        tmp[0] = 0;
        tmp[n + 1] = len;
        for (int i = 0; i < n; i++)
            tmp[i + 1] = cuts[i];
        n += 2;
        Arrays.sort(tmp);

        int dp[][] = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return minCostHelp(1, n - 2, dp, tmp);
    }
    
    public static void main(String args[]){
        
    }

}




