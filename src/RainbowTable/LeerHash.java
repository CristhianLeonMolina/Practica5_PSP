package RainbowTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LeerHash
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Escribe el hash que quieres que descodifique:");
        String hashTeclado = sc.nextLine();


        try {
            File f = new File("Rainbow_Table.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            boolean existe = false;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
