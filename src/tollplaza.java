// Class for a single toll plaza, which consists of a number of tollgates
//
// April 2021

import java.util.ArrayList;
import java.util.Random;


public class tollplaza {

    private String PlazaName;               // name of plaza
    private Random rand;                    // for random numbers
    private ArrayList<tollgate> tollbooths;       // various toll gates at this plaza

    // ******************

    // TODO -- Enter comments to explain what this constructor does
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
    public void driveup(Vehicle V) {
        int position = rand.nextInt(this.tollbooths.size());
        this.tollbooths.get(position).queueup(V);
    }

    // ******************

    // TODO -- Enter comments to explain what this code does
    public void processtolls(){
        for(tollgate mybooth : this.tollbooths){
            mybooth.processtolls();
        }
    }

    // ******************

    // information about the individual toll gates
    public void status(String tag){
        // TODO -- what is appropriate here
        }


    // ******************

    // more comprehensive information about the tollplaza
    public void report(){
       // TODO -- what should you report

    }

    // TODO -- toString()
    public String toString(){ return "???";}
}
