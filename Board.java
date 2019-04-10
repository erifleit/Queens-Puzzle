public class Board{

  private int size,queens,diagonals,diff;
  private boolean[][] board;
  private boolean[] columnIndex;
  private boolean[] diagIndex1;
  private boolean[] diagIndex2;

  public Board(){}
  public Board(int s, int q){
    size = s;
    queens = q;
    diagonals = (2*size)-1;
    diff = size-1;
    board = new boolean[size][size];
    columnIndex = new boolean[size];
    diagIndex1 = new boolean[diagonals];
    diagIndex2 = new boolean[diagonals];
    for(int i = 0 ; i < size ; i++){
      columnIndex[i] = false;
      for(int j = 0 ; j < size ; j++){
        board[i][j] = false;
      }
    }
  }

  public void place(int i, int j, boolean b){
    board[i][j] = b;
    columnIndex[i] = b;
    diagIndex1[i-j+diff] = b;
    diagIndex2[j+i] = b;
  }

  public boolean placer(int j, int queenNum){
    if(queenNum == 0) { // you've reached the end!
    System.out.println(diagIndex2[0]);
      return true;
    }
    for(int i = 0 ; i < size ; i++){
      if(checkClearance(i,j)){
        place(i,j,true);
        if(placer(j+1 , queenNum-1)){
          return true;
        }
        else{
          place(i,j,false);
        }
      }
    }
    return false;
  }

  public void solver(){
    placer(0, queens);
  }

  public boolean checkClearance(int i, int j){
    return (checkColumn(i) && checkDiagonals(i, j));
  }

  public boolean checkColumn(int i){
    return !columnIndex[i];
  }

  public boolean checkDiagonals(int i, int j){
    return !(diagIndex1[i-j+diff] || diagIndex2[j+i]);
  }

  public String printBoard(){
    String r = "";
    for(int i = 0 ; i < size ; i++){
      r += printLine(i);
      r += "\n";
    }
    return r;
  }

  public String printLine(int s){
    String r = "";
    for (int t = 0 ; t < size ; t++){
      if(board[t][s]){
        r += "[Q]";
      }
      else{
        r += "[ ]";
      }
    }
    return r;
  }
}
