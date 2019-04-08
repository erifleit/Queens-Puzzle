# Queens-Puzzle

The Queens Puzzle is a puzzle in which you are meant to place 8 chess pieces in a chess board in such a way that no two pieces share the same column, row, or diagonal coordinates.

https://en.wikipedia.org/wiki/Eight_queens_puzzle

The algorithm in this code achieves this by the means of recursion in the function placer().

You can change the size of the board and the amount of queens for experimenting. Though for there to be a solution the number of queens must be equal or less than the width of the board (assuming a perfect square board).

Above 30 queens the code takes increasingly long to conclude, and with some slower computers it may take a very long time to achieve a solution. 
(30 queens takes aproximately 34 seconds, although 31 queens took only 10 seconds, so results may vary)

For an 8x8 board with 8 queens there's no need to use a very optimized version of the code so there's a simpler version which is slightly easier to understand called BoardSimple.java. 

This is an interesting way of solving this puzzle and a good case study for recursion.

Thank you for reading,

Eric Fleith.
