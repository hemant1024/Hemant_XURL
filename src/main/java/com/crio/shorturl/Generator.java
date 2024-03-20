package com.crio.shorturl;
import java.util.Random;

public class Generator {
    private static final int NUMBERS_CHAR = 9;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private Random random;

    public Generator() {
        random = new Random();
    }

    public String generate (){
        char []array = new char[NUMBERS_CHAR];
        for (int i =0; i<NUMBERS_CHAR; i++){
            int r= random.nextInt(ALPHABET.length()-1);
            array[i] = ALPHABET.charAt(r);
        }

        return new String(array);
    }
    
    
}
