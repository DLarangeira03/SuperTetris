/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.blocks.tests;

import supertetris.blocks.Board;

/**
 *
 * @author diogo
 */
public class TestBoard {

    public static void main(String[] args) {
        Board b = new Board(10, 10);
        System.out.println("ORIGINAL \n" + b);
        
        for (int i = 0; i < 1; i++) {
            b.moveLeft();
        }
        
        b.moveLeft();
        System.out.println("Left \n" + b);
        for (int i = 0; i < 1; i++) {
            b.moveRight();
        }
        System.out.println("Right \n" + b);
        b.fallDown();
        System.out.println("FALL \n" + b);
        b.fallDown();
        b.fallDown();
        b.fallDown();
        b.fallDown();
        b.fallDown();
        b.fallDown();
        b.freezePiece();
        b.generateRandomPiece();
        b.fallDown();
        b.fallDown();
        b.rotate();
        System.out.println("Random \n" + b);
    }

}
