package it.polimi.ingsw.gc03.view.tui;

import it.polimi.ingsw.gc03.model.enumerations.Kingdom;
import it.polimi.ingsw.gc03.model.enumerations.Value;
import it.polimi.ingsw.gc03.model.side.Side;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuiTest {

    @Test
    void tuiTest() {
        Tui tui = new Tui();
        tui.Tui(221, 67); // 221, 67 is the optimal screen dimension for 13inch 2560×1600
    }

    @Test
    void printSide() {
        Tui tui = new Tui();
    }
}