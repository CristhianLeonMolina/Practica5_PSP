package RainbowTable;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class CrearHash {
    public static void main(String[] args) {
        try {
            File f = new File("Contrasenas.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> claves = new ArrayList<>();

            String clave = br.readLine();
            while(clave != null)
            {
                claves.add(clave);
                clave = br.readLine();
            }

            File f2 = new File("Rainbow_Table.txt");
            if(!f2.exists())
            {
                f2.createNewFile();
            }

            FileWriter fw = new FileWriter(f2);
            BufferedWriter bw = new BufferedWriter(fw);

            MessageDigest md = MessageDigest.getInstance("MD5");

            for (int i = 0; i < claves.size(); i++)
            {
                md.update(claves.get(i).getBytes());
                byte[] hash = md.digest();

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < hash.length; j++)
                {
                    sb.append(String.format("%2X", hash[j]));
                }
                bw.write(claves.get(i) + "," + String.valueOf(sb) + "\n");
            }

            bw.close();
            br.close();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
