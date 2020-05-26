public class Zeno {
    public static void main(String[] args) {
        String a = "*";
        int t = 1;
        int u=1;
       while(u<6){
           t=1;
        while (t <= u) { 
            System.out.print(a);
           t=t+1;
        }
          System.out.println();
          u=u+1;
        }
    }
}