package it.polimi.ingsw.gc03.model.enumerations;

import java.io.Serializable;

/**
 *
 */
public enum PlayerAction implements Serializable {
    FIRSTMOVES, // first moves stands for "placing the starter and selecting the objective"
    WAIT,
    PLACE,
    DRAW,
    DISCONNECTED,
    ENDED // This status can refer to both a player who has ended the game or who can not place any more card in the codex

}
