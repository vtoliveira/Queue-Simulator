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
public class Simulation {
    Queue queue;
    
    public Simulation(Queue queue){
        this.queue = queue;
    }
    
    public void simulateByIteration(double it) throws InterruptedException{
        int i = 0;
        do {
            int added = queue.putCustomerQueue();
            //System.out.printf("Added %d customers to the queue in iteration %d\n", added, i);
            
            int taken = queue.takeCustomerQueue();
            //System.out.printf("Removed %d customer to the queue in iteration %d\n", taken, i);
            i++;
            System.out.printf("There are %d customer in queue in iteration %d\n", queue.numberOfCustomerInQueue(), i);
        } while(i < it || queue.numberOfCustomerInQueue() > 0);
    }
    
}
