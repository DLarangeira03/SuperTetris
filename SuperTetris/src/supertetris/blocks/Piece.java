/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Graphics;

/**
 * piece of the tetris game
 *
 * @author diogo
 */
public class Piece extends BlockMatrix {

    //coordenates of the piece in the board
    private int positionX;
    private int positionY;

    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        int sizeX = width / getColumns();
        int sizeY = height / getLines();
        for (int y = 0; y < getLines(); y++) {
            for (int x = 0; x < getColumns(); x++) {
                if (!(matrix[y][x] instanceof Empty)) {
                    matrix[y][x].draw(gr, px + x * sizeX, py + y * sizeY, sizeX, sizeY);
                }
            }
        }
    }

    /**
     * parameterized constructor
     *
     * @param x position in the positionX axis
     * @param y position in the positionY axis
     * @param matrix BlockMatrix that will be transformed into a piece
     */
    public Piece(int x, int y, Block[][] matrix) {
        super(matrix);
        this.positionX = x;
        this.positionY = y;
    }

    /**
     * copy construtor
     *
     * @param p recives a Piece
     */
    public Piece(Piece p) {
        this(p.positionX, p.positionY, p.matrix);
    }

    /**
     * access to the positionX value
     *
     * @return the positionX position of the piece
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * update positionX value to the new position value
     *
     * @param x positionX position of the piece
     */
    public void setPositionX(int x) {
        this.positionX = x;
    }

    /**
     * access to the positionY value
     *
     * @return the positionY position of the piece
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * update positionY value to the new position value
     *
     * @param y positionY position of the piece
     */
    public void setPositionY(int y) {
        this.positionY = y;
    }

    /**
     * clones the piece
     *
     * @return
     */
    public Piece getClone() {
        return new Piece(this);
    }

    /**
     * moves the piece to the left
     */
    public void moveLeft() {
        positionX--;
    }

    /**
     * moves the piece to the right
     */
    public void moveRight() {
        positionX++;
    }

    /**
     * moves the piece down
     */
    public void moveDown() {
        positionY++;
    }

    /**
     * converts the position and the piece to a string
     *
     * @return String with the final position and the piece format
     */
    @Override
    public String toString() {
        String txt = "";
        txt = "(" + this.getPositionX() + "," + this.getPositionY() + ")\n";
        for (Block[] blocks : matrix) {
            for (Block block : blocks) {
                txt += block.toString();
            }
            txt += "\n";
        }
        return txt;
    }

}
