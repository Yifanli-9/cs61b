
public class FIB1 {
public static int fib(int n){
if(n<=1){
return n;}
else{	
return fib(n-1)+fib(n-2);
}
}	

 public static void main(String[] args) {
	 int x=9;
System.out.println(FIB1.fib(x));	 
	 
 }
}