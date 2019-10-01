package thread.banktellsimulation;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public class TellerManager implements Runnable {
    private ExecutorService exec;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> telersDoingOtherThings = new LinkedList<>();
    private int adjustmentPeriod;
    private static Random random = new Random(47);

    public TellerManager(ExecutorService exec, CustomerLine customers, int adjustmentPeriod) {
        this.exec = exec;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;
        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }
    public void adjustTellerNumber(){
        if (customers.size()/workingTellers.size()>2){
            if (telersDoingOtherThings.size()>0){
                Teller teller = telersDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
            }
        }
    }

    @Override
    public void run() {

    }
}
