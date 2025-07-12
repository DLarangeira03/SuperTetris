/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks;

import java.awt.Color;

/**
 *creates the piece with 'J' shape
 * @author diogo
 */
public class PieceJ extends Piece {
    
    //new block with a image
    static Block j = new PRed();
    //matrix that shapes the piece
    private static Block[][] pJ = {{j,          j,            j},
                                  {new Empty(), new Empty(), j }};

    public PieceJ(){
        super(3,0,pJ);
    }
    
}
