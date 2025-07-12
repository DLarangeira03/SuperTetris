/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Color;

/**
 *creates the piece with 'I' shape
 * @author diogo
 */
public class PieceI extends Piece {
    
    //new block with a image
    static Block i = new PGreen();
    //matrix that shapes the piece
    private static Block[][] pI = {{i, i, i, i} };

    public PieceI(){
        super(3,0,pI);
    }
    
}
