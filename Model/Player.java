package Gitprojects.MyLLDTicTacToe.Model;

public class Player {

    public String name;
    public Piece piece;

    public Player(String name, Piece piece){
        this.name = name;
        this.piece= piece;
    }

    public String getName(){
        return name;
    }

    public Piece getPiece(){
        return piece;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }
    
}
