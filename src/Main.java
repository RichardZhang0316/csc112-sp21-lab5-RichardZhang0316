// template for toll plaza simulation
/*
Richard Zhang
Lab5
April/8/2021
CSC112
 */


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
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
        //This statement creates a toll booth called "Paris Hong" with 5 toll gates
        DeltaPlaza = new tollplaza(5, "Paris Hong");

        // read the vehicle information
        readInput();

        // simulate events for 30 minutes; each event is 5 minutes
        for(timestamp=258; timestamp< 288; timestamp+=5) {
            System.out.println("*** TIME = "+timestamp);
            NextEvent();
        }




    }

    // TODO -- put readInput() here
    //this method reads all the vehicles that need to pass the toll booth and put them in the ArrayList inventory.
    private static void readInput() {
        //open myvehicles as a Scanner
        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader("src/myvehicles.csv"));
        }
        catch(FileNotFoundException e){
            System.out.println("cannot find the file");
        }
        while(true) {
            try {
                String line = br.readLine();
                //as long as there is a line to read
                if (line == null) {
                    break;
                }
                Scanner sc = new Scanner(line);
                sc.useDelimiter(",");
                //read the classification as a string (vehicle, car, truck)
                String vehicleType = sc.next();
                //add a new car to the inventory
                if (vehicleType.equals("car")) {
                    inventory.add(new Car(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt(), sc.next(), sc.nextBoolean(), sc.nextInt()));
                }
                //add a new truck to the inventory
                else if (vehicleType.equals("truck")) {
                    inventory.add(new Truck(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt(), sc.nextDouble()));
                }
                //add a new vehicle in the inventory
                else if (vehicleType.equals("vehicle")) {
                    inventory.add(new Vehicle(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt()));
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex.toString());
            }
        }
        try {
            br.close();
        }
        catch(IOException ex){
            throw new RuntimeException(ex.toString());
        }


    }

    // *****************************

    public static void NextEvent(){

        // add a random number, bounded by 22 of vehicles to gates at plaza
        int newV = rand.nextInt(inventory.size());//???
        for(int i=0; i< newV; i++){
            // TODO --choose a vehicle randomly from the inventory and bring it into the toll plaza？？？

            /* The following line does several actions. First, it selects one vehicle from
            * all the vehicles (including cars and trucks) that need to pass the toll booth. Then, it assigns this
            * vehicle to one of the toll gate randomly. Then, this vehicle will be put at the end (tail) of the traffic
            * stream that need to pass this specific toll gate.
             * */
            DeltaPlaza.driveup(inventory.get(rand.nextInt(inventory.size())));
        }

        // process vehicles (collect tolls) for the event
        DeltaPlaza.processtolls();

        // produce report about the plaza after the simulation
        DeltaPlaza.report();

    }




}
