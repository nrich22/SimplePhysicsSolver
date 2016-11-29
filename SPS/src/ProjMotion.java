import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.sqrt;


/**
 * Created by nickricciarelli on 9/21/16.
 */
public class ProjMotion {

    public void Solver(Scanner reader){

        System.out.println("Enter the variable you are solving for t, V, Vy, V0y, Vx, V0x, y, or x");
        String unknown = reader.next();
        ProjMotion prog = new ProjMotion();

        if (unknown.equals("Vx") || unknown.equals("V0x")){
            prog.findVx(reader);
        }
        if (unknown.equals("t")){
            prog.findT(reader);
        }
        if (unknown.equals("Vy")){
            prog.findVy(reader);
        }
        if (unknown.equals("y")){
            prog.findY(reader);
        }
        if (unknown.equals("V0y")){
            prog.findV0y(reader);
        }
        if (unknown.equals("V")){
            prog.findV(reader);
        }

    }
    public void findV(Scanner reader){
        System.out.println("V = sqrt(Vx^2 + Vy^2) ");

        System.out.println("Enter value for Vy:");
        double Vy = reader.nextDouble();

        System.out.println("Enter value for Vx:");
        double Vx = reader.nextDouble();

        double result1 = Math.pow(Vx,2);
        double result2 = Math.pow(Vy,2);
        double V = Math.sqrt(result1+result2);

        System.out.println("V = "+V+" m/s");
    }

    public void findVx(Scanner reader){
        System.out.println("Vx = V0x");
        System.out.println("V0 = (x-x0)/t\n");

        System.out.println("Enter value for time:");
        double t = reader.nextDouble();

        System.out.println("Enter value for x0:");
        double x0 = reader.nextDouble();

        System.out.println("Enter value for x:");
        double x = reader.nextDouble();

        double Vx = (x-x0)/t;

        System.out.println("Vx = "+Vx+" m/s");
    }

    public void findVy(Scanner reader){
        System.out.println("Vy = V0y-gt");

        System.out.println("Enter value for V0y:");
        double V0y = reader.nextDouble();

        System.out.println("Enter value for t:");
        double t = reader.nextDouble();

        double Vy = V0y-9.8*t;

        System.out.println("Vy = "+Vy+" m/s");
    }

    public void findV0y(Scanner reader){
        System.out.println("V0y = Vy+gt");

        System.out.println("Enter value for Vy:");
        double Vy = reader.nextDouble();

        System.out.println("Enter value for t:");
        double t = reader.nextDouble();

        double V0y = Vy+9.8*t;

        System.out.println("V0y = "+V0y+" m/s");
    }

    public double findX(double t, double x0, double V0){

        double x = x0 + V0*t;

        return x;

    }

    public void findY(Scanner reader){
        System.out.println("1. y = -1/2gt^2 + V0y*t + y0");

        System.out.println("Enter value for V0y:");
        double V0y = reader.nextDouble();

        System.out.println("Enter value for t:");
        double t = reader.nextDouble();

        System.out.println("Enter value for y0:");
        double y0 = reader.nextDouble();

        double y = -4.9*(t*t) + V0y*t + y0;

        System.out.println("y = "+y+" m");

    }

    public void findT(Scanner reader){
        System.out.println("1. t = (x-x0)/Vx");
        System.out.println("2. t = (Vy-V0)/a");
        System.out.println("Choose equation you would like to use by entering 1 or 2");

        double entry = reader.nextDouble();

        if (entry == 1){
            System.out.println("Enter value for x:");
            double x = reader.nextDouble();

            System.out.println("Enter value for x0:");
            double x0 = reader.nextDouble();

            System.out.println("Enter value for Vx or V0x:");
            double V0 = reader.nextDouble();

            double t = (x-x0)/V0;

            System.out.println("t = "+t+" s");
        }

        if (entry == 2){
            System.out.println("Enter value for Vy:");
            double Vy = reader.nextDouble();

            System.out.println("Enter value for V0y:");
            double V0y = reader.nextDouble();

            System.out.println("Enter value for a:");
            double a = reader.nextDouble();

            double t = (Vy+V0y)/a;

            System.out.println("t = "+t+" s");
        }

    }

}
