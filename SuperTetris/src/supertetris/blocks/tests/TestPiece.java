/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks.tests;

import java.awt.Color;
import supertetris.blocks.Block;
import supertetris.blocks.Empty;
import supertetris.blocks.Piece;

/**
 *
 * @author diogo
 */
public class TestPiece {

    public static void main(String[] args) {
        Block[][] B = {{new Empty(), new Block('S', Color.GREEN), new Block('S', Color.GREEN)}, {new Block('S', Color.GREEN), new Block('S', Color.GREEN), new Empty()}};
        Piece p = new Piece( 1, 4, B);
        System.out.println("piece = " + p);
        p.moveRight();
        p.rotate();
        System.out.println("Right and rotate = " + p);
    }

}
