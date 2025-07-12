/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Color;
import java.awt.Graphics;

/**
 *creates a empty block
 * @author diogo
 */
public class Empty extends Block {

    
    /**
     * default constructor
     */
    public Empty() {
        super('.', Color.LIGHT_GRAY);
    }
    
    @Override
    public Block getClone(){
        return new Empty();
    }
    
    
}
