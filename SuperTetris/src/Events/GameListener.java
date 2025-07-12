/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Events;

import Game.TetrisGame;
import java.util.EventListener;
import supertetris.blocks.Board;

/**
 *
 * @author diogo
 */
public interface GameListener extends EventListener {
    
    public void onGameOver();
    public void score(TetrisGame board);
    public void completeLines(TetrisGame board);
    public void numberPieces(TetrisGame board);

    
}
