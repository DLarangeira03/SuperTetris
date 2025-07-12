/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Color;

/**
 *creates the piece with 'O' shape
 * @author diogo
 */
public class PieceO extends Piece {
    
    //new block with a image
    static Block o = new PCyan();
    //matrix that shapes the piece
    private static Block[][] pO = {{o, o },
                                   {o, o }};

    public PieceO(){
        super(0,0, pO);
    }
    
}
