package tests.apiTest;

import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class simpleHttpClientTest {

    @Test
    public void siteAvailability() throws IOException {
        String restUrl = "https://reqres.in";

        HttpUriRequest request = new HttpGet(restUrl);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

   @Test
    public void checkSingleUserTest() throws IOException {
        String restUrl = "https://reqres.in/api/users/2";

        String expectedResult = "{\"data\":{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\"," +
                "\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"},\"support\":{\"url\":" +
                "\"https://reqres.in/#support-heading\"," +
                "\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";

        HttpUriRequest request = new HttpGet(restUrl);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        String actualResult = EntityUtils.toString(httpResponse.getEntity());

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

}
