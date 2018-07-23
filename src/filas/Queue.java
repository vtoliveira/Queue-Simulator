/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filas;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Queue {
    public BlockingQueue<Customer> queue;
    Source source;
    Server server;
    int capacity;
    int numberOfServers;
    Random rnd = new Random();
    
    public Queue(Source so, Server sv, int cap, int numServers){
        this.source = so;
        this.server = sv;
        this.setCapacity(cap);
        this.numberOfServers = numServers;
        this.createQueue();
    }
    
    private int getCapacity(int cap) throws IOException{
        if (cap >= 1){
            return cap;
        }else{
            throw new IOException("Capacity must be have a value greater than one");
        }
    }
    
    private void setCapacity(int cap){
        try{
            this.capacity = getCapacity(cap);
        } catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
    
    private int numberOfArrivingCustomers(){
        return this.source.getNumberOfCustomers();
    }
    
    private int numberOfLeavingCustomers(){
        return this.server.getNumberOfCustomers();
    }
    
    
    private void createQueue(){
        queue = new ArrayBlockingQueue<>(this.capacity);
    }
    
    public int numberOfCustomerInQueue(){
        return queue.size();
    }
    public int putCustomerQueue() throws InterruptedException{
        int number = this.numberOfArrivingCustomers();
        int i = 0;
        while( i < number && queue.size() != this.capacity){
            Customer c = new Customer(rnd.nextDouble());
            this.queue.put(c);
            i++;
        }
        
        return number;
    }
    
    public int takeCustomerQueue() throws InterruptedException{
        int number = this.numberOfLeavingCustomers();
        int i = 0;
        while (i < number && queue.size() > 0){
            Customer customer = this.queue.take();
            //System.out.println(customer.tolerance);
            i++;
        }
        
        return i;
    }
}
