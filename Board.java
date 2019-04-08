public class Board{

  private int size,queens;
  private boolean[][] board;

  public Board(){}
  public Board(int s, int q){
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
    if(queenNum == 0) { // you've reached the end!
      board = paramBoard; 
      return true;
    }
    boolean[][] tempBoard = paramBoard;
    for(int i = 1 ; i < size ; i++){
      /*
        no need to try the first column (i == 0) because we know that's where the first piece is
      */
      if(checkClearance(i,j,paramBoard)){
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

  /*
    setting the first piece at square [0][0] before calling placer() helps reduce 5-10% iteration number
    since it no longer needs to check for column on the first iteration of loop in placer()
    and removes redundant step of doing checks for the first piece.
  */
  public void solver(){
    board[0][0] = true;
    placer(1, board, queens-1);
  }

  /*
    - no need to check for rows as we're specifically only placing one piece per row
    - we know that any piece in the main diagonal [i][j] where i == j will not pass the diagonal check
      so we check for i != j before calling any checking method
  */
  public boolean checkClearance(int i, int j, boolean[][] paramBoard){
    if(i == j) return false;
    else return (checkColumn(i, paramBoard) && checkDiagonal(i, j, paramBoard));
  }


  public boolean checkColumn(int i, boolean[][] paramBoard){
    /*
      since i != 0,
      [i][0] will always be false (an empty square)
      therefore there's no need to check for any [i][j] where j == 0
    */
    for (int j = 1 ; j < size ; j++){
      if(paramBoard[i][j]){
        return false;
      }
    }
    return true;
  }

  public boolean checkDiagonal(int i, int j, boolean[][] paramBoard){
    int f = i;
    int g = j;
    /*
      no need to check when f or g is equal to 0 in the loops
      since we know that will be the row or column where the first piece is
      and we already checked that:
      f != g so this piece is not in the main diagonal
    */
    while((f >= 1 && g >= 1)){ // checking northwest
      if(paramBoard[f][g]) return false;
      else{
        f--; g--;
      }
    }
    f = i; g = j;
    while(f < size && g < size){ // checking southeast
      if(paramBoard[f][g]) return false;
      else{
        f++; g++;
      }
    }
    f = i; g = j;
    while(f < size && g >= 1){ // checking "northeast"
      if(paramBoard[f][g]) return false;
      else{
        f++; g--;
      }
    }
    f = i; g = j;
    while(f >= 1 && g < size){ // checking "southwest"
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
