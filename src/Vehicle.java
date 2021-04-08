/*
Richard Zhang
Lab5
April/8/2021
CSC112
 */
import java.util.Calendar;

public class Vehicle {

    public static enum Venum  {car, truck, vehicle};
    private static int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);

    private String Vtag;            // tag number
    private String Vvin;            // vehicle identification number
    private double Vpurchaseprice;  // vehicle purchase price
    private int  Vpurchaseyear;     // vehicle purchase year



    // Vehicle constructor
    public Vehicle(String Xtag, String Xvin, double Xpprice, int Xpyear){
        Vtag=Xtag;
        Vvin=Xvin;
        Vpurchaseprice=Xpprice;
        Vpurchaseyear=Xpyear;
    }


    // get tag
    public String getTag(){
        return this.Vtag;
    }

    // get type of vehicle
    public Venum getType(){
        return Venum.vehicle;
    }

    // basic vehicle tax based on purchase price, depreciated over 10 years
    public double getTax(){
        if(CurrentYear-Vpurchaseyear<10) {
            return (0.055 * (Vpurchaseprice) * (1 - 0.1 * (CurrentYear - Vpurchaseyear)));
        }
        else{
            return 0.0;
        }
    }

    // overrides Object method
    public String toString(){
        return "tag number:"+Vtag+"\nvehicle identification number: "+Vvin+"\nvehicle purchase price"+Vpurchaseprice+"\nvehicle purchase year"+Vpurchaseyear ;}
}
