package it.polimi.ingsw.gc03.view.gui;

import it.polimi.ingsw.gc03.model.*;
import it.polimi.ingsw.gc03.model.card.Card;
import it.polimi.ingsw.gc03.model.card.cardObjective.CardObjective;
import it.polimi.ingsw.gc03.model.enumerations.Value;
import it.polimi.ingsw.gc03.view.gui.controllers.LobbyController;
import it.polimi.ingsw.gc03.view.inputHandler.InputReaderGUI;
import it.polimi.ingsw.gc03.view.ui.UI;
import javafx.application.Platform;

import java.util.ArrayList;

public class Gui extends UI {

    private ApplicationGui applicationGui;
    private InputReaderGUI inputReaderGUI;
    private String nickname = null;

    public Gui(ApplicationGui applicationGui, InputReaderGUI inputReaderGUI){
        this.applicationGui = applicationGui;
        this.inputReaderGUI = inputReaderGUI;
        init();
    }

    @Override
    protected void init() {
        Platform.runLater(()->this.applicationGui.setupGUIInputController(this.inputReaderGUI));
    }

    @Override
    protected void moveScreenView(int x, int y) {

    }

    @Override
    protected void resizeScreenView(int x, int y) {

    }

    @Override
    protected void show_menuOptions() {
        Platform.runLater(()->this.applicationGui.setActiveScene(SceneEnum.MENU));
    }

    @Override
    protected void show_creatingNewGameMsg(String nickname) {
    }

    @Override
    protected void show_joiningFirstAvailableMsg(String nickname) {
    }

    @Override
    protected void show_joiningToGameIdMsg(int idGame, String nickname) {
    }

    @Override
    protected void show_inputGameIdMsg() {
        Platform.runLater(()->this.applicationGui.setActiveScene(SceneEnum.GAME_ID));
    }

    @Override
    protected void show_insertNicknameMsg() {
        Platform.runLater(()->this.applicationGui.setActiveScene(SceneEnum.NICKNAME));
    }

    @Override
    protected void show_chosenNickname(String nickname) {
    }

    @Override
    protected void show_gameStarted(GameImmutable gameImmutable) {
    }

    @Override
    protected void show_noAvailableGamesToJoin(String msgToVisualize) {
        Platform.runLater(()->this.applicationGui.showPopup(msgToVisualize,"ERROR"));
        Platform.runLater(()->this.applicationGui.openPopUps(SceneEnum.POPUP));

    }

    @Override
    protected void show_gameEnded(GameImmutable gameImmutable) {
        Platform.runLater(()->this.applicationGui.setActiveScene(SceneEnum.NICKNAME));
        inputReaderGUI.addTxt("\n");
    }

    @Override
    protected void show_playerJoined(GameImmutable gameImmutable, String nickname) {
        SceneEnum scene = null;
        switch (gameImmutable.getSize()){
            case 1,2 -> scene = SceneEnum.LOBBY2;
            case 3 -> scene = SceneEnum.LOBBY3;
            case 4 -> scene = SceneEnum.LOBBY4;
        }

        Platform.runLater(()->this.applicationGui.closePopUps());
        LobbyController lc = (LobbyController) this.applicationGui.getController(scene);
        Platform.runLater(()->lc.setUsername(this.nickname));
        Platform.runLater(()->lc.setGameId(gameImmutable.getIdGame()));
        SceneEnum finalScene = scene;
        Platform.runLater(()-> this.applicationGui.setActiveScene(finalScene));
        Platform.runLater(()->this.applicationGui.showLobby(gameImmutable));
    }

    @Override
    protected void showNextTurn(GameImmutable gameImmutable, String nickname) {
        Platform.runLater(()->this.applicationGui.showTurnUsername(gameImmutable));
    }

    @Override
    protected void show_playerHand(GameImmutable gameImmutable, String nickname) {
    }

    @Override
    protected void show_sentMessage(GameImmutable gameImmutable, String nickname) {

    }

    @Override
    protected void show_NaNMsg() {

    }

    @Override
    protected void show_returnToMenuMsg() {
    }

    @Override
    protected void addLatestEvent(String input, GameImmutable gameImmutable) {
        Platform.runLater(()->this.applicationGui.showLatestEvent(input, gameImmutable));
    }

    @Override
    protected int getLengthLongestMessage(GameImmutable gameImmutable) {
        return 0;
    }

    @Override
    protected void addMessage(ChatMessage msg, GameImmutable gameImmutable) {
        Platform.runLater(()->this.applicationGui.showChat(msg, gameImmutable));
    }

    @Override
    protected void show_noConnectionError() {
        Platform.runLater(()->this.applicationGui.showFatalError("Connection error!"));
        Platform.runLater(()->this.applicationGui.openPopUps(SceneEnum.POPUP));
    }

    @Override
    protected void showAskIndex(GameImmutable gameImmutable) {
        Platform.runLater(()->this.applicationGui.setActionIsPlace());
        Platform.runLater(()->this.applicationGui.showPopup("Please, place a card from your hand \n     by dragging it on the grid","Prompt"));
        Platform.runLater(()-> this.applicationGui.openPopUps(SceneEnum.POPUP));
    }

    @Override
    protected void show_wrongSelectionHandMsg() {
    }



    @Override
    protected void showAskCoordinates(GameImmutable gameImmutable) {
    }

    @Override
    protected void showAskToChooseADeck() {
        Platform.runLater(()->this.applicationGui.setActionIsDraw());
        Platform.runLater(()->this.applicationGui.showPopup("Please, choose a card to draw","Prompt"));
        Platform.runLater(()->this.applicationGui.openPopUps(SceneEnum.POPUP));
    }

    @Override
    protected void showCardCannotBePlaced(GameImmutable gameImmutable, String nickname) {
        Platform.runLater(()->this.applicationGui.showPopup("You can't place a card here!","Prompt"));
        Platform.runLater(()->this.applicationGui.openPopUps(SceneEnum.POPUP));
    }



    @Override
    protected void showInvalidInput() {
        Platform.runLater(()->this.applicationGui.showPopup("Invalid Input","ERROR"));
        Platform.runLater(()->this.applicationGui.openPopUps(SceneEnum.POPUP));
    }


    @Override
    protected void showCodex(GameImmutable gameImmutable) {
        Platform.runLater(()-> this.applicationGui.setActiveScene(SceneEnum.GAME_RUNNING));
        Platform.runLater(()-> this.applicationGui.showGameRunning(gameImmutable,nickname));
    }

    @Override
    protected void showAskSize(GameImmutable gameImmutable) {
        Platform.runLater(()->{this.applicationGui.setActiveScene(SceneEnum.CHOOSE_SIZE);});
    }

    @Override
    protected void show_sizeSetted(int size, GameImmutable gameImmutable) {
        SceneEnum scene = null;
        switch (size) {
            case 2 -> scene = SceneEnum.LOBBY2;
            case 3 -> scene = SceneEnum.LOBBY3;
            case 4 -> scene = SceneEnum.LOBBY4;
        }
        Platform.runLater(()->this.applicationGui.closePopUps());
        LobbyController lc = (LobbyController) this.applicationGui.getController(scene);
        Platform.runLater(()-> lc.setUsername(this.nickname));
        Platform.runLater(()-> lc.setGameId(gameImmutable.getIdGame()));
        SceneEnum finalScene = scene;
        Platform.runLater(()-> this.applicationGui.setActiveScene(finalScene));
        Platform.runLater(()->this.applicationGui.showLobby(gameImmutable));
    }

    @Override
    protected void showCardAddedToHand(GameImmutable gameImmutable, Card card) {

    }

    @Override
    protected void showWinner(GameImmutable gameImmutable) {
        Platform.runLater(()->this.applicationGui.showWinner(gameImmutable));
        Platform.runLater(()->this.applicationGui.openPopUps(SceneEnum.WINNERS));
        inputReaderGUI.addTxt("\n");
    }

    @Override
    protected void showObjectiveChosen(GameImmutable gameImmutable, CardObjective cardObjective, String nickname) {
    }

    @Override
    protected void showObjectiveNotChosen(GameImmutable gameImmutable) {
        Platform.runLater(()->this.applicationGui.showObjectiveNotChosen(gameImmutable));
        Platform.runLater(()->this.applicationGui.setActiveScene(SceneEnum.CARD_OBJECTIVE));
    }

    @Override
    protected void showReqNotRespected(GameImmutable gameImmutable, ArrayList<Value> requirementsPlacement) {
        Platform.runLater(()->this.applicationGui.showPopup("You can't place the card because you dont have enough resources on your Codex","ERROR"));
        Platform.runLater(()->this.applicationGui.openPopUps(SceneEnum.POPUP));
    }

    @Override
    protected void show_GameTitle() {
        Platform.runLater(()->this.applicationGui.setActiveScene(SceneEnum.GAME_TITLE));
        Platform.runLater(()->this.applicationGui.createNewWindow());

    }

    @Override
    protected void showInvalidNickname(String nickname) {
        Platform.runLater(()->this.applicationGui.showPopup("Invalid Nickname","ERROR"));
        Platform.runLater(()->this.applicationGui.openPopUps(SceneEnum.POPUP));
    }

    @Override
    protected void showObjectiveChosen(Game game, Card card) {

    }

    @Override
    protected void showAskSide(GameImmutable game, Card card) {

    }

    @Override
    protected void show_askSideStarter(GameImmutable game, String nickname) {
        Platform.runLater(()->this.applicationGui.show_askSideStarter(game, nickname));
        Platform.runLater(()->this.applicationGui.setActiveScene(SceneEnum.CARD_STARTER));
    }

    /**
     * Sets the player's nickname.
     *
     * @param nickname the player's nickname.
     */
    @Override
    protected void setNickname(String nickname) {
        if(this.nickname == null){
            this.nickname = nickname;
            this.applicationGui.setNickname(nickname);
        }
        if(nickname == null){
            this.nickname = null;
            this.applicationGui.setNickname(null);
        }
    }

    @Override
    protected void showDesk(GameImmutable gameImmutable, String player) {

    }

    @Override
    protected void showYouLeft() {
        Platform.runLater(()->this.applicationGui.setActiveScene(SceneEnum.NICKNAME));
    }

    @Override
    public void showChat(GameImmutable gameImmutable) {

    }

    @Override
    public void showPlayerDisconnected(String nickname) {
        Platform.runLater(()->this.applicationGui.showPopup(nickname+" has disconnected!","DISCONNECTION!"));
        Platform.runLater(()->this.applicationGui.openPopUps(SceneEnum.POPUP));
    }

    //@Override
    // public void showDrawnCard(GameImmutable model) {
    //}

    //@Override
    //public void showPoints(GameImmutable model) {
    //}

}
