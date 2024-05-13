package it.polimi.ingsw.gc03.networking.socket.messages.serverToClientMessages;

import it.polimi.ingsw.gc03.listeners.GameListener;
import it.polimi.ingsw.gc03.model.GameModel;
import it.polimi.ingsw.gc03.model.Player;

import java.io.IOException;


/**
 * This class is used to send a message from the server to the client to inform that a player tried to join a full game.
 */
public class SocketServerMessageJoinUnableGameFull extends SocketServerGenericMessage {

    /**
     * The immutable game model.
     */
    private GameModel gameModel;

    /**
     * The player that tried to join.
     */
    private Player player;


    /**
     * Constructor of the class that creates the message.
     * @param gameModel The immutable game model.
     * @param player The player that tried to join.
     */
    public SocketServerMessageJoinUnableGameFull(GameModel gameModel, Player player) {
        this.gameModel = gameModel;
        this.player = player;
    }


    /**
     * Executes the appropriate action based on the content of the message.
     * @param gameListener The game listener to which this message's actions are directed.
     * @throws IOException If an input or output exception occurs during message processing.
     * @throws InterruptedException If the thread running the method is interrupted.
     */
    @Override
    public void execute(GameListener gameListener) throws IOException, InterruptedException {
        gameListener.joinUnableGameFull(this.gameModel, this.player);
    }


}
