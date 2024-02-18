package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {


    private static RequestSpecification getRequestSpecification(String endpoint, Object payload, Map<String, String> header) {
        return RestAssured.given()
                .baseUri(endpoint)
                .contentType(ContentType.JSON)
                .headers("APIkey", "F2C03C5A-AAC8-44E1-AFE2-02EE5C7B62DB")
                .body(payload);
    }

    private static void printLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Request type is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Request Headers are " + queryableRequestSpecification.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Payload is " + queryableRequestSpecification.getBody());
    }

//    private static void printResponseInReport(Response response) {
//        ExtentReportManager.logInfoDetails("Response is " + response.getBody());
//        ExtentReportManager.logInfoDetails("Status Code is " + response.getStatusCode());
//        ExtentReportManager.logInfoDetails("Response Headers are " + response.headers().asList().toString());
//        ExtentReportManager.logInfoDetails("Content Type is " + response.getContentType());
//    }

    private static void printPassResponseInReport(Response response) {
        ExtentReportManager.logPassDetails("Response is " + response.getBody());
        ExtentReportManager.logPassDetails("Staus code is"+ response.getContentType());
        ExtentReportManager.logPassDetails("Staus code is"+ response.getHeaders());
        ExtentReportManager.logPassDetails("Staus code is"+ response.getStatusLine());

    }

    public static Response performPost(String endpoint, String payload, Map<String, String> header) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, payload, header);
        Response response = requestSpecification.post();
        printLogInReport(requestSpecification);
        printPassResponseInReport(response);
        return response;
    }

    public static Response performPost(String endpoint, Map<String, Object> payload, Map<String, String> header) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, payload, header);
        Response response = requestSpecification.post();
        printLogInReport(requestSpecification);
        printPassResponseInReport(response);
        return response;
    }
}
