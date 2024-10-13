package exercitiul1;

import java.io.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MainAppex1{
    public static void main(String[] args) throws FileNotFoundException {
        String[] judete;
        Scanner scanner=new Scanner(new File("src/in.txt"));
        judete=scanner.nextLine().split(", ");
        scanner.close();
        Arrays.sort(judete);
        Scanner scanner_citire=new Scanner(System.in);
        String cautat=scanner_citire.nextLine();
        scanner_citire.close();
        int i=Arrays.binarySearch(judete,cautat);
        System.out.println("Judetul: " + cautat + " se afla pe pozitia "+i);

    }
}

