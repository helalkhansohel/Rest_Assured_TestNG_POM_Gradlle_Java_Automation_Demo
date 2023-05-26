package Utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    WebDriver driver;
//    public Utils(WebDriver driver)
//    {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
    public String email;
    public String password;
    public String token;
    public String baseURL;

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void readJSONFile() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject jsonObject = (JSONObject) obj;

        setEmail((String) jsonObject.get("email"));
        setPassword((String) jsonObject.get("password"));
    }
    public void readJSONArray(int pos) throws IOException, ParseException, ParseException {

        String fileName = "./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject jsonObject = (JSONObject) jsonArray.get(pos);

        setEmail((String) jsonObject.get("email"));
        setPassword((String) jsonObject.get("password"));

    }

    public static void updateJSONArray(String key, String value) {
        try{
            String fileName="./src/test/resources/SetUp.json";


            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONArray jsonArray = (JSONArray) obj;
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            jsonObject.put(key, value);
            FileWriter file = new FileWriter(fileName);
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Updated!");
            System.out.print(jsonArray);
        }
        catch (Exception e){

        }
    }

    public void readJSONArrayFromSetUP(int pos) throws IOException, ParseException, ParseException {

        String fileName = "./src/test/resources/SetUp.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject jsonObject = (JSONObject) jsonArray.get(pos);

        setBaseURL((String) jsonObject.get("baseURL"));
        setToken((String) jsonObject.get("token"));

    }
}
