package com.example.specgenerator;

import com.example.specgenerator.json.Customer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpecGeneratorApplication implements CommandLineRunner {
    private static FileWriter file;

    public static void main(String[] args) {
        SpringApplication.run(SpecGeneratorApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
/*        // De-serialize - Read json file and print it as Java object
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.readValue(new File("src/main/resources/customer.json"), Customer.class);
        System.out.println(customer);

        // Serialize Convert java object into json file and save it in directory
        customer.setName("Ajay Bongane");
        customer.setEmail(null);
        //customer.setAddress(null);
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true); // configure object mapper for pretty print
        objectMapper.writeValue(new File("src/main/resources/customer-out.json"),customer);

        // De-serialize json into Tree Model
        JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/customer.json"));
        // read nodes
        System.out.println("Customer Name: " + rootNode.path("name").asText());
        System.out.println("Customer Phone: " + rootNode.path("phone").asText());
        System.out.println("Customer City: " + rootNode.path("address").path("city").asText());
        System.out.println("Customer Project: " + rootNode.path("projects").get(0).asText());
        System.out.println("Customer Project: " + rootNode.path("genders").asText());

        // access specific node using json pointer
        JsonNode nodeToTest = rootNode.at("/address/city");*/

        // main logic start here
        int fileNumber = 1;
        Map<String, String> testDataMap = getMapFromCsv("src/main/resources/test-data.csv");
        Iterator<String> iterator = testDataMap.keySet().iterator();
        while(iterator.hasNext()){
            String jsonPath = iterator.next();
            String valueToBeSet = testDataMap.get(jsonPath);
            updateJson(jsonPath, valueToBeSet, fileNumber);
            System.out.println("File " + fileNumber + " generated");
            fileNumber++;
        }
    }

    public void updateJson(String jsonPath, String value, int fileNumber) throws IOException {
        // update the json field using json path
        DocumentContext context = JsonPath.parse(new File("src/main/resources/customer.json"));
        context.set(jsonPath, value); //context.set("$.name", "Sanju Sawant");
        System.out.println("Original json updated: " + context.json());

        // write updated json into the file
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File("src/main/resources/customer" + fileNumber + ".json"), context.json());
        System.out.println("Json file generated successfully.");
    }

    public Map<String, String> getMapFromCsv(final String filepath) throws IOException{
        Stream<String> lines = Files.lines(Paths.get(filepath));

        Map<String, String> resultMap = lines.map(line -> line.split(","))
                .collect(Collectors.toMap(line -> line[0], line -> line [1]));

        lines.close();
        return resultMap;
    }

}
