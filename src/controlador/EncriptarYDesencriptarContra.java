package controlador;

import java.util.Random;

public class EncriptarYDesencriptarContra {

    public static void main(String[] args) {
        String texto = "Litzy te amo mucho";
        String encriptado = encriptar(texto, 3);
        String desencriptado = desencriptar(encriptado, 3);

        System.out.println("El texto es: " + texto + "\nEncriptado es: " + encriptado + "\nDesencriptado es: " + desencriptado);
    }

    public static String encriptar(String text, int key) {
        String text2 = "";
        String finaltext;
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] -= i;
            text2 += chars[i];
        }
        
        String contra = "";
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "1234567890";
        String conjunto = mayusculas + minusculas + numeros;

        for (int i = 0; i < text.length(); i++) {
            Random aleatorio = new Random();
            contra += conjunto.charAt(aleatorio.nextInt(conjunto.length()));
        }

        finaltext = text2 + contra;
        return finaltext;
    }

    public static String desencriptar(String text, int key) {
        String text2 = "";
        String correctText = text.substring(0, text.length() / 2);

        char[] chars = correctText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += i;
            text2 += chars[i];
        }
        return text2;
    }
}
