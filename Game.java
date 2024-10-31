package Gitprojects.MyLLDTicTacToe;

import Gitprojects.MyLLDTicTacToe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class Game {

    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(){
        players = new LinkedList<>();

        PieceX crossPiece = new PieceX();
        PieceO noPiece = new PieceO();

        Player player1 = new Player("Sandeep",crossPiece);
        Player player2 = new Player("Vasudev",noPiece);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player playerTurn = players.removeFirst();

            gameBoard.printBoard();
            List<Pair<Integer,Integer>> freeSpace = gameBoard.getFreeCels();

            if(freeSpace.isEmpty()){
                noWinner=false;
                continue;
            }

            System.out.println("Player : "+ playerTurn.name + " Enter row,col : ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputCol,playerTurn.piece);

            if(!pieceAddedSuccessfully){
                System.out.println("Incorredt possition chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);
            boolean winner = isThereaWinner(inputRow,inputCol,playerTurn.piece.piece);
            if(winner) return playerTurn.name;

        }
        return "tie";
    }

    public boolean isThereaWinner(int row,int column,PieceType pieceType){

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].piece != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].piece != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].piece != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].piece != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

    
}
