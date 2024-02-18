package usps;

import java.util.*;

public class Payloads {

    public static String getPayloadAsString(String carrier, String trackingNumber){
        return "{\n" +
                "                            \"trackings\": [\n" +
                "                                {\n" +
                "                                    \"carrierCode\": \""+carrier+"\",\n" +
                "                                        \"trackingNumbers\": [\n" +
                "                                         \""+trackingNumber+"\"\n" +
                "                                    ]\n" +
                "                                }\n" +
                "                            ]\n" +
                "                        }";
    }

    public static Map<String, Object> getPayloadAsMap(String carrier, List<String> trackingNumber){
        Map<String, Object> payload = new HashMap<>();
        //creating the inner tracking object
        Map<String, Object> trackingObject = new HashMap<>();
        trackingObject.put("carrierCode", carrier);
        trackingObject.put("trackingNumbers", trackingNumber);
        // creating the object for trackings
        List<Map<String, Object>> trackings = new ArrayList<>();
        trackings.add(trackingObject);
        payload.put("trackings", trackings);
        return payload;


    }
}

