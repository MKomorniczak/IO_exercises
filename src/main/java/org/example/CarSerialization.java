package org.example;

import java.io.*;
import java.util.List;

public class CarSerialization {
    public static List<CarEx> serialize(List<CarEx> source, String filePath) {
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)
                ) {
            out.writeObject(source);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return source;

    }

}
