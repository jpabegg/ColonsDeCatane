package views.Modules;

import Model.Partie;
import controllers.ControlGame;
import controllers.ControlGameButton;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.Module;
import views.ViewConstants;

/**
 * Created by Mahel Sif on 01/03/2016.
 */


/**
 * Created by Mahel Sif on 25/01/2016.
 */
public class ModuleDe extends Module implements ViewConstants {

    public boolean isChecked;
    public Partie partie;

    private Image icone_cellule_energetique;
    private Image icone_gaz;
    private Image icone_minerai;
    private Image icone_cristaux;
    private Image icone_supraconducteur;

    private Image barUp;
    private Image barUpRight;

    private Image background_bouton;
    private Image imageDe;

    private ImageView background_boutonsView;
    private ImageView imageDeView;

    private double XPositionBoutons;
    private double YPositionBoutons;

    Stage stage;

    Text ressource;
    Rectangle barUpR;
    ImageView i;
    Button btn;

    private ImageView background_boutons[] = new ImageView[1];
    private ImageView icone_de[] = new ImageView[1];

    private Group root;

    public ModuleDe(Partie p, Group root, Stage s)
    {
        this.root = root;
        this.partie = p;
        this.stage = s;
        isChecked = false;

        XPositionBoutons = s.getWidth() - 100;
        YPositionBoutons = s.getHeight() - 100;

        initImage();
        drawDe();
        btn=new Button("",background_boutonsView);
        btn.setId("Button_De");
        btn.setPrefWidth(47.0);
        btn.setPrefHeight(47.0);
        btn.setLayoutX(setLayoutXCenter(btn,stage.getWidth()-150));
        btn.setLayoutY(setLayoutYCenter(btn,stage.getHeight()-450));
       //btn.setLayoutX(stage.getWidth()-150);
        //btn.setLayoutY(stage.getHeight() - 450);

    }

    public void draw(){

        //root.getChildren().remove(btn);
       root.getChildren().removeAll(icone_de);
      //  root.getChildren().removeAll(background_boutons);
        root.getChildren().remove(btn);

        drawDe();


       // root.getChildren().add(btn);
        //root.getChildren().addAll(background_boutons);

        root.getChildren().add(btn);
        root.getChildren().addAll(icone_de);

    }

    public void  initImage() {
        background_bouton = new Image(getClass().getResourceAsStream("/assets/img/background_bouton.png"));
        imageDe = new Image(getClass().getResourceAsStream("/assets/img/icone_de.png"));



    }

    public void drawDe()
    {
        icone_de[0] = new ImageView();
        background_boutons[0] = new ImageView(background_bouton);
        //drawButtonCenter(background_boutons[0], icone_de[0], background_bouton, imageDe, stage.getWidth()- 80, stage.getHeight() - 400, "button_de");
        drawImageCenter(icone_de[0], imageDe, stage.getWidth()- 80, stage.getHeight() - 400);
        btn = new Button("",background_boutons[0]);
        btn.setPrefWidth(imageDe.getWidth());
        btn.setPrefHeight(imageDe.getHeight());
        System.out.println(btn.getMaxHeight());
        btn.setLayoutX( setLayoutXCenter(btn, stage.getWidth()- 80));
        btn.setLayoutY( setLayoutYCenter(btn, stage.getHeight() - 400));
        btn.setId("bouton_de");

    }


}

