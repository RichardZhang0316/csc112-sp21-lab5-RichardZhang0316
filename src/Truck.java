/*
Richard Zhang
Lab5
April/8/2021
CSC112
 */
public class Truck extends Vehicle {

    private double Tweight;         // truck weight rating

    public Truck(String Xtag, String Xvin, double Xpprice, int Xpyear, double nTweight){
        super(Xtag, Xvin, Xpprice, Xpyear);
        Tweight=nTweight;
    }

    public Venum getType(){
        return Venum.truck;
    }

    // Truck tax is a $50.75 fee + basic vehicle tax
    public double getTax(){
        double totalTax=super.getTax()+50.75;
        if(Tweight>2){
            totalTax+=100*Tweight;
        }
        return totalTax;
    }

    public double getWeight(){
        return Tweight;
    }

    public String toString(){
        return (super.toString()+"\ntruck weight rating"+Tweight);
    }
}
