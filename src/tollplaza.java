// Class for a single toll plaza, which consists of a number of tollgates
/*
Richard Zhang
Lab5
April/8/2021
CSC112
 */

import java.util.ArrayList;
import java.util.Random;


public class tollplaza {

    private String PlazaName;               // name of plaza
    private Random rand;                    // for random numbers
    private ArrayList<tollgate> tollbooths;       // various toll gates at this plaza

    // ******************

    // TODO -- Enter comments to explain what this constructor does
    /*
    The following method simulates the creation (or construction) of a toll plaza, which contain several toll gates. This
    toll plaza also has its name. In most cases, toll plazas contain more than one toll gate, but it's rare to see a toll
    plaza with more than 15 toll gates. Besides, this toll plaza also has toll gates with different average rate of operation.
    The average rates of operation of these toll gates vary based on their efficiencies, ranging from 3 to 13.
    * */
    public tollplaza(int N, String PName){
        assert(N>1): "must have at least one toll booth";
        assert(N<15): "are you sure this is the NJ freeway?";
        this.PlazaName = PName;
        rand = new Random();


        this.tollbooths = new ArrayList<tollgate>();
        for(int i=0; i<N; i++){


            this.tollbooths.add(new tollgate(3+rand.nextInt(10)));
        }

    }

    // ******************

    // getter for the number of gates
    public int getnumberGates(){
        return this.tollbooths.size();
    }

    // ******************

    // TODO  -- Enter comments to explain what this code does
    /*
    The following method simulates assigning one car to a toll gate randomly. When there is a vehicle, this method puts
    it in a random toll gate. Then, this vehicle will be put at the end (tail) of the traffic stream that need to pass
    this specific toll gate. After that, more operations will be executed, but this method doesn't include them.
    * */
    public void driveup(Vehicle V) {
        int position = rand.nextInt(this.tollbooths.size());
        this.tollbooths.get(position).queueup(V);
    }

    // ******************

    // TODO -- Enter comments to explain what this code does
    /*
    The following method simulates how much money all the toll gates in the toll plaza collect. It first goes to the first
    gate and collect all the tolls it gets. Then, it goes to the second toll gate and do the same thing. It will continue
    do the same thing too the last toll gate.
    * */
    public void processtolls(){
        for(tollgate mybooth : this.tollbooths){
            mybooth.processtolls();
        }
    }

    // ******************

    // information about the individual toll gates
    //I don't use it, so I leave it blank.
    public void status(String tag){
        // TODO -- what is appropriate here

        }


    // ******************

    // more comprehensive information about the tollplaza
    public void report(){
       // TODO -- what should you report
        int NumCars=0;
        int PaidCars=0;
        double CarTollTotal=0.00;
        int NumTrucks=0;
        int PaidTrucks=0;
        double TruckTollTotal=0.00;
        int NumVehicles=0;
        int PaidVehicles=0;
        double VehicleTollTotal=0.00;
        String blank=" ";
        for (int i=0; i < tollbooths.size(); i++){
            System.out.println(blank.repeat(30)+"****** Report for toll lane #"+ i +" ******");
            tollbooths.get(i).report();
            System.out.println("");
            NumCars+=tollbooths.get(i).getTotalCars();
            PaidCars+=tollbooths.get(i).getPaidCars();
            CarTollTotal+=tollbooths.get(i).getCarsTolls();
            NumTrucks+=tollbooths.get(i).getTotalTrucks();
            PaidTrucks+=tollbooths.get(i).getPaidTrucks();
            TruckTollTotal+=tollbooths.get(i).getTrucksTolls();
            NumVehicles+=tollbooths.get(i).getTotalVehicles();
            PaidVehicles+=tollbooths.get(i).getPaidVehicles();
            VehicleTollTotal+=tollbooths.get(i).getVehiclesTolls();
        }
        int TotalNum=NumCars+NumTrucks+NumVehicles;
        int TotalPaidNum=PaidCars+PaidTrucks+PaidVehicles;
        double TotalTolls=CarTollTotal+TruckTollTotal+VehicleTollTotal;
        System.out.println(blank.repeat(40)+"****** SUMMARY ******\n");
        System.out.println("Summary information for "+PlazaName+" toll plaza:");
        System.out.printf("Number of cars:     %6d Number of paid cars:     %6d Car tolls collected:     %10.2f%n",NumCars,PaidCars,CarTollTotal);
        System.out.printf("Number of Trucks:   %6d Number of paid Trucks:   %6d Truck tolls collected:   %10.2f%n",NumTrucks,PaidTrucks,TruckTollTotal);
        System.out.printf("Number of Vehicles: %6d Number of paid Vehicles: %6d Vehicle tolls collected: %10.2f%n",NumVehicles,PaidVehicles,VehicleTollTotal);
        System.out.println("                     =====                           =====                          ==========");
        System.out.printf("Total Number:       %,6d Total Paid:              %,6d Total Tolls Collected:   %,10.2f%n",TotalNum,TotalPaidNum,TotalTolls);


    }

    // TODO -- toString()
    public String toString(){
        return ("Welcome to the "+PlazaName+" toll booth!");
    }
}
