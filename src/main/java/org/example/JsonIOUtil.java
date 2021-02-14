package org.example;

//import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.model.Car;
import org.example.model.Owner;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonIOUtil {
    private ObjectMapper objectMapper;

    public JsonIOUtil() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        //objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public void serializeCarToJson(List<Car> cars, File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            objectMapper.writeValue(file, cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Car> deserializeJsonToCar(File file) {
        List<Car> result = new ArrayList<>();
        try {
            result = objectMapper.readValue(file, new TypeReference<List<Car>>() {
            });



        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    public void serializeOwnerToJson(List<Owner> owners, File file) {
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            objectMapper.writeValue(file, owners);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Owner> deserializeJsonToOwner(File file){
        List<Owner> result = new ArrayList<>();
        try {
            result = objectMapper.readValue(file, new TypeReference<List<Owner>>() {
            });

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
