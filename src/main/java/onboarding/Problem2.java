package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        if (!isvalidInput(cryptogram)) {
            return "";
        }

        answer = getRecursionCrypto(cryptogram);

        return answer;
    }

    public static boolean isvalidInput(String cryptogram) {
        if (cryptogram == null || cryptogram.length() ==0) {
            return false;
        }

        if (!isCorrectSize(cryptogram)) {
            return false;
        }

        if (!isOnlyLowerCase(cryptogram)) {
            return false;
        }

        return true;
    }

    private static boolean isOnlyLowerCase(String cryptogram) {
        char[] charArray = cryptogram.toCharArray();

        for (char index : charArray) {
            if (Character.isUpperCase(index)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCorrectSize(String cryptogram) {
        return 1 <= cryptogram.length() && cryptogram.length()  <= 1000;
    }

    public static String getRecursionCrypto(String cryptogram) {
        int delCount = 0;
        char[] charArray = cryptogram.toCharArray();
        StringBuilder decryptogram = new StringBuilder();
        String answer = "";

        for (int i = 1; i <= charArray.length; i++) {

            if(isLastWord(charArray.length, i)){
                decryptogram.append(charArray[i-1]);
                break;
            }

            char firstChar = charArray[i-1];
            char secondChar = charArray[i];

            if(firstChar == secondChar){
                i = i + 1;
                delCount++;
            }else {
                decryptogram.append(firstChar);
            }
        }

        if (delCount > 0) {
            return getRecursionCrypto(decryptogram.toString());
        }

        return cryptogram;
    }

    private static boolean isLastWord(int length, int i) {
        return i == length;
    }

}
