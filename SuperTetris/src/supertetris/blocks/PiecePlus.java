/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Color;

/**
 *creates the piece with '+' shape
 * @author diogo
 */
public class PiecePlus extends Piece {
    
    //new block with a image
    static Block plus = new PPurple();
    //matrix that shapes the piece
    private static Block[][] pPlus = {{new Empty(), plus, new Empty()},
                                      {plus,        plus, plus},
                                      {new Empty(), plus, new Empty(),}};

    public PiecePlus(){
        super(3, 0, pPlus);
    }  
    
}
