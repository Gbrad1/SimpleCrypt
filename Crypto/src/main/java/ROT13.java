import java.util.logging.Logger;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    private static final Logger LOGGER = Logger.getLogger(ROT13.class.getName());

    int difference;

    ROT13(Character cs, Character cf) {
        difference = cf - cs;
    }

    ROT13() {
        difference = 13;
    }

    public String crypt(String text) throws UnsupportedOperationException {

        char[] charArray = text.toCharArray();
        char[] toReturn = new char[charArray.length];

        for (int i = 0; i < charArray.length; i++) {

            int numberValue = text.charAt(i);

            if (numberValue >= 65 && numberValue <= 90){
                if (numberValue + difference > 90) {
                    toReturn[i] = (char)((numberValue + difference) - 26);
                } else {
                    toReturn[i] = (char)((numberValue + difference));
                }
            } else if (numberValue >= 97 && numberValue <= 122) {
                if (numberValue + difference > 122) {
                    toReturn[i] = (char)((numberValue + difference) - 26);
                } else {
                    toReturn[i] = (char)(numberValue + difference);
                }
            } else {
                toReturn[i] = (char)numberValue;
            }
        }

        return new String(toReturn);
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        int b = c;
        int a = 'A';
        int distanceFromA = b - a;

        char[] charArray = s.toCharArray();
        char[] toReturn = new char[charArray.length];

        for (int i = 0; i < s.length(); i++) {
            if (i < distanceFromA) {
                toReturn[i] = charArray[i + distanceFromA];
            } else if (i >= distanceFromA) {
                toReturn[i] = charArray[i - distanceFromA];
            }
        }

        return new String(toReturn);
    }

}
