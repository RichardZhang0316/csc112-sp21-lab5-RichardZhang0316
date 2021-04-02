// template for toll plaza simulation
//
// April, 2021



import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static Random rand;                     // random number generator
    private static ArrayList<Vehicle> inventory;    // list of vehicles
    private static tollplaza DeltaPlaza;            // our ONE toll plaza
    private static int timestamp;                   // time stamp for events

    public static void main(String[] args) {

        // set up data for simulation
        rand = new Random();

        inventory = new ArrayList<Vehicle>();
        timestamp = 0;

        // TODO -- experiment with different toll plaza initializations
        DeltaPlaza = new tollplaza(4, "Harold L. Jones");

        // read the vehicle information
        readInput();

        // simulate events for 30 minutes; each event is 5 minutes
        for(; timestamp< 288; timestamp+=5) {
            System.out.println("*** TIME = "+timestamp);
            NextEvent();
        }




    }

    // *****************************

    public static void NextEvent(){

        // add a random number, bounded by ??, of vehicles to gates at plaza
        int newV = rand.nextInt(15);
        for(int i=0; i< newV; i++){

            // TODO --choose a vehicle randomly from the inventory and bring it into the toll plaza

        }


        // process vehicles (collect tolls) for the event
        DeltaPlaza.processtolls();

        // produce report about the plaza after the simulation
        DeltaPlaza.report();

    }

    // TODO -- put readInput() here


}
