package com.yt.design.font.site.api.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 摩斯密码工具
 * @Author
 * @Create 2017-12-06 上午9:35
 **/

public class MorseCodeUtil {
    private static Map<String, String> morseCodeMap;

    static {
        morseCodeMap = new HashMap<>();

        morseCodeMap.put("a", ".- ");
        morseCodeMap.put("b", "-... ");
        morseCodeMap.put("c", "-.-. ");
        morseCodeMap.put("d", "-.. ");
        morseCodeMap.put("e", ". ");
        morseCodeMap.put("f", "..-. ");
        morseCodeMap.put("g", "--. ");
        morseCodeMap.put("h", ".... ");
        morseCodeMap.put("i", ".. ");
        morseCodeMap.put("j", ".--- ");
        morseCodeMap.put("k", "-.- ");
        morseCodeMap.put("l", ".-.. ");
        morseCodeMap.put("m", "-- ");
        morseCodeMap.put("n", "-. ");
        morseCodeMap.put("o", "--- ");
        morseCodeMap.put("p", ".--. ");
        morseCodeMap.put("q", "--.- ");
        morseCodeMap.put("r", ".-. ");
        morseCodeMap.put("s", "... ");
        morseCodeMap.put("t", "- ");
        morseCodeMap.put("u", "..- ");
        morseCodeMap.put("v", "...- ");
        morseCodeMap.put("w", ".-- ");
        morseCodeMap.put("x", "-..- ");
        morseCodeMap.put("y", "-.-- ");
        morseCodeMap.put("z", "--.. ");
        morseCodeMap.put("1", ".---- ");
        morseCodeMap.put("2", "..--- ");
        morseCodeMap.put("3", "...-- ");
        morseCodeMap.put("4", "....- ");
        morseCodeMap.put("5", "..... ");
        morseCodeMap.put("6", "-.... ");
        morseCodeMap.put("7", "--... ");
        morseCodeMap.put("8", "---.. ");
        morseCodeMap.put("9", "----. ");
        morseCodeMap.put("0", "----- ");
        morseCodeMap.put("?", "..--.. ");
        morseCodeMap.put("/", "-..-. ");
        morseCodeMap.put("[", "-.-.. ");
        morseCodeMap.put("]", ".---. ");
        morseCodeMap.put("-", "-....- ");
        morseCodeMap.put("_", "..--.- ");
        morseCodeMap.put(".", ".-.-.- ");
        morseCodeMap.put("@", "--.-. ");
        morseCodeMap.put("*", "---- ");
        morseCodeMap.put("$", "...-. ");
        morseCodeMap.put("#", "..-- ");
        morseCodeMap.put(" ", "-....- ");
    }

    private static Map<String, String> codeMorseMap;

    static {
        codeMorseMap = new HashMap<>();
        codeMorseMap.put(".-", "a");
        codeMorseMap.put("-...", "b");
        codeMorseMap.put("-.-.", "c");
        codeMorseMap.put("-..", "d");
        codeMorseMap.put(".", "e");
        codeMorseMap.put("..-.", "f");
        codeMorseMap.put("--.", "g");
        codeMorseMap.put("....", "h");
        codeMorseMap.put("..", "i");
        codeMorseMap.put(".---", "j");
        codeMorseMap.put("-.-", "k");
        codeMorseMap.put(".-..", "l");
        codeMorseMap.put("--", "m");
        codeMorseMap.put("-.", "n");
        codeMorseMap.put("---", "o");
        codeMorseMap.put(".--.", "p");
        codeMorseMap.put("--.-", "q");
        codeMorseMap.put(".-.", "r");
        codeMorseMap.put("...", "s");
        codeMorseMap.put("-", "t");
        codeMorseMap.put("..-", "u");
        codeMorseMap.put("...-", "v");
        codeMorseMap.put(".--", "w");
        codeMorseMap.put("-..-", "x");
        codeMorseMap.put("-.--", "y");
        codeMorseMap.put("--..", "z");
        codeMorseMap.put(".----", "1");
        codeMorseMap.put("..---", "2");
        codeMorseMap.put("...--", "3");
        codeMorseMap.put("....-", "4");
        codeMorseMap.put(".....", "5");
        codeMorseMap.put("-....", "6");
        codeMorseMap.put("--...", "7");
        codeMorseMap.put("---..", "8");
        codeMorseMap.put("----.", "9");
        codeMorseMap.put("-----", "0");
        codeMorseMap.put("..--..", "?");
        codeMorseMap.put("-..-.", "/");
        codeMorseMap.put("-.-..", "[");
        codeMorseMap.put(".---.", "]");
//        codeMorseMap.put("-....-", "-");ss
        codeMorseMap.put(".-.-.-", ".");
        codeMorseMap.put("--.-.", "@");
        codeMorseMap.put("----", "*");
        codeMorseMap.put("...-.", "$");
        codeMorseMap.put("..--", "#");
        codeMorseMap.put("-....-", " ");
    }

    /**
     * 加密
     *
     * @param data 元数据
     * @return
     */
    public static String encrypt(String data) {
        if (data == null || data.isEmpty()) {
            return data;
        }
        data = data.toLowerCase();
        String[] array = data.split("");
        StringBuilder outPutBuffer = new StringBuilder();
        for (String a : array) {
            outPutBuffer.append(morseCodeMap.get(a));
        }
        return outPutBuffer.toString();
    }

    /**
     * 解密
     *
     * @param data 元数据
     * @return
     */
    public static String decrypt(String data) {
        if (data == null || data.isEmpty()) {
            return data;
        }
        String[] array = data.split(" ");
        StringBuilder outPutBuffer = new StringBuilder();
        for (String a : array) {
            outPutBuffer.append(codeMorseMap.get(a));
        }
        return outPutBuffer.toString();
    }

}


