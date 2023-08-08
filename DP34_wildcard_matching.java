public class DP34_wildcard_matching {
    public static boolean wildcard(String s1,String s2,int i,int j){
        if(i<0 && j<0){
            return true;
        } 
        if(i<0 && j>=0){
            return false;
        }
        if(j<0 && i>=0){
             for(int k=0;k<=i;k++){
                if(s1.charAt(k)!='*'){
                    return false;
                }
                return true;
            }
        }

        if(s1.charAt(i)==s2.charAt(j)|| s1.charAt(i)=='?' ){
            return wildcard(s1, s2, i-1, j-1);
        }
        if(s1.charAt(i)=='*'){
            return wildcard(s1,s2,i-1,j) || wildcard(s1, s2, i, j-1);
        }
        return false;
    }

    public static void main(String args[]){
        System.out.println(wildcard("ab*cd","abdefcd", 4, 6)) ;
    }

}