/* Author: Sandro Sobczyński */

package com.company;

public class Caesar {

    public Caesar(int offset) {
        this.offset = offset;
    }

    private int offset;

    public String encrypt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character != ' ') {
                int asciiOffset;
                if (Character.isUpperCase(character))
                    asciiOffset = 64;
                else
                    asciiOffset = 97;
                int temp = (int) character - asciiOffset;
                char newCharacter = (char) (((temp + offset) % 26) + asciiOffset);
                result += newCharacter;
            } else
                result += ' ';
        }
        return result;
    }

}
