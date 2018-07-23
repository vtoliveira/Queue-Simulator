package filas;

/**
 *
 * @author victor
 */
public class queue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        /* PoissonProcess p = new PoissonProcess(1);
        p.printVariables();
        System.out.println(p.getPoissonState());*/
        
        Source so = new Source(3);
        //System.out.println(so.getNumberOfCustomers());
        
        Server sv = new Server(2);
        //System.out.println(sv.getNumberOfCustomers());
        
        Queue q = new Queue(so, sv, 10000, 1);
        
        Simulation s = new Simulation(q);
        
        s.simulateByIteration(10);
    }
    
}
