package API;


import Utils.Utils;


import org.apache.http.HttpResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.json.JSONObject;



import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;


public class Login {


    //--------------Ok--------------------------------------------------------------------
    public void PostAPI() {
        try {
            System.out.println("-------------- Post API ------------------------------------");
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost("https://jsonplaceholder.typicode.com/posts");
            String jsonInputString = "{\"title\": \"foo\", " +
                                        "\"body\": \"bar\", " +
                                        "\"userId\": 1}";
            StringEntity entity = new StringEntity(jsonInputString);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();

            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(responseEntity);

            String ReasonPhrase = response.getStatusLine().getReasonPhrase();

            //------------print--------------------------------
            System.out.println("HTTP status code: " + statusCode);
            System.out.println("ReasonPhrase: "+ReasonPhrase);
            System.out.println("response body: "+responseBody);

            JSONObject json = new JSONObject(responseBody);
            System.out.println(json.toString());
            String technology = json.getString("title");
            System.out.println(technology);
            //--



        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getAPI() {
        try {
            System.out.println("-------------- Get API ------------------------------------");
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet("https://jsonplaceholder.typicode.com/posts/1");
            httpGet.setHeader("Accept", "application/json");
            httpGet.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();

            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(responseEntity);

            String ReasonPhrase = response.getStatusLine().getReasonPhrase();

            //------------print--------------------------------
            System.out.println("HTTP status code: " + statusCode);
            System.out.println("ReasonPhrase: "+ReasonPhrase);
            System.out.println("response body: "+responseBody);

            JSONObject json = new JSONObject(responseBody);
            System.out.println(json.toString());
            String title = json.getString("title");
            System.out.println(title);
            //--

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void PutAPI() {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPut httpPut = new HttpPut("https://jsonplaceholder.typicode.com/posts/1");
            String jsonInputString = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";
            StringEntity entity = new StringEntity(jsonInputString);
            httpPut.setEntity(entity);
            httpPut.setHeader("Accept", "application/json");
            httpPut.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(httpPut);
            HttpEntity responseEntity = response.getEntity();

            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(responseEntity);

            String ReasonPhrase = response.getStatusLine().getReasonPhrase();

            //------------print--------------------------------
            System.out.println("HTTP status code: " + statusCode);
            System.out.println("ReasonPhrase: "+ReasonPhrase);
            System.out.println("response body: "+responseBody);

            JSONObject json = new JSONObject(responseBody);
            System.out.println(json.toString());
            String technology = json.getString("title");
            System.out.println(technology);
            //--
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void patchAPI() {
        try {
            System.out.println("-------------- Patch API ------------------------------------");
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPatch httpPatch = new HttpPatch("https://jsonplaceholder.typicode.com/posts/1");
            String jsonInputString = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";
            StringEntity entity = new StringEntity(jsonInputString);
            httpPatch.setEntity(entity);
            httpPatch.setHeader("Accept", "application/json");
            httpPatch.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(httpPatch);
            HttpEntity responseEntity = response.getEntity();

            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(responseEntity);

            String ReasonPhrase = response.getStatusLine().getReasonPhrase();

            //------------print--------------------------------
            System.out.println("HTTP status code: " + statusCode);
            System.out.println("ReasonPhrase: "+ReasonPhrase);
            System.out.println("response body: "+responseBody);

            JSONObject json = new JSONObject(responseBody);
            System.out.println(json.toString());
            String technology = json.getString("title");
            System.out.println(technology);
            //--
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteAPI() {
        try {
            System.out.println("-------------- Delete API ------------------------------------");
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpDelete httpDelete = new HttpDelete("https://jsonplaceholder.typicode.com/posts/1");
            httpDelete.setHeader("Accept", "application/json");
            httpDelete.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(httpDelete);
            HttpEntity responseEntity = response.getEntity();

            int statusCode = response.getStatusLine().getStatusCode();
            String ReasonPhrase = response.getStatusLine().getReasonPhrase();

            //------------print--------------------------------
            System.out.println("HTTP status code: " + statusCode);
            System.out.println("ReasonPhrase: "+ReasonPhrase);

            if (statusCode == 200) {
                String responseBody = EntityUtils.toString(responseEntity);
                System.out.println("response body: "+responseBody);

                JSONObject json = new JSONObject(responseBody);
                System.out.println(json.toString());
                String technology = json.getString("title");
                System.out.println(technology);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void LogInAPI() {

        try {
            System.out.println("-------------- Login API ------------------------------------");
            Utils u=new Utils();
            u.readJSONArrayFromSetUP(0);
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost("https://customer-test-api.herokuapp.com");
            String jsonInputString = "{\"username\":\"salman\",\n" +
                    "\"password\":\"salman1234\"}";

            StringEntity entity = new StringEntity(jsonInputString);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();

            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(responseEntity);

            String ReasonPhrase = response.getStatusLine().getReasonPhrase();

            //------------print--------------------------------
            System.out.println("HTTP status code: " + statusCode);
            System.out.println("ReasonPhrase: "+ReasonPhrase);
            System.out.println("response body: "+responseBody);

            JSONObject json = new JSONObject(responseBody);
            System.out.println(json.toString());
            String Mytoken = json.getString("token");

            Utils.updateJSONArray("token",Mytoken);



        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void fileUploadAPI() {
        try {
            File file = new File("./src/test/resources/Testfile.txt");

            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost("https://jsonplaceholder.typicode.com/posts");

            FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addPart("file", fileBody);
            builder.addTextBody("title", "foo");
            builder.addTextBody("body", "bar");
            builder.addTextBody("userId", "1");

            HttpEntity multipart = builder.build();
            httpPost.setEntity(multipart);

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();

            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(responseEntity);

            String reasonPhrase = response.getStatusLine().getReasonPhrase();

            //------------print--------------------------------
            System.out.println("HTTP status code: " + statusCode);
            System.out.println("ReasonPhrase: " + reasonPhrase);
            System.out.println("Response body: " + responseBody);

            JSONObject json = new JSONObject(responseBody);
            System.out.println(json.toString());
            String technology = json.getString("title");
            System.out.println("Title: " + technology);
            //--

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

