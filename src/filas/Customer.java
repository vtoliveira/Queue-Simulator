/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filas;

/**
 *
 * @author victor
 */
public class Customer {
    double tolerance;
    static int count = 0;
    int id;
    
    public Customer(double tolerance){
        count++;
        this.id = count;
        this.tolerance = tolerance;
    }
}
