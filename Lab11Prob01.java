/**
* File: Lab11Prob01.java
* Class: CSCI 1302
* Author: Brody McCullough
* Created on: Nov 20, 2025
* Last Modified: Nov 20, 2025
* Description: 
*/

import java.io.*;

public class Lab11Prob01 {

    public static void main(String[] args) {
        File inputFile = new File("src/people.dat");
        File outputFile = new File("src/people-copy.dat");

        try (
            DataInputStream in = new DataInputStream(new FileInputStream(inputFile));
            DataOutputStream out = new DataOutputStream(new FileOutputStream(outputFile));
        ) {
            while (true) {
                try {
                    int age = in.readInt();
                    String name = in.readUTF();
                    String address = in.readUTF();
                    int zip = in.readInt();
                    double salary = in.readDouble();

                    System.out.println("Age: " + age);
                    System.out.println("Name: " + name);
                    System.out.println("Address: " + address);
                    System.out.println("Zip: " + zip);
                    System.out.println("Salary: " + salary);
                    System.out.println("------------------------");

                    out.writeInt(age);
                    out.writeUTF(name);
                    out.writeUTF(address);
                    out.writeInt(zip);
                    out.writeDouble(salary);

                } catch (EOFException eof) {
                    break;
                }
            }

            System.out.println("Finished! Copy created at src/people-copy.dat");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}