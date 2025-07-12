/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Color;

/**
 *creates the piece with 'Z' shape
 * @author diogo
 */
public class PieceZ extends Piece {
    
    //new block with a image
    static Block z = new POrange();
    //matrix that shapes the piece
    private static Block[][] pZ = {{z, z, new Empty() },
                                   {new Empty(), z, z }};

    public PieceZ(){
        super(3,0, pZ);
    }
    
}
