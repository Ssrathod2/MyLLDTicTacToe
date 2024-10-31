package Gitprojects.MyLLDTicTacToe.Model;

import Gitprojects.MyLLDTicTacToe.Model.Piece;
import Gitprojects.MyLLDTicTacToe.Pair;
import java.util.ArrayList;
import java.util.List;

public class Board {

    public int size;
    public Piece[][] board;

    public Board(int size){
        this.size = size;
        board = new Piece[size][size];
    }

    public boolean addPiece(int row,int col, Piece piece){
        if(board[row][col] != null) return false;
        
            board[row][col] = piece;
            return true;
        
    }

    public List<Pair<Integer,Integer>> getFreeCels(){
        List<Pair<Integer,Integer>> lp = new ArrayList<>();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == null){
                    Pair<Integer,Integer> rowCol = new Pair<>(i,j);
                    lp.add(rowCol);
                }
            }
        }
        return lp;
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
              if(board[i][j] != null)
                System.out.print(board[i][j].piece.name() + "   ");
              else System.out.print("    ");

              System.out.print("  |  ");

            }
            System.out.println();
        }
        
    }


    
}
