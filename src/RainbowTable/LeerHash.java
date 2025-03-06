package RainbowTable;

import java.io.*;
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
            String hash = br.readLine();

            while (hash != null && !existe)
            {
                String[] claves = hash.split(",");
                if (claves[1].equalsIgnoreCase(hashTeclado))
                {
                    System.out.println("La contraseña es: " + claves[0]);
                    existe = true;
                }

                hash = br.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
