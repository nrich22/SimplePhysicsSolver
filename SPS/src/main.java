import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nickricciarelli on 9/21/16.
 */


public class main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in


        System.out.println("Welcome to Simple Physics Solver\n");
        System.out.println("1. 1-D Kinematics with Constant Accerleration");
        System.out.println("2. Projectile Motion\n");
        System.out.println("Type the number of your topic");
        System.out.println("Enter the problem number: ");
        int n1 = reader.nextInt();
        if (n1 == 1) {
            constA prog = new constA();
            prog.Solver(reader);
        }
        if (n1 == 2) {
            ProjMotion prog = new ProjMotion();
            prog.Solver(reader);
        }
    }
}