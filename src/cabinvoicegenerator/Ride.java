package cabinvoicegenerator;

public class Ride 
{

   
    public final double distance;
    public final int time;
    public final CabRide cabRide;

    public Ride(CabRide ride,double distance, int time) 
    {
        this.cabRide=ride;
        this.distance = distance;
        this.time = time;
    }
}
