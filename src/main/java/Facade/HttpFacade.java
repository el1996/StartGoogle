package Facade;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpFacade {
    HttpClient httpclient = HttpClients.createDefault();
    //ApacheHttp apacheHttp =
    ApacheHttp get(String path) throws IOException {

        String responseBody = null;
        HttpGet httpget = new HttpGet(path);
        HttpResponse response = httpclient.execute(httpget);
        System.out.println("Executing GET request...");
        return new ApacheHttp(new BasicResponseHandler().handleResponse(response), response.getStatusLine().getStatusCode());
    }

    ApacheHttp post(String path) throws IOException {

        HttpPost httpPost = new HttpPost(path);
        HttpResponse response = httpclient.execute(httpPost);
        System.out.println("Executing POST request...");
        StringBuilder json = new StringBuilder();
        json.append("{\n" + "  \"name\": \"morpheus\",\n" + "  \"job\": \"leader\"\n" + "}");
        httpPost.setEntity(new StringEntity(json.toString()));
        return new ApacheHttp(EntityUtils.toString(response.getEntity()),response.getStatusLine().getStatusCode());
    }
    ApacheHttp put(String path) throws IOException {
        HttpPut httpPut = new HttpPut(path);
        HttpResponse response = httpclient.execute(httpPut);
        httpPut.setEntity(new StringEntity("{\n" + "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" + "}"));
        System.out.println("Executing PUT request...");
        return new ApacheHttp(new BasicResponseHandler().handleResponse(response),response.getStatusLine().getStatusCode());
    }

    ApacheHttp  patch(String path) throws IOException {

        HttpPatch httpPatch = new HttpPatch(path);
        HttpResponse response = httpclient.execute(httpPatch);
        httpPatch.setEntity(new StringEntity("{\n" +
                "    \"name\": \"morpheus\",\n" + "    \"job\": \"zion resident\"\n" + "}"));
        System.out.println("Executing PATCH request...");
        return new ApacheHttp(new BasicResponseHandler().handleResponse(response),response.getStatusLine().getStatusCode());
    }

    ApacheHttp delete(String path) throws IOException {

        HttpDelete httpDelete = new HttpDelete(path);
        HttpResponse response = httpclient.execute(httpDelete);
        System.out.println("Executing DELETE request...");
        return new ApacheHttp(new BasicResponseHandler().handleResponse(response),response.getStatusLine().getStatusCode());
    }

}

