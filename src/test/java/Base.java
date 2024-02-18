import jsonutils.Jsonutils;
import usps.Payloads;

import java.io.IOException;
import java.util.Map;

public class Base {
   public static Map<String, String> endpoint = null;

    static {

        try {
            endpoint = Jsonutils.getJsonDataAsMap("env", "endpoints.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String payload = Payloads.getPayloadAsString("USPS", "9205590345875002129231");


    }

}
