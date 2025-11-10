package utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class jsonDataReader {
    public static String getJsonData(String key) throws IOException, ParseException {
        return (String) getJsonData().get(key);//input is the key
    }

    public static JSONObject getJsonData() {
        File f = new File("resources/testData/testData.json");
        JSONObject jObj = null;
        try {
            // Read file content into string
            String fs = FileUtils.readFileToString(f, "UTF-8");

            // Parse string into JSONObject
            Object obj = new JSONParser().parse(fs);
            jObj = (JSONObject) obj;

        } catch (IOException | ParseException e) {
            throw new RuntimeException("Error reading JSON file: " + f.getPath(), e);
        }

        return jObj;
    }
}
