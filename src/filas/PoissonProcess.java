/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filas;

import java.io.IOException;
import java.util.Random;
import java.lang.Math;

public class PoissonProcess {
    private double lambda; // my rate for a Poisson distribution. It is assumed to be a unit/time rate.
    
    //int state; // probability of (state) number of itens/customer in a given state
    
    public PoissonProcess(double lamb){
        this.setLambda(lamb);
    }
    
    private double getLambda(double lamb) throws IOException{
        if (0 <= lamb){
            return lamb;
        }else{
            throw new IOException("Invalid value for lambda variable.");
        }
    }
    
    private void setLambda(double lamb){
        try{
            this.lambda = getLambda(lamb);
        }catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
    
    public int getPoissonState(){
        Random r = new Random();
        double L = Math.exp(-this.lambda);
        int state = 0;
        double p = 1.0;
        
        do {
            p = p * r.nextDouble();
            state++;
        } while (p > L);
        return (state-1);
    }
    
    public void printVariables(){ 
        System.out.printf("%.2f\n", this.lambda);
    }

    
}
