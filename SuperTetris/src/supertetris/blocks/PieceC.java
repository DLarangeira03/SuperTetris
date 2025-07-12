/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Color;

/**
 *creates the piece with 'C' shape
 * @author diogo
 */
public class PieceC extends Piece {
    
    //new block with a image
    static Block w = new PWine();
    //matrix that shapes the piece
    private static Block[][] pC = {{w,w},
                                   {w, new Empty(),},
                                   {w, w}};

    public PieceC(){
        super(3, 0, pC);
    }
    
}
