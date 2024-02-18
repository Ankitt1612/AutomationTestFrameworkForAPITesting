package uspstests;

import io.restassured.response.Response;
import jsonutils.Jsonutils;
import utils.RestUtils;

import java.io.IOException;
import java.util.Map;

public class USPSApIs {

    public static Response  trackShipments(String env, Map<String, Object> trackUSPSShipmentTrackingPayload) throws IOException {
       env = (env==null) ? "qa" : env;

       Map<String, String> data = Jsonutils.getJsonDataAsMap(env, "endpoints.json");
       String qaEndPoint =  data.get("endpoint");
       // Response result = RestUtils.performPost(endpoint.get("QA"), payload, null);
      return  RestUtils.performPost(qaEndPoint , trackUSPSShipmentTrackingPayload, null);

    }
}
