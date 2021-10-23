package Cartoon2;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;



public class PaneOrg extends Parent {

    //TODO: use this class to set up your panes, your quit button, and to create an instance of your top-level logic class!
    private BorderPane root;
    private cartoon cartoon;

    public PaneOrg() {
        this.root = new BorderPane();
        BorderPane cartoon = new BorderPane();
        this.root.setPrefSize(1000, 900);
        this.cartoon = new cartoon(cartoon);
        this.root.getChildren().add(cartoon);
        this.quitButton();
    }
    public void quitButton(){
        VBox quit = new VBox();
        root.setBottom(quit);
        Button b1 = new Button("quit");
        quit.getChildren().addAll(b1);
        b1.setOnAction((ActionEvent e) -> this.Quit()); //lambda expression
    }

    public void Quit(){
        Platform.exit();
    }

    public BorderPane getRoot(){
        return root;
    }
}
