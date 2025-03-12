import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {


    public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public String findDate(String string) {
        String regex = "\\b(\\d{2}/\\d{2}/\\d{4}|\\d{4}-\\d{2}-\\d{2}|\\d{4}/\\d{2}/\\d{2})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            String date = matcher.group();
            if (isValidDate(date)) {
                return date;
            }
        }
        return null;
    }


    private boolean isValidDate(String date) {
        String[] parts;
        if (date.contains("/")) {
            parts = date.split("/");
        } else if (date.contains("-")) {
            parts = date.split("-");
        } else {
            return false;
        }

        if (parts.length != 3) {
            return false;
        }

        int day, month, year;
        if (parts[0].length() == 4) {
            year = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            day = Integer.parseInt(parts[2]);
        } else {
            day = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        }

        if (month < 1 || month > 12) {
            return false;
        }

        if (day < 1 || day > 31) {
            return false;
        }

        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            return false;
        }

        if (month == 2) {
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (isLeapYear && day > 29) {
                return false;
            }
            if (!isLeapYear && day > 28) {
                return false;
            }
        }

        return true;
    }


    public int findValidPasswords(String string) {
        String regex = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[^\\s]{8,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }


    public List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();
        String regex = "\\b[a-zA-Z]{3,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String word = matcher.group();
            if (isPalindrome(word)) {
                list.add(word);
            }
        }
        return list;
    }

    // Checks if a word is a palindrome
    private boolean isPalindrome(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(reversed);
    }
}