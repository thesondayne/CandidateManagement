package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validation {
    public final static Scanner sc = new Scanner(System.in);

    public static String getStringByRegex(String mess, String regex, String error) {
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            if (input.matches(regex)) {
                return input;
            }
            if (input.isEmpty()) {
                System.out.println("Input can be empty");
                continue;
            }
            System.out.println(error);
        }
    }

    public static int getIntInRange(String mess, String errorFormat, String errorOutOfRange, int min, int max) {
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(errorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(errorFormat);
            }
        }
    }

    public static LocalDate getDate(String mess, String dateFormat, String errorFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            try {
                LocalDate date = LocalDate.parse(input, formatter);
                if (input.equals(date.format(formatter))) {
                    return date;
                }
                System.out.println("Date does not exist!");
            } catch (DateTimeParseException e) {
                if (input.matches("\\d{2}-\\d{2}-\\d{4}")) {
                    System.out.println("Date does not exist!");
                } else System.out.println(errorFormat);
            }
        }
    }

    public static LocalDate getDateInRange(String mess, String dateFormat, String errorFormat, LocalDate min, LocalDate max) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        String errorOutOfRange = "Date must be from " + min.format(formatter) + " to " + max.format(formatter);

        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            try {
                LocalDate date = LocalDate.parse(input, formatter);
                if (!input.equals(date.format(formatter))) {
                    System.out.println("Date does not exist!");
                    continue;
                }
                if (!date.isBefore(min) && !date.isAfter(max)) {
                    return date;
                }
                System.out.println(errorOutOfRange);
            } catch (DateTimeParseException e) {
                if (input.matches("\\d{2}-\\d{2}-\\d{4}")) {
                    System.out.println("Date does not exist!");
                } else System.out.println(errorFormat);
            }
        }
    }

    public static boolean getYNOption(String mess) {
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("y")) {
                return true;
            }
            if (input.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("Input N/n for No or Y/y for Yes");
        }
    }

    public static String getEmail(String mess) {
        String regex = "^[A-Za-z](.*)([@]{1})(.{2,})(\\.)(.{2,})"; // Start with alphabetic character and match with <account name>@<domain>
        return getStringByRegex(mess, regex, "Please enter email with format <account name>@<domain>");
    }

    public static String getPhoneNumber(String mess) {
        String regex = "^0[0-9]+";
        while (true) {
            String number = getStringByRegex(mess, regex, "Please enter phone number");
            if (number.length() > 9) return number;
            System.out.println("Phone number must be contain at least 10 characters");
        }
    }

}
