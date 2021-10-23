package Cartoon2;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PortalMan {
    private BorderPane _portalMan;
    private Rectangle body;
    private Rectangle legs1;
    private Rectangle arms1;
    private Rectangle legs2;
    private Rectangle arms2;
    private Circle head;

    public PortalMan(BorderPane _pm) {
        this.body = new Rectangle(30,100, Color.GRAY);
        this.legs1 = new Rectangle(10,80, Color.GRAY);
        this.legs2 = new Rectangle(10,80, Color.GRAY);
        this.arms1 = new Rectangle(80,20, Color.GRAY);
        this.arms2 = new Rectangle(80,20, Color.GRAY);
        this.head = new Circle(10,100,30);

        _pm.getChildren().addAll(body,arms2,arms1,head,legs1,legs2);

        this.setX(200);
        this.setY(180);
    }
    //makes composite shape
    public void setX(double x){
        body.setTranslateX(x);
        legs1.setTranslateX(x);
        legs2.setTranslateX(x+20);
        arms1.setTranslateX(x-50);
        arms2.setTranslateX(x);
        head.setCenterX(x+15);
    }
    public void setY(double x){
        body.setTranslateY(x);
        legs1.setTranslateY(x+80);
        legs2.setTranslateY(x+80);
        arms1.setTranslateY(x);
        arms2.setTranslateY(x);
        head.setCenterY(x-20);
    }
    //gets location of the head
    public double getXloc(){
        return head.getCenterX();
    }
    public double getYloc(){
        return head.getCenterY();
    }

}
