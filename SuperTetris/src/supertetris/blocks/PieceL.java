/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Color;

/**
 *creates the piece with 'L' shape
 * @author diogo
 */
public class PieceL extends Piece {
    
    //new block with a image
    static Block l = new PYellow();
    //matrix that shapes the piece
    private static Block[][] pL = {{l, l,           l          },
                                   {l, new Empty(), new Empty()}};

    public PieceL(){
        super(3,0, pL);
    }
    
}
