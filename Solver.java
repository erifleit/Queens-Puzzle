public class Solver{
   public static void main(String a[]){
      Board b = new Board(8,8); 
      b.solver();
      System.out.println(b.printBoard());
   }
}
