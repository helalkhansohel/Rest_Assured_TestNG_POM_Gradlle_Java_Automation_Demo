package TestRunner;

import API.DataFileUp;
import API.Login;

import org.apache.commons.configuration.ConfigurationException;

import org.testng.annotations.Test;

import java.io.IOException;
import Utils.Utils;

public class LoginTestRunner {



    @Test(priority = 1,description = "PostAPITest")
    public void PostAPITest() throws IOException, ConfigurationException {
        Login l=new Login();

        l.PostAPI();
        Utils.updateJSONArray("token","testvallue");
    }
    @Test(priority = 2,description = "GetAPITest")
    public void GetAPITest() throws IOException, ConfigurationException {
        Login l=new Login();

        l.getAPI();
    }

    @Test(priority = 3,description = "PutAPITest")
    public void PutAPITest() throws IOException, ConfigurationException {
        Login l=new Login();

        l.PutAPI();
    }

    @Test(priority = 4,description = "PatchAPITest")
    public void PatchAPITest() throws IOException, ConfigurationException {
        Login l=new Login();

        l.patchAPI();
    }

    @Test(priority = 5,description = "DeleteAPITest")
    public void DeleteAPITest() throws IOException, ConfigurationException {
        Login l=new Login();

        l.deleteAPI();
    }


    @Test(priority = 6,description = "LoginTest")
    public void LogInAPITest() throws IOException, ConfigurationException {
        Login l=new Login();

        l.LogInAPI();
    }
    @Test(priority = 7,description = "File upload")
    public void FileUploadTest() throws IOException, ConfigurationException {
        Login l=new Login();

        l.fileUploadAPI();
    }


}
