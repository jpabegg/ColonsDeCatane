package controllers;

import Exceptions.NumberSevenException;
import Exceptions.batiment.SuperExceptionBatiment;
import Exceptions.click.PositionsInvalidesException;
import Exceptions.ressource.OutOfCardException;
import Exceptions.ressource.SuperExceptionRessource;
import Exceptions.ressource.UnKnownRessource;
import Model.Batiments.Batiment;
import Model.Batiments.Colonie;
import Model.Joueur;
import Model.graph.Edge;
import Model.graph.Vertex;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import views.Modules.ModuleBanque;
import views.Modules.ModuleBarRaccourcis;
import views.panels.PanelGame;

/**
 * Created by Mahel Sif on 31/01/2016.
 */
public class ControlGameButton extends MainControl implements EventHandler<ActionEvent>{
    private Button btn;

    public ControlGameButton() {
        actualWindow.getGamePanel().setGameButtonController(this);
    }

    @Override
    public void handle(ActionEvent event) {
        Button bt= (Button) event.getTarget();
        if (bt.getId()=="bouton_banque" ) {
            actualWindow.getGamePanel().getBanque().changeSelected();
            actualWindow.getGamePanel().draw();
        }
        if(bt.getId()=="Button_skip"){
            System.out.println("skip");
            skiper();
        }
        event.consume();
    }




    public void skiper() {
        if (actualModel.getPartie().isPhaseConstruction() && actualModel.getPartie().getNbTour()>(actualModel.getPartie().getNbJoueur())*2-1) {
            actualModel.getPartie().setPhaseConstruction(false);
            actualModel.getPartie().annuleDeslances();
            actualModel.getPartie().joueurSuivant();
        }

    }
}
