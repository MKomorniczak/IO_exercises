package org.example;

import org.example.model.Car;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.model.Car;
import org.example.JsonIOUtil;
import org.example.model.Owner;


public class App {
    public static void main(String[] args) {
        //ex1
/*        File file1 = new File("destination/textfile1");
        ex1(file1);*/


        //ex2
/*        File url = new File("destination/textfile2");
        for (String string : read(url)) {
            System.out.println(string);
        }*/


        //ex3
/*        List<String> content = Arrays.asList(
                "Hello", "My", "Name", "Is", "Marek"
        );
        File url = new File("destination/textfile_ex3");
        write(url, content);*/

        //ex4
/*        File source = new File("source_ex4/file_ex4");
        File destination = new File("destination/copy_ex4");
        copyFile_ex4(source, destination);*/


        //ex5
/*        List<Car> cars = new ArrayList<>();
        Car car = new Car("ABC123", "Mercedes", "E-klass", 250);
        cars.add(car);

        CarSerialization.serialize(cars, "destination/cars.txt");
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("destination/cars.txt");
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            outputStream.writeObject(cars);
            FileInputStream fileInputStream = new FileInputStream("destination/cars.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            outputStream.close();
            objectInputStream.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                FileInputStream fileInputStream = new FileInputStream("destination/cars.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            cars = (ArrayList) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        for (Car car1 : cars) {
            System.out.println(car1);
        }*/


        //ex6
/*
        JsonIOUtil util = new JsonIOUtil();
        List<Car> cars = new ArrayList<>();
        Car merc = new Car("ABC123", "Mercedes", "E-klass", "Marek");
        Car bmw = new Car("GJH846", "BMW", "5-serie", "Maja");

        cars.add(merc);
        cars.add(bmw);

        File myCarFile = new File("cars.json");
        util.serializeCarToJson(cars, myCarFile);
        //List<Car> result = util.deserializeJsonToCar(myCarFile);
        //System.out.println(result.get(0));
        //System.out.println(result.get(1));

        List<Owner> owners = new ArrayList<>();
        Owner Marek = new Owner("Marek", LocalDate.parse("1991-11-22"));
        Owner Maja = new Owner("Maja", LocalDate.parse("2000-03-23"));

        owners.add(Marek);
        owners.add(Maja);

        File myOwnerList = new File("owners.json");
        util.serializeOwnerToJson(owners, myOwnerList );
        //List<Owner> resultOwner = util.deserializeJsonToOwner(myOwnerList);
        //System.out.println(resultOwner.get(0));
        //System.out.println(resultOwner.get(1));
*/




    }


    public static void ex1(File source) {
        StringBuilder sb = new StringBuilder();
        try (
                FileReader fileReader = new FileReader(source);
        ) {
            int i;
            while ((i = fileReader.read()) != -1) {
                char letter = (char) i;
                sb.append(letter);
            }
            System.out.println(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static List<String> read(File source) {
        List<String> strings = new ArrayList<>();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;

    }

    public static List<String> write(File destination, List<String> src) {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String toWrite : src) {
                writer.write(toWrite);
                writer.newLine();
            }
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return src;
    }

    public static void copyFile_ex4(File source, File destination) {
        try (
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination))
        ) {

            byte[] buffer = new byte[1024];
            int byteReader;
            while ((byteReader = in.read(buffer)) > 0) {
                out.write(buffer, 0, byteReader);
            }
            out.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
