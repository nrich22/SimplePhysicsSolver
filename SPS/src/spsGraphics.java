import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by nickricciarelli on 9/25/16.
 */
public class spsGraphics extends Application implements Observer {

    BorderPane BP = new BorderPane();
    VBox vb = new VBox();
    VBox vb2 = new VBox();

    /**
     * Method to build GUI
     *
     * @param stage
     */
    @Override
    public void start (Stage stage) {
        //Background
        BP.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #dc143c, #661a33)");

        //Title
        stage.setTitle("Simple Physics Solver");

        // load the image
        Image image = new Image("images/spsLogo.png");

        // simple displays ImageView the image as is
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitWidth(520);

        Button oneD = new Button("1-D w/ Const, Acceleration");
        Button pjm = new Button("Projectile Motion");
        Button UCM = new Button("Uniform Circular Motion");

        oneD.setOnAction(event -> {
            constA();
            BP.setCenter(vb);
        });

        pjm.setOnAction(event -> {
            ProMotion();
            BP.setCenter(vb2);
        });

        HBox hbox = new HBox(8); // spacing = 8
        hbox.getChildren().add(oneD);
        hbox.getChildren().add(pjm);
        hbox.getChildren().add(UCM);


        BP.setTop(iv1);
        BP.setBottom(hbox);

        Scene scene = new Scene(BP, 600, 750);
        stage.setScene(scene);
        stage.show();
    }

    public void ProMotion(){
        ProjMotion prob = new ProjMotion();

        Text title = new Text("Choose the variable you are solving for:");

        Label label1 = new Label("Time (t):");
        TextField Time = new TextField();

        Label label2 = new Label("Velocity in X direction (V0x/Vx):");
        TextField VOX = new TextField();

        Label label3 = new Label("Velocity in Y direction (Vy):");
        TextField VY = new TextField();

        Label label4 = new Label("Initial Velocity in Y direction (V0y):");
        TextField VOY = new TextField();

        Label label5 = new Label("Height (y):");
        TextField H = new TextField();

        Label label6 = new Label("Range (x):");
        TextField R = new TextField();

        Label label7 = new Label("Inital Hiegh (y0):");
        TextField IH = new TextField();

        Label label8 = new Label("Range (x0):");
        TextField IR = new TextField();

        Button Solve = new Button("Solve");

        Button t = new Button("t");
        Button r = new Button("x");
        Button y = new Button("y");
        Button v = new Button("V");
        Button v0 = new Button("V0y");
        Button vx = new Button("V0x/Vx");


        HBox solver = new HBox(8);
        solver.getChildren().addAll(t,r,v0,vx,v,y);

        Image image = new Image("images/spsPM.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitHeight(150);
        iv1.setFitWidth(350);

        vb2.getChildren().add(iv1);
        vb2.getChildren().add(title);
        vb2.getChildren().addAll(solver);
        vb2.setMaxWidth(300);
        vb2.setSpacing(10);

        r.setOnAction(event -> {
            vb2.getChildren().addAll(label8, IR);
            vb2.getChildren().addAll(label2, VOX);
            vb2.getChildren().addAll(label1, Time);
            vb2.getChildren().add(Solve);
            Solve.setOnAction(event2 -> {
                double X0 = Double.valueOf(IR.getText());
                double V = Double.valueOf(VOX.getText());
                double TT = Double.valueOf(Time.getText());
                double result = prob.findX(TT,X0,V);
                Text RS = new Text();
                RS.setText("Range (x) = " + String.valueOf(result) + " m");
                vb2.getChildren().add(RS);

            });
        });



    }


    public void constA(){
        constA prob = new constA();

        Text title = new Text("Choose the variable you are solving for:");

        Label label1 = new Label("Time (t):");
        TextField Time = new TextField();

        Label label2 = new Label("Acceleration (a):");
        TextField Acc = new TextField();

        Label label3 = new Label("Inital Velcoity (V0):");
        TextField IV = new TextField();

        Label label4 = new Label("Velcoity (V):");
        TextField V = new TextField();

        Label label6 = new Label("Initial Displacement (x0):");
        TextField x0 = new TextField();

        Button Solve = new Button("Solve");

        Button t = new Button("t");
        Button r = new Button("x");
        Button v0 = new Button("V0");
        Button v = new Button("V");
        Button a = new Button("a");


        HBox solver = new HBox(8);
        solver.getChildren().addAll(t,r,v0,v,a);

        Image image = new Image("images/spsCA.png");

        // simple displays ImageView the image as is
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitHeight(150);
        iv1.setFitWidth(350);

        vb.getChildren().add(iv1);
        vb.getChildren().add(title);
        vb.getChildren().addAll(solver);
        vb.setMaxWidth(300);
        vb.setSpacing(10);

        t.setOnAction(event -> {
            vb.getChildren().addAll(label2, Acc);
            vb.getChildren().addAll(label3, IV);
            vb.getChildren().addAll(label4, V);
            vb.getChildren().add(Solve);
            Solve.setOnAction(event2 ->{
                double ACC = Double.valueOf(Acc.getText());
                double IVV = Double.valueOf(IV.getText());
                double VV = Double.valueOf(V.getText());
                double result = prob.Time(VV,IVV,ACC);
                Text R = new Text();
                R.setText("Time (t) = "+String.valueOf(result)+" s");
                vb.getChildren().add(R);

            });
        });
        r.setOnAction(event -> {
            vb.getChildren().addAll(label6, x0);
            vb.getChildren().addAll(label2, Acc);
            vb.getChildren().addAll(label3, IV);
            vb.getChildren().addAll(label1, Time);
            vb.getChildren().add(Solve);
            Solve.setOnAction(event2 ->{
                double ACC = Double.valueOf(Acc.getText());
                double IVV = Double.valueOf(IV.getText());
                double X0 = Double.valueOf(x0.getText());
                double TT = Double.valueOf(Time.getText());
                double result = prob.Range(X0,IVV,TT,ACC);
                Text R = new Text();
                R.setText("Range (x) = "+String.valueOf(result)+" m");
                vb.getChildren().add(R);

            });
        });
        a.setOnAction(event -> {
            vb.getChildren().addAll(label4, V);
            vb.getChildren().addAll(label3, IV);
            vb.getChildren().addAll(label1, Time);
            vb.getChildren().add(Solve);
            Solve.setOnAction(event2 ->{
                double IVV = Double.valueOf(IV.getText());
                double VV = Double.valueOf(V.getText());
                double TT = Double.valueOf(Time.getText());
                double result = prob.instA(VV,IVV,TT);
                Text R = new Text();
                R.setText("Acceleration (a) = "+String.valueOf(result)+" m/s^2");
                vb.getChildren().add(R);

            });
        });
        v.setOnAction(event -> {
            vb.getChildren().addAll(label3, IV);
            vb.getChildren().addAll(label2, Acc);
            vb.getChildren().addAll(label1, Time);
            vb.getChildren().add(Solve);
            Solve.setOnAction(event2 ->{
                double IVV = Double.valueOf(IV.getText());
                double ACC = Double.valueOf(Acc.getText());
                double TT = Double.valueOf(Time.getText());
                double result = prob.instV(IVV,ACC,TT);
                Text R = new Text();
                R.setText("Velocity (v) = "+String.valueOf(result)+" m/s");
                vb.getChildren().add(R);

            });
        });
        v0.setOnAction(event -> {
            vb.getChildren().addAll(label4, V);
            vb.getChildren().addAll(label2, Acc);
            vb.getChildren().addAll(label1, Time);
            vb.getChildren().add(Solve);
            Solve.setOnAction(event2 ->{
                double VV = Double.valueOf(V.getText());
                double ACC = Double.valueOf(Acc.getText());
                double TT = Double.valueOf(Time.getText());
                double result = prob.initialV(VV,ACC,TT);
                Text R = new Text();
                R.setText("Initial Velocity (v0) = "+String.valueOf(result)+" m/s");
                vb.getChildren().add(R);

            });
        });


    }

    public void ProjMo(){
        Label label1 = new Label("Time (t):");
        TextField Time = new TextField();

        Label label2 = new Label("Acceleration (a):");
        TextField Acc = new TextField();

        Label label3 = new Label("Inital Velcoity (V0):");
        TextField IV = new TextField();

        Label label4 = new Label("Velcoity (V):");
        TextField V = new TextField();



        vb.getChildren().addAll(label1, Time);
        vb.getChildren().addAll(label2, Acc);
        vb.getChildren().addAll(label3, IV);
        vb.getChildren().addAll(label4, V);
        vb.setSpacing(10);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    /**
     * main function to launch GUI
     * @param args
     */
    public static void main(String[] args) {
        launch(args);

    }


}
