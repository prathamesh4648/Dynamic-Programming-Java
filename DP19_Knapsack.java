public class DP19_Knapsack {
    public static int robber(int ind,int v[],int w[],int weight){
        if(ind ==0){
            if(w[0]<=weight){return v[0];}
            else{
                return 0;
            }
        }

        int not= 0+robber(ind-1, v, w, weight);
        int take=Integer.MIN_VALUE;
        if(w[ind]<=weight){
            take=v[ind] + robber(ind-1, v, w, weight-w[ind]);
        }

        return Math.max(take,not);
    }

    public static void main(String args[]){
        int w[]={3,4,5,3};
        int v[]={30,50,60,40};
        System.out.println(robber(3, v, w, 8));
    }
}
