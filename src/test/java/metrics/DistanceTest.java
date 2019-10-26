package metrics;


import org.junit.Assert;
import org.junit.Test;

class DistanceTest {
    private final static double latOne = 5;
    private final static double longOne = 5;
    private final static double latTwo = 10;
    private final static double longTwo = 10;

    @Test
    void calculateCrowFlight(){
        double expected = 782999.6273175813;
        Assert.assertEquals(Distance.calculateCrowFlight(latOne, longOne, latTwo, longTwo), expected, 0);
    }

    @Test
    void calculateOSMRapi(){
        double expected = 1112097.1;
        Assert.assertEquals(Distance.calculateOSMRapi(latOne, longOne, latTwo, longTwo), expected, 0);
    }
}
