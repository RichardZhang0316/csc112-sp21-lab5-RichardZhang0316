/*
Richard Zhang
Lab5
April/8/2021
CSC112
 */
// Car class which inherits (extends) the Vehicle class
// Cars have additional information:
//      model name
//      window tint
//      number of doors

public class Car extends Vehicle {

    private String CmodelName;      // vehicle model
    private boolean Cwindowtint;    // tinted windows
    private int Cnumdoors;          // number of doors


    // Car constructor
    public Car(String Xtag, String Xvin, double Xpprice, int Xpyear, String XmodelName,
               boolean Xwt, int Xnd){
        super(Xtag, Xvin, Xpprice, Xpyear);
        CmodelName=XmodelName;
        Cwindowtint=Xwt;
        Cnumdoors=Xnd;
    }

    // overrides Vehicle method
    public Venum getType(){
        return Venum.car;
    }

    public boolean hasTintedWindow(){
        return Cwindowtint;
    }

    // overrides Vehicle method
    public double getTax(){
        double totalTax=super.getTax()+17.45;
        if(Cwindowtint){
            totalTax+=15;
        }
        if(Cnumdoors>2){
            totalTax+=Cnumdoors*4.73;
        }
        return totalTax;
    }

    // overrides Vehicle method
    public String toString(){
        return (super.toString()+"\nmodel name: "+CmodelName+"\nHas tinted windows? "+Cwindowtint+"\nThe number of doors: "+Cnumdoors);
    }
}
