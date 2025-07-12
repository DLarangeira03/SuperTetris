/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Color;

/**
 *creates the piece with 'S' shape
 * @author diogo
 */
public class PieceS extends Piece {
    
    //new block with a image
    static Block s = new PBlue();
    //matrix that shapes the piece
    private static Block[][] pS = {{new Empty(), s, s},
                                   {s, s, new Empty()}};

    public PieceS(){
        super(3,0, pS);
    }
    
    
    
}
