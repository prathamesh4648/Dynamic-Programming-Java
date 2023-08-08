public class DP30_min_conv_AtoB {
    public static int subseq(int i1,int i2,String s1,String s2){
        if(i1<0 ||i2<0){
            return 0;
        }
        if(s1.charAt(i1)==(s2.charAt(i2))){return 1 + subseq(i1-1,i2-1,s1,s2);}

        return Math.max(subseq(i1-1,i2,s1,s2),subseq(i1, i2-1, s1, s2));

    }
    public static int atob(String s1,String s2){
        int i1=s1.length()-1;
        int i2=s2.length()-1;
        int n=subseq(i1, i2, s1, s2);
        return i1+2+i2-2*n;
    }
    
    public static void main(String args[]){
        System.out.println(atob("ugc","deo"));
        // System.out.println(subseq(3,3,"ugc","deo"));
    }
}
