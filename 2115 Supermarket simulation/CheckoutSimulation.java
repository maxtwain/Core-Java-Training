import java.math.BigInteger;
import java.security.SecureRandom;

class CheckoutSimulation {
    private int arrivalMin;
    private int arrivalMax;
    private int serviceMin;
    private int serviceMax;
    private int durationMinutes;
    private int currentTime;
    private BigInteger lineSize;
    private BigInteger lineMax;
    private BigInteger maxWait;

    CheckoutSimulation(int arrivalMin, int arrivalMax, int serviceMin, int serviceMax, int durationMinutes){
        this.arrivalMin = arrivalMin;
        this.arrivalMax = arrivalMax;
        this.serviceMin = serviceMin;
        this.serviceMax = serviceMax;
        this.durationMinutes = durationMinutes;

        currentTime = 0;
        lineSize = BigInteger.ZERO;
        lineMax = lineSize;
        maxWait = BigInteger.ZERO;

        runSim();
    }

    private void runSim(){
        NQueue serviceLine = new NQueue();

        int nextArrival = new SecureRandom().nextInt(arrivalMax + 1 - arrivalMin) + arrivalMin;
        int serviceComplete = new SecureRandom().nextInt(serviceMax + 1 - serviceMin) + serviceMin + nextArrival;

        while(currentTime < durationMinutes){
            if(currentTime == nextArrival){
                serviceLine.insertNode();
                lineSize = lineSize.add(BigInteger.ONE);

                if(lineSize.compareTo(lineMax) > 0){
                    lineMax = lineSize;
                }

                nextArrival = new SecureRandom().nextInt(arrivalMax + 1 - arrivalMin) + arrivalMin + currentTime;
            }

            if(currentTime == serviceComplete){
                BigInteger nodeWaitTime = serviceLine.removeNodeGetTime();

                if(nodeWaitTime.compareTo(maxWait) > 0){
                    maxWait = nodeWaitTime;
                }

                lineSize = lineSize.subtract(BigInteger.ONE);

                if(serviceLine.isEmpty()){
                    serviceComplete = new SecureRandom().nextInt(serviceMax + 1 - serviceMin) + serviceMin + nextArrival;
                } else{
                    serviceComplete = new SecureRandom().nextInt(serviceMax + 1 - serviceMin) + serviceMin + currentTime;
                }
            }

            if(!serviceLine.isEmpty()){
                serviceLine.incrementQueue();
            }
            ++currentTime;
        }
    }

    void printResult(){
        System.out.printf("Arrival range: %d to %d minutes.%n" +
                "Service range: %d to %d minutes.%n" +
                "Simulation duration: %d minutes.%n" +
                "Max line size: %s customers.%n" +
                "Max customer wait time: %s minutes.%n",
                arrivalMin, arrivalMax,
                serviceMin, serviceMax,
                durationMinutes,
                lineSize.toString(),
                maxWait.toString());
    }
}
