public class BoardSimple{

  private int size,queens;
  private boolean[][] board;

  public BoardSimple(){}
  public BoardSimple(int s, int q){
    size = s;
    queens = q;
    board = new boolean[size][size];
    for(int i = 0 ; i < size ; i++){
      for(int j = 0 ; j < size ; j++){
        board[i][j] = false;
      }
    }
  }

  public boolean placer( int j, boolean[][] paramBoard, int queenNum ){
    if(queenNum == 0) {
      board = paramBoard;
      return true;
    }
    boolean[][] tempBoard = paramBoard;
    for(int i = 0 ; i < size ; i++){
      if(checkRow(j,paramBoard) && checkDiagonal(i,j,paramBoard)){
        tempBoard[i][j] = true;
        if(placer(j+1 , tempBoard, queenNum-1)){
          return true;
        }
        else{
          tempBoard[i][j] = false;
        }
      }
    }
    return false;
  }

  public void solver(){
    placer(0,board,queens);
  }

  public boolean checkColumn(int i, boolean[][] paramBoard){
    for (int j = 0 ; j < size ; j++){
      if(paramBoard[i][j]){
        return false;
      }
    }
    return true;
  }

  public boolean checkDiagonal(int i, int j, boolean[][] paramBoard){
    int f = i;
    int g = j;
    while(f < size && g < size){
      if(paramBoard[f][g]) return false;
      else{
        f++; g++;
      }
    }
    f = i; g = j;
    while(f >= 0 && g >= 0){
      if(paramBoard[f][g]) return false;
      else{
        f--; g--;
      }
    }
    f = i; g = j;
    while(f < size && g >= 0){
      if(paramBoard[f][g]) return false;
      else{
        f++; g--;
      }
    }
    f = i; g = j;
    while(f >= 0 && g < size){
      if(paramBoard[f][g]) return false;
      else{
        f--; g++;
      }
    }
    return true;
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
