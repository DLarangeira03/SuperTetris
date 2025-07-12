/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Color;

/**
 *creates the piece with 'T' shape
 * @author diogo
 */
public class PieceT extends Piece {
    
    //new block with a image
    static Block t = new PPink();
    //matrix that shapes the piece
    private static Block[][] pT = {{t,           t,           t},
                                   {new Empty(), t, new Empty()}};

    public PieceT(){
        super(3,0, pT);
    }
    
}
