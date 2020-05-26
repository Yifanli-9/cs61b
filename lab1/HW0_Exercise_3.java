public class FINDMAX {
   public static int max(int[] m) {
      int z=0;
      int len=0;
      len=m.length;
      for(int t=0;t<len;t +=1){
         if(z>m[t]){
            z=z;
         }else{
            z=m[t];
            
     }       
         
         
      }
       return z;
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};   
      System.out.println(max(numbers));
   }
}