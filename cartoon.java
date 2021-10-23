package Cartoon2;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class cartoon {
    private BorderPane root;
    private BorderPane scene;
    private PortalMan portalMan;
    private Label update;
    private double animation;


    public cartoon(BorderPane root) {
        this.root = root;
        this.scene = new BorderPane();
        this.portalMan = new PortalMan(root); //we must fill the parameter here because we declare it as a border pane in portalman, using root attatches it to the main FX so it will display properly
        this.setupTimeline();
        this.updateLabel();
        this.root.getChildren().addAll(scene);
        root.setFocusTraversable(true);
        this.updateLabel();
        this.setScene();

        this.animation = 1; //sets the speed can be changed with A & D
    }

    public void setScene(){
        Pane sceneSetting = new Pane();
        this.scene.setCenter(sceneSetting);
        root.setOnKeyPressed((e) -> handleKeyPress(e));//th lambda statement that allows the keypresses to be heard

        //ActionEvent key = new KeyFrame((KeyEvent e) -> this.handleKeyPress(e));

        Ellipse portalOne = new Ellipse(500,200,75,150);
        portalOne.setFill(Color.BLUE);

        Ellipse portalTwo = new Ellipse(500,700,75,150);
        portalTwo.setFill(Color.ORANGE);

        Ellipse portalOneGlow = new Ellipse(500,200,80,153);
        portalOneGlow.setOpacity(50);
        portalOneGlow.setFill(Color.BLUEVIOLET);
        Ellipse portalTwoGlow = new Ellipse(500,700,80,153);
        portalTwoGlow.setOpacity(50);
        portalTwoGlow.setFill(Color.YELLOW);
        sceneSetting.getChildren().addAll(portalOneGlow, portalTwoGlow, portalOne, portalTwo);
    }
//timeline with very small increments for smooth movement
    private void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(0.05),
                (ActionEvent e) -> this.MoveCartoon());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
//responsible for the movement and teleportation of the composite shape
    private void MoveCartoon(){
        portalMan.setX(portalMan.getXloc()+animation);

        //System.out.println (portalMan.getXloc());
        if (portalMan.getYloc() <= 500 && portalMan.getXloc() >= 450){
                portalMan.setY(670);
            //System.out.println("oops");

        }

        if (portalMan.getYloc() >= 500 && portalMan.getXloc() <= 450){
            portalMan.setY(170);
            this.update.setText("zappy");

        }else if (portalMan.getXloc() >= 450){
            portalMan.setY(670);
            this.update.setText("zippy");

        }

        if (portalMan.getXloc() >= 1000){
            portalMan.setX(0);
        }
        if (portalMan.getXloc() <= 0){
            portalMan.setX(1000);
        }

    }
    //hold all of the keyable identity, is used in a lambda expression in the scene setting area
    private void handleKeyPress(KeyEvent e){
        KeyCode keyPressed = e.getCode();
        if (keyPressed == KeyCode.D){
            animation+=1;
        }
        if (keyPressed == KeyCode.A){
            animation-=1;

        }
        e.consume();
    }
    private void updateLabel() {
        Pane labelSetting = new Pane();
        this.scene.setTop(labelSetting);
        update = new Label("zappy");
        update.setTranslateY(300);
        update.setTranslateX(300);
        update.setFont(new Font(48));
        labelSetting.getChildren().addAll(update);
    }


}
