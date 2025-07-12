/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks.tests;

import supertetris.blocks.Piece;
import supertetris.blocks.PieceL;
import supertetris.blocks.PieceT;

/**
 *
 * @author diogo
 */
public class TestSpecificPieces {

    public static void main(String[] args) {
        Piece l = new PieceL();
        l.moveRight();
        l.rotate();
        l.rotate();
        l.rotate();
        System.out.println(l);
        Piece t = new PieceT();
        t.rotate();
        t.moveDown();
        System.out.println(t);
    }

}
