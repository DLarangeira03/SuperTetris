/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import Resources.Resources;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *creates a block that has a image
 * @author diogo
 */
public class BlockImage extends Block {
    
    ImageIcon image;
    
    /**
     * constructor with parameters
     * @param txt
     * @param color
     * @param image String, path to the image.png
     */
    public BlockImage(char txt, Color color, String image){
        super(txt, color);
        this.image = Resources.loadIcon("imagensPecas/" + image);
    }
    
    /**
     * constructor with parameters
     * @param txt
     * @param color
     * @param image ImageIcon, proper image
     */
    public BlockImage(char txt, Color color, ImageIcon image){
        super(txt, color);
        this.image = image;
    }
    
    /**
     * default Constructor
     */
    public BlockImage(){
        this(' ', Color.WHITE, "green.png");
    }
    
    /**
     * copy constructor
     * @param bi 
     */
    public BlockImage(BlockImage bi){
        this(bi.txt, bi.myColor, bi.image);
    }
    
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height){
        if(image != null){
            gr.drawImage(image.getImage(), px, py, width, height, null);
        } else {
            super.draw(gr, px, py, width, height);
        }
    }
    
    @Override
    public Block getClone(){
        return new BlockImage(this);
    }
    
}
