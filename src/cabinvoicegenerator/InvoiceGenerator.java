package cabinvoicegenerator;

public class InvoiceGenerator 
{
    
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;

    public static void main(String[] args) 
    {
        System.out.println("Welcome to cab invoice generator");
    }

    RideRepository rideRepository = new RideRepository();

    public void setRideRepository(RideRepository rideRepository)
    {
        this.rideRepository = rideRepository;
    }

    public double calculateFare(double distance,int time) 
    {
        double totalFare= distance*MINIMUM_COST_PER_KILOMETER+time*COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary getTotalFare(Ride[] rides) 
    {
        double totalFare = 0;
        for(Ride ride:rides)
            totalFare += ride.cabRide.calculateCostOfRide(ride);
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) 
    {
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) 
    {
        return this.getTotalFare(rideRepository.getRide(userId));
    }
}