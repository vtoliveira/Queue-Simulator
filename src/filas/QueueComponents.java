package filas;


public abstract class QueueComponents {
    double rate;
    PoissonProcess s;
    
    protected QueueComponents(double r){
        this.rate = r;
        this.s = new PoissonProcess(this.rate);
    }
    
    protected int getNumberOfCustomers(){
        return s.getPoissonState();
    }
}
