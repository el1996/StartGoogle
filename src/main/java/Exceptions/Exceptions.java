package Exceptions;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Exceptions {

    static Map<?,?> dataMap;
    static void readFromJsonFile() throws IOException {
        // create Gson instance
        Gson gson = new Gson();

        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get("src/main/java/Exceptions/config.json"));

        // convert JSON file to map
        dataMap = gson.fromJson(reader, Map.class);

       //  print map entries
//        for (Map.Entry<?, ?> entry : dataMap.entrySet()) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }

        // close reader
        reader.close();
    }

    static void  createFile() throws IOException {
        File targetFile = new File("src/main/java/Exceptions/config.json");
        targetFile.createNewFile();
    }

    static void writeToJsonFile() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "John Deo");
        map.put("email", "john.doe@example.com");
        map.put("roles", new String[]{"Member", "Admin"});
        map.put("admin", true);

        // create a writer
        Writer writer = new FileWriter("src/main/java/Exceptions/config.json");
        // convert map to JSON File
        new Gson().toJson(map, writer);

        // close the writer
        writer.close();
    }

    static void requestConfigKey(String key) {

        if(!dataMap.containsKey(key)) {
            throw new IllegalArgumentException ("Key doesn't exist - " + key);
        }
        System.out.println("Key exists - " + key);
    }

    static void run(String key) throws IOException {

        try {
            readFromJsonFile();
            requestConfigKey(key);

        } catch (NoSuchFileException noSuchFileException) {
            System.out.println("No such file exception.");
            try {
                createFile();
                readFromJsonFile();
                readFromJsonFile();
                requestConfigKey(key);

            } catch (NullPointerException nullPointerException) {
                System.out.println("Try to get config data when not initialized.");
                writeToJsonFile();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {

        // First - no File + no data
        System.out.println("1");
        run("address");

        // Second - key doesn't exist
        System.out.println("2");
        run("address");

        // Third - key exists
        System.out.println("3");
        run("name");
    }
}
