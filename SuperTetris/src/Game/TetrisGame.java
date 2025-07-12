/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Events.GameListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import supertetris.blocks.Block;
import supertetris.blocks.Board;
import supertetris.blocks.Empty;

/**
 *working tetris game board
 * @author diogo
 */
public class TetrisGame extends Board implements ActionListener, KeyListener {
    
    
    int score   = 0;
    int nLines  = 0;
    int nPieces = 0;
    GameListener listener;
    Timer timer;
    
    /**
     * parameters constructor
     * @param lines
     * @param columns 
     */
    public TetrisGame(int lines, int columns) {
        super(lines, columns);
        this.setFocusable(true);
        addKeyListener(this);
    }
    
    /**
     * default constructor
     */
    public TetrisGame() {
        this.setFocusable(true);
        addKeyListener(this);
        timer = new Timer(900,this);
        timer.start();

    }
    
    /**
     * game over
     * @return 
     */
    public boolean isGameOver() {
        if (current.getPositionY() == 0 && !canMovePiece(1, 0)){
            
            return true ;
        }
        return false;
    }
    
    /**
     * verify if line is full
     * @param line
     * @return 
     */
    public boolean isLineFull(int line) {
        for (int x = 0; x < matrix[line].length; x++) {
            if (matrix[line][x] instanceof Empty) {
                return false;
            }
        }
        return true;

    }
    
    /**
     * delete line
     * @param line 
     */
    public void deleteLine(int line) {
        //fall down all columns above line
        for (int y = line; y > 0; y--) //copy line y
        {
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x] = matrix[y - 1][x];
            }
        }
        //put an empty line in the first line
        for (int x = 0; x < matrix[0].length; x++) {
            matrix[0][x] = new Empty();
        }
    }
    
    /**
     * delete all full lines
     */
    public void deleteFullLines(){
        //iterate lines from bottom
        for(int y = matrix.length-1 ; y > 0; y--){
            //verify if line is full
            while( isLineFull(y)){
                //delete line
                deleteLine(y);
                score += 1000;
                listener.score(this);
                nLines ++;
                listener.completeLines(this);
            } 
        }
        
    }
    
    @Override
    public void freezePiece() {
        //call freeze of board
        super.freezePiece();
        score += 1;
        listener.score(this);
        nPieces ++;
        listener.numberPieces(this);
        //delete lines
        deleteFullLines();
    }
    
    
            
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getnLines() {
        return nLines;
    }

    public void setnLines(int nLines) {
        this.nLines = nLines;
    }

    public int getnPieces() {
        return nPieces;
    }

    public void setnPieces(int nPieces) {
        this.nPieces = nPieces;
    }

    
    
    
     @Override
     public void actionPerformed(ActionEvent e) {

            if(!(this.canMovePiece(1, 0))){
                this.freezePiece();
                this.generateRandomPiece();
                
            }else{
                this.moveDown();
            }
         
            if (isGameOver() == true) {
                listener.onGameOver();   
            }

            
            if (isGameOver() == false) {
                score += 1;
                listener.score(this);
            }
            
        }
    
    //listener to listener
    public void addTetrisListener(GameListener gl) {
        this.listener = gl;
    }


    @Override
    public void keyPressed(KeyEvent e) {
       if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) { //rotate piece
            this.rotate();
        } else
        
        //go down quicker
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            this.moveDown();
        }
            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) { 
                //move the piece left
                this.moveLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                //move the piece right
                this.moveRight(); 
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE){
                //fall the piece down
                this.fallDown();
            }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    
    
    
}
