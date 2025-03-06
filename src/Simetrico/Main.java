package Simetrico;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static KeyGenerator kg;
    static{
        try {
            kg = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    static SecretKey clave = kg.generateKey();

    public static void main(String[] args) {
        /*Intentas iniciar sesión en tu correo, pero no te acuerdas de la contraseña,
        para recuperarla, debes superar las preguntas de seguridad, si las superas
        se desencripta la contraseña y te la muestra*/

        String contrasena = "buenosDias1234";
        byte[] hash = encriptar(contrasena);
        boolean correcto = true;

        System.out.println("Para recuperar la contraseña deberás contestar unas preguntas");

        System.out.println("Pregunta 1: ¿Cuando descubrió Cristobal Colón America?");
        int respuesta = sc.nextInt();
        sc.nextLine();
        if(respuesta != 1492)
        {
            correcto = false;
        }

        System.out.println("Pregunta 2: ¿Cual es el único mamifero que pone huevos?");
        String respuesta2 = sc.nextLine();
        if(!respuesta2.equalsIgnoreCase("ornitorrinco"))
        {
            correcto = false;
        }

        System.out.println("Pregunta 3: ¿Cual es el simbolo atomico del Oxígeno?");
        String respuesta3 = sc.nextLine();
        if(!respuesta3.equalsIgnoreCase("o"))
        {
            correcto = false;
        }

        if(correcto)
        {
            System.out.println("Felicidades, has acertado, tu contraseña es " + desencriptar(hash));
        }
        else
        {
            System.out.println("Incorrecto, has fallado alguna de las preguntas, me quedo con tu contraseña");
        }
    }

    static byte[] encriptar(String cifrar)
    {
        try {
            kg.init(256,null);

            Cipher cifrador = Cipher.getInstance(clave.getAlgorithm());

            cifrador.init(Cipher.ENCRYPT_MODE, clave);
            byte[] resultado1 = cifrador.doFinal(cifrar.getBytes());
            return (resultado1);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    static String desencriptar(byte[] descifrar) {
        try {
            kg.init(256, null);

            Cipher cifrador = Cipher.getInstance(clave.getAlgorithm());

            cifrador.init(Cipher.DECRYPT_MODE, clave);
            byte[] resultado = cifrador.doFinal(descifrar);
            return (new String(resultado));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }

    }
}