package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        char[] array = password.toCharArray();
        int countDigits = 0;
        int countSpecialSymbols = 0;
        for (int index : array) {
            if (Character.isDigit(index)) {
                countDigits = countDigits + 1;
            }
            if (!(Character.isDigit(index)
                    || Character.isUpperCase(index)
                    || Character.isLowerCase(index))) {
                countSpecialSymbols = countSpecialSymbols + 1;
            }
        }
        if (countDigits == 0) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (countSpecialSymbols == 0) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        String[] substrings = new String[] {"qwerty", "12345", "password", "admin", "user"};
        for (String substring : substrings) {
            if (password.toLowerCase().contains(substring)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}
