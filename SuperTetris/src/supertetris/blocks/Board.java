/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Graphics;
import java.util.Random;


/**
 *represents a tetris board
 * @author diogo
 */
public class Board extends BlockMatrix {
    
    @Override
    public void paintComponent(Graphics g) {
        draw(g, 0, 0, getWidth(), getHeight());
    }

    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        super.draw(gr, px, py, width, height);
        int sizeX = width / getColumns();
        int sizeY = height / getLines();       
        current.draw(gr, px + current.getPositionX() * sizeX,
                py + current.getPositionY() * sizeY,
                sizeX * current.getColumns(),
                sizeY * current.getLines());
    }
    
    
    /**
     * Piece in the board
     */
    protected Piece current;
    
    /**
     * default constructor
     */
    public Board(){
        this(20, 10);
    }
    
    /**
     * constructor with parameters
     * @param matrix
     * @param current 
     */
    public Board(Block[][] matrix, Piece current){
        super(matrix);
        this.current = new Piece(current);
    }
    
    /**
     * copy constructor
     * @param b 
     */
    public Board(Board b){
        this(b.matrix, b.current);
    }
    
    /**
     * Constructor with dimensions<br>
     * build a board with 2d board of empty pieces
     *
     * @param lines number of lines
     * @param columns number of columns
     */
    public Board(int lines, int columns) {
        resize(lines, columns);
    }

    @Override
    public void resize(int lines, int columns) {
        //new matrix of blocks with the dimensions required
        this.matrix = new Block[lines][columns];
        //iterate the matrix
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                //every block is type empty
                matrix[y][x] = new Empty();
            }
        }
        //generate a random Piece 
        generateRandomPiece();
        //repaint the board
        repaint();
    }
    
    public Piece getCurrent() {
        return current;
    }

    public void setCurrent(Piece current) {
        this.current = current;
    }
 
    /**
     * generate a random piece
     */
    public void generateRandomPiece(){
        //sorts a random number that will match a Piece
        Random rand = new Random();
        switch(rand.nextInt(9)){
            case 0:
                this.current = new PieceI();
                break;
            case 1:
                this.current = new PieceJ();
                break;
            case 2:
                this.current = new PieceL();
                break;
           case 3:
                this.current = new PieceO();
                break;     
           case 4:
                this.current = new PieceS();
                break;
           case 5:
                this.current = new PieceT();
                break;
           case 6:
                this.current = new PieceZ();
                break; 
           case 7:
               this.current = new PiecePlus();
               break;
           default:
               this.current = new PieceC();
            repaint();
        }
        
        //generate the piece in the center of the board
        int px = this.getColumns()/2 - current.getColumns()/2;
        current.setPositionX(px);
        current.setPositionY(0);
    }
    
    /**
     * the current piece transfer to the board
     */
     public void freezePiece() {
         //iterate the blocks from the Piece current 
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColumns(); x++) {
                //checks if it is empty
                if (current.getMatrix()[y][x] instanceof Empty)
                    continue;
                //add the clone Piece in the matrix 
                matrix[current.getPositionY() + y][current.getPositionX() + x] = current.getMatrix()[y][x].getClone();      
            }
        }
        repaint();
    }
    
    @Override
    public String toString(){
        //clone the board 
        Board clone = new Board(this);
        //add the piece to the board 
        clone.freezePiece();
        //verify the text in the board 
        String txt= "";
        //iterate the matrix elements one by one 
        for (int y = 0; y < clone.matrix.length; y++) {
            for (int x = 0; x < clone.matrix[y].length; x++) {
                //create empty pieces for the element
                txt += clone.matrix[y][x];
            }
            txt += "\n";
        }
        return txt;
    }
    
    /**
     * current piece can move to
     * @param dy displacement in y
     * @param dx displacement in x
     * @return 
     */
    public boolean canMovePiece(int dy, int dx){
        //iterate current piece block matrix
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColumns(); x++) {
                //if block is empty - continue to next
                if (current.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                //new position
                int px = current.getPositionX() + x + dx;
                int py = current.getPositionY() + y + dy;

                //is within limits
                if (px >= getColumns() || px < 0 || py >= getLines() || py < 0
                        //not Empty
                        || !(matrix[py][px] instanceof Empty)) {
                    return false; // NOT MOVE
                }
            }
        }
        return true; //CAN MOVE
    }
    
    /**
     * piece can rotate
     * @return 
     */
    public boolean canRotatePiece(){
        //clone piece
        Piece clone = current.getClone();
        //rotate clone
        clone.rotate();
        //piece is outside board
        if (clone.getPositionX() + clone.getColumns() > getColumns()) {
            return false;
        }
        //verify all the block of the clone
        for (int y = 0; y < clone.getLines(); y++) {
            for (int x = 0; x < clone.getColumns(); x++) {
                //block is empty - continue to next
                if (clone.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                //is in the limits 
                if (x < getColumns() && x >= 0 && y < getLines() && y >= 0
                        //is not empty
                        && !(matrix[y][x] instanceof Empty)) {
                    return false; // NOT Ratation avaiable
                }
            }
        }
        return true; // Can Rotate
        
    }
    
    /**
     * move the piece to the left
     */
    public void moveLeft(){
        if (canMovePiece(0, -1)) {
            current.moveLeft();
            repaint();
        }
        
    }
    
    /**
     * move the piece to the right
     */
    public void moveRight(){
        if (canMovePiece(0, 1)) {
            current.moveRight();
            repaint();
        }
    }
    
    /**
     * move the piece down
     */
    public void moveDown(){
        if (canMovePiece(1, 0)) {
            current.moveDown();
            repaint();
        } else {
            freezePiece();
            generateRandomPiece();
            repaint();
        }
    }
    
    /**
     * fall down the piece
     */
    public void fallDown(){
        while (canMovePiece(1, 0) == true){
            current.moveDown();
            repaint();
        }
    
    }
    
    @Override
    public void rotate(){
        if (canRotatePiece() == true){
            current.rotate();
            repaint();
        }
    }  
    
    
    
}
    
    

