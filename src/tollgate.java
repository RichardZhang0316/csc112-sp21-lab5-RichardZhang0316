// Class for a single tollgate
//
// April 2021
//
// Each tollgate has a queue of vehicles associated with it, a gate rate (the number of
// vehicles that can be processed in an event, and various members for collecting statistics
// about car, truck, and vehicle
/*
Richard Zhang
Lab5
April/8/2021
CSC112
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class tollgate {

    private Queue<Vehicle> myWaitingVehicles;     //  (interface) queue of cars for this booth
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
    /*
    The following method simulates the situation when a vehicle (including car and truck) is assigned to a random toll
    gate. After one vehicle is assigned to a toll gate, it will be put at the end (tail) of all the vehicles that need
    to pass this toll gate because this car arrives more lately than other vehicles. In other words, this method simulates
    all the vehicles in one toll gate queue up to pay their tolls.
    * */
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


        // TODO  -- get toll from each of the vehicles to be processed for loop
        for(int i=0; i<myCount;i++){
            Vehicle V=myWaitingVehicles.remove();
            //if this vehicle is a truck, add 1 to the paidTruck and calculate its toll
                if (V.getType() == Vehicle.Venum.truck) {
                    PaidTrucks++;

                    //transform it to the Truck type
                    Truck realV=(Truck) V;
                    //calculate the toll this truck needs to pay
                    TruckTollTotal+=0.35+0.2*realV.getWeight();
                    //if this vehicle is a car, add 1 to the paidCar and calculate its toll
                } else if (V.getType() == Vehicle.Venum.car) {
                    PaidCars++;
                    //transform it to the Car type
                    Car realV=(Car) V;
                    //calculate the toll this car needs to pay
                    if(realV.hasTintedWindow()){
                        CarTollTotal=0.35+0.25+0.15;
                    }
                    else{
                        CarTollTotal=0.35+0.25;
                    }
                    //if this vehicle is a vehicle, add 1 to the paidVehicle and calculate its toll
                } else if (V.getType() == Vehicle.Venum.vehicle) {
                    PaidVehicles++;
                    //calculate the toll this vehicle needs to pay
                    VehicleTollTotal+=0.35;
                }


            }

        }

    // information about processed vehicles
    public void report(){

    // TODO  -- information about processed vehicles
        int totalVehicles=NumVehicles+NumTrucks+NumCars;
        int totalPaidVehicles=PaidVehicles+PaidTrucks+PaidCars;
        double totalTolls=CarTollTotal+VehicleTollTotal+TruckTollTotal;
        System.out.println("Toll processing rate per event: "+tollGateHandlingRate);
        System.out.printf("Number of cars:     %6d Number of paid cars:     %6d Car tolls collected:     %10.2f%n",NumCars,PaidCars,CarTollTotal);
        System.out.printf("Number of trucks:   %6d Number of paid trucks:   %6d Truck tolls collected:   %10.2f%n",NumTrucks,PaidTrucks,TruckTollTotal);
        System.out.printf("Number of vehicles: %6d Number of paid vehicles: %6d Vehicle tolls collected: %10.2f%n",NumVehicles,PaidVehicles,VehicleTollTotal);
        System.out.printf("Total number:       %6d Total paid:              %6d Total tolls collected:   %10.2f%n",totalVehicles,totalPaidVehicles,totalTolls);
    }




    // TODO -- toString()
    public String toString(){
        int totalVehicles=NumVehicles+NumTrucks+NumCars;
        int totalPaidVehicles=PaidVehicles+PaidTrucks+PaidCars;
        double totalTolls=CarTollTotal+VehicleTollTotal+TruckTollTotal;
        return ("average number of cars per 5 minutes: "+tollGateHandlingRate+"\nTotal number: "+totalPaidVehicles+"\nTotal paid: "+totalPaidVehicles+"\nTotal tolls collected: "+totalTolls);
    }

    public int getTotalCars(){
        return NumCars;
    }
    public int getTotalTrucks(){
        return NumTrucks;
    }
    public int getTotalVehicles(){
        return NumVehicles;
    }
    public int getPaidCars(){
        return PaidCars;
    }
    public int getPaidTrucks(){
        return PaidTrucks;
    }
    public int getPaidVehicles(){
        return PaidVehicles;
    }
    public double getCarsTolls(){
        return CarTollTotal;
    }
    public double getTrucksTolls(){
        return TruckTollTotal;
    }
    public double getVehiclesTolls(){
        return VehicleTollTotal;
    }
}
