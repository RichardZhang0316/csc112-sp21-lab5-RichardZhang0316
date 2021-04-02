// Class for a single tollgate
//
// April 2021
//
// Each tollgate has a queue of vehicles associated with it, a gaterate (the number of
// vehicles that can be processed in an event, and various members for collecting statistics
// about car, truck, and vehicle

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class tollgate {

    private Queue<Vehicle> myWaitingVehicles;     //  queue of cars for this booth
    private int tollGateHandlingRate;             //  average number of cars per 5 minutes
    private Random rand;                          //  random number generate

    // numbers of vehicles processed
    private int NumCars;
    private int NumTrucks;
    private int NumVehicles;

    // numbers of paid vehicles
    private int PaidCars;
    private int PaidTrucks;
    private int PaidVehicles;

    // tolls collected from vehicles
    private double CarTollTotal;
    private double TruckTollTotal;
    private double VehicleTollTotal;

    // initial tollgate, setup handling rate
    public tollgate(int Rate){
        assert(Rate>2): "Really low handling rate";
        this.rand = new Random();
        this.tollGateHandlingRate = Rate;
        this.myWaitingVehicles = new LinkedList<Vehicle>();     // instantiate interface Queue as a LinkedList
        this.NumCars = this.NumTrucks = this.NumVehicles = 0;
        this.PaidCars = this.PaidTrucks = this.PaidVehicles = 0;
        this.CarTollTotal = this.TruckTollTotal = this.VehicleTollTotal = 0.00;
    }


    // TODO -- Enter comments to explain what this method does
    public void queueup(Vehicle V){
        switch(V.getType()){
            case car:
                this.NumCars++;
                break;

            case truck:
                this.NumTrucks++;
                break;

            default:
                this.NumVehicles++;
        }
        this.myWaitingVehicles.add(V);

    }

    // in an event, process tolls and update statistics
    public void processtolls(){

        // number of vehicles to be processed in this event;  the number is determined by
        // the gate rate (through a random number) and the number of vehicles in the queue
        int myCount = Math.min(rand.nextInt(this.tollGateHandlingRate +1), this.myWaitingVehicles.size());


        // TODO  -- get toll from each of the vehicles to be processed



    }

    // information about processed vehicles
    public void report(){

    // TODO  -- information about processed vehicles

    }




    // TODO -- toString()
    public String toString(){
        return "???";
    }
}
