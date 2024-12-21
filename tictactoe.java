package practice;


import java.util.Scanner;
// player1 = 1
//player2 = 2
// empty=0

public class tictactoe {
      static int winner = 0;
      static int player = 1;
      static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[3][3];

          while(winner==0)
          {
             if(count==9)
             {
                 System.out.println("Moves are exhausted!! sorry, you loosed the game");
                 break;
             }
              System.out.println("Now it is player"+player+" chance");
              System.out.println("enter the row for next move in between(0-"+ (board.length-1)+")");
              int row = sc.nextInt();
              System.out.println("enter the column for next move in between(0-"+ (board[0].length-1) +")");
              int col = sc.nextInt();
               int res = isvalid(row,col,board);
               if(res==0)
               {
                   continue;
               }
               else
               {
                   count++;
                   board[row][col]=player;
                   displayboard(board);
               }
              int res1 = checkwinner(row,col,board);
               if(res1==1)
               {
                   //winner won
                   break;
               }
               else
               {
                   //toggle/change the player
                   toggleplayer(player);
               }
          }
    }

       public static int isvalid(int row,int col,int[][] board)
       {
            //check if all the row and column is in the range or not
           if (row < 0 || row >= (board.length) || col < 0 || col >= (board[0].length)) {
               System.out.println("Invalid position! Row and column must be between 0 and 2. Try again.");
               return 0;
           }

           if(board[row][col]!=0)
              {
                  System.out.println("It is already occupied, try another");
                  return 0;
              }


                  return 1;

       }

       //checking for winner
    public static int checkwinner(int row,int col,int[][]board)
    {
        int rowscore=0;
        int colscore=0;
        int digscore=0;
        int crodigscore = 0;

        //row checking
        for(int i=0;i<board[0].length;i++)
        {
            if(board[row][i]==player)
            {
                rowscore++;
            }
        }

        //col checking
        for(int j=0;j<board.length;j++)
        {
            if(board[j][col]==player)
            {
                colscore++;
            }
        }

        //diagonal score
        for(int i=0,j=0; i<board.length && j<board[0].length; i++,j++)
        {
               if(board[i][j]==player)
               {
                   digscore++;
               }
        }

        //crodigscore
        for(int i=0,j=board[0].length-1; i<board.length && j>=0 ; i++,j--)
        {
            if(board[i][j]==player)
            {
                crodigscore++;
            }
        }

        //check the winner or not
        if(rowscore==3 || colscore==3 || digscore==3 || crodigscore==3)
        {
            winner=player;
            System.out.println("Congratulations!!, player "+player + " is the final winner");
            return 1;
        }

        return 0;
    }

    public static void toggleplayer(int p)
    {
        if(p==1)
        {
            player=2;
        }
        else
        {
            if(p==2)
            {
                player=1;
            }
        }
    }

    //displaying board
    public static void displayboard(int[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                System.out.print(board[i][j]+" ");
            }

            System.out.println();
        }
    }


}
