package uspstests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import usps.Payloads;

import java.io.IOException;
import java.util.Arrays;

public class VerifyStatusCodeTest extends USPSApIs {

    @Test
    public void verifyStatusCode() throws IOException {
       Response result =  USPSApIs.trackShipments("qa", Payloads.getPayloadAsMap("USPS", Arrays.asList("9205590345875002129231")));
        Assert.assertEquals(result.statusCode(), 200, "Status code mismatch");
    }
}
