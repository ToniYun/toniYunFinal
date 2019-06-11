package yun;

import java.util.Scanner;

/**
 *
 * @author 955331921
 */
public class ConsoleUI {

    private Temperatures temps = new Temperatures();
    private Scanner scanIn = new Scanner(System.in);

    public void display() {
        int choice;
        do{
        System.out.println("Select on option: ");
        System.out.println("    0 - exit");
        System.out.println("    1 - add a temperature");
        System.out.println("    2 - view all temperatures");
        System.out.println("> ");
        choice = scanIn.nextInt();
        switch (choice) {
            case 1:
                addTemp();
                break;
            case 2:
                viewTemps();
                break;
        }
        } while (choice != 0);
    }

    private void addTemp() {
        System.out.println("Enter a temperature: ");
        int temp = scanIn.nextInt();
        temps.addTemperature(temp, System.currentTimeMillis());
    }

    private void viewTemps() {
        int[] tempsArr = temps.getTemperature();
        for (int i : tempsArr) {
            System.out.println(i);
        }
    }
}
