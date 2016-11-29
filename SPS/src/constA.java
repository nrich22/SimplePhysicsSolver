import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by nickricciarelli on 9/21/16.
 */
public class constA {

    public double instV(double V0x, double ax, double t) {
        double Vx;
        Vx = V0x + ax * t;
        return Vx;
    }

    public double Range(double x0, double V0x, double t, double a) {
        double x;
        x = .5 * a * (t * t) + (V0x * t) + x0;
        return x;
    }

    public double Time(double Vx, double V0, double ax) {
        double t;
        t = (Vx - V0) / ax;
        return t;
    }

    public double instA(double Vx, double V0, double dt) {
        double a;
        a = (Vx - V0) / (dt);
        return a;
    }

    public double initialV(double Vx, double ax, double t) {
        double Vi;
        Vi = -(ax * t) + Vx;
        return Vi;
    }

    public void Solver(Scanner reader) {
        double t = 0;
        double a = 0;
        double V0 = 0;
        double V = 0;

        System.out.println("Enter the variable you are solving for t, a, V0, V, or x");
        String unknown = reader.next();

        System.out.println("Enter a value for each value you have. ");

        if (!unknown.equals("t")) {
            System.out.println("Enter value for time:");
            t = reader.nextDouble();
        }
        if (!unknown.equals("a")) {
            System.out.println("Enter value for acceleration:");
            a = reader.nextDouble();
        }
        if (!unknown.equals("V0")) {
            System.out.println("Enter value for initial velocity:");
            V0 = reader.nextDouble();
        }
        if (!unknown.equals("V")) {
            System.out.println("Enter value for velocity:");
            V = reader.nextDouble();
        }

        constA problem = new constA();

        if (unknown.equals("V")) {
            System.out.println(unknown+" = "+problem.instV(V0, a, t)+" m/s");
        }

        if (unknown.equals("t")) {
            System.out.println(unknown+" = "+problem.Time(V, V0, a)+" s");
        }

        if (unknown.equals("x")) {
            System.out.println(unknown+" = "+problem.Range(0, V0, t, a)+ " m");
        }

        if (unknown.equals("V0")) {
            System.out.println(unknown+" = "+problem.initialV(V, a, t)+" m/s");
        }

        if (unknown.equals("a")) {
            System.out.println(unknown+" = "+(problem.instA(V, V0, t))+" m/s^2");
        }


    }


}