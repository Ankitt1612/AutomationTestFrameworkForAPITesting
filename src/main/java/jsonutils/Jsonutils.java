package jsonutils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Jsonutils {

    public static Map<String, String> getJsonDataAsMap(String env , String fileName) throws IOException {
        String completeJsonFilePath = System.getProperty("user.dir")+ "/src/test/resources/environments/"+env+"/" + fileName;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> data  = objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<>() {});
        return data;

    }
}
