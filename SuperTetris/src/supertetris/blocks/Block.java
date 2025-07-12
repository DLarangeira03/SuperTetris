/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import supertetris.gui.Drawable;

/**
 *creates a block
 * @author diogo
 */
public class Block extends JComponent implements Drawable {

    @Override
    public void paintComponent(Graphics gr) {
        draw(gr, 0, 0, getWidth()-1, getHeight()-1);
    }
    
    @Override
     public void draw(Graphics gr, int px, int py, int width, int heigh){
        gr.setColor(myColor); //fillblock 
        gr.fillRect(px, py, width, heigh); //color ofline 
        gr.setColor(Color.BLACK); //drawline 
        gr.drawRect(px, py, width, heigh);
     }
    
    /**
    * character of the block
    * color of the block
    */
    protected char txt;
    protected Color myColor;
    
    
    
    /**
     * constructor with parameters
     *
     * @param txt character of the block
     */
    public Block(char txt, Color color) {
        this.txt = txt;
        this.myColor = color;
    }
    
    
    /**
     * constructor
     */
    public Block(){
        this(' ', Color.GREEN);
    }
    
    
    /**
     *copy constructor
     * @param b original block
     */
    public Block(Block b) {
        this(b.txt, b.myColor);
    }

    /**
     *returns the character
     * @return character of the block
     */
    public char getTxt() {
        return txt;
    }

    /**
     *sets the new character into the block
     * @param txt new character
     */
    public void setTxt(char txt) {
        this.txt = txt;
    }

    /**
     * return the color of the block
     * @return 
     */
    public Color getMyColor() {
        return myColor;
    }
    
    /**
     * sets the block color
     * @param myColor 
     */
    public void setMyColor(Color myColor) {
        this.myColor = myColor;
    }
    
    
    
    /**
     * converts block to string
     *
     * @return text of block
     */
    @Override
    public String toString() {
        return txt + " ";
    }

    /**
     * makes a deep clone of the object
     *
     * @return deep clone
     */
    public Block getClone() {
        return new Block(this);
    }

}
