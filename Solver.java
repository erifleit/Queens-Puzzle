public class Solver{
   public static void main(String arg[]){
      Board a = new Board(8,8);
      a.solver();
      System.out.println(a.printBoard());

      BoardSimple b = new BoardSimple(8,8);
      b.solver();
      System.out.println(b.printBoard());
   }
}
