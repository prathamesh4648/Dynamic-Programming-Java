public class DP33_min_distance_string {
    public static int min(String s1,String s2,int i,int j){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }

        if(s1.charAt(i)==s2.charAt(j)){
            return 0+min(s1,s2,i-1,j-1);

        }
        return 1 + Math.min(min(s1,s2,i-1,j),Math.min(min(s1,s2,i-1,j-1),min(s1,s2,i,j-1)));

    }

    public static int min2(String s1,String s2){
        int i=s1.length();
        int j=s2.length();
        return min(s1, s2, i-1, j-1);
    }
    public static void main(String args[]){
        System.out.println(min2("horse","ros"));
    }
}
