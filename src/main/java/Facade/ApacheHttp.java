package Facade;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ApacheHttp {

    String response;
    int status;

    public ApacheHttp(String response, int status) {
        this.response = response;
        this.status = status;
    }
}

