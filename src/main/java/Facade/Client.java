package Facade;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            HttpFacade httpFacade = new HttpFacade();
            ApacheHttp http = httpFacade.get("https://reqres.in/api/users/2");
            System.out.println("Response: " + http.response);
            System.out.println("Status: " + http.status);

            http = httpFacade.post("https://reqres.in/api/users");
            System.out.println("Response: " + http.response);
            System.out.println("Status: " + http.status);

            http = httpFacade.put("https://reqres.in/api/users/2");
            System.out.println("Response: " + http.response);
            System.out.println("Status: " + http.status);

            http = httpFacade.patch("https://reqres.in/api/users/2");
            System.out.println("Response: " + http.response);
            System.out.println("Status: " + http.status);

            http = httpFacade.delete("https://reqres.in/api/users/2");
            System.out.println("Response: " + http.response);
            System.out.println("Status: " + http.status);

        }catch (IOException ioException){
            ioException.getMessage();
        }
    }
}


