package org.cxxy.func.alindrome;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by LiuHui on 2017/4/14.
 */
public class PalindromeStream {

    private static boolean isPalindrome(String name) {

        return new StringBuffer(name).reverse().toString().equalsIgnoreCase(name);
    }






    public static Stream<String> getLines(String fileName) {
        try {
            return Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()), StandardCharsets.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }
}
