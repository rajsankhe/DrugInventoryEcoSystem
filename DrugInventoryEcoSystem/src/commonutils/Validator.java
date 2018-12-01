/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vivekdalal
 */
public class Validator {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_STRING_WITH_SPACES
            = Pattern.compile("[a-zA-Z\\\\s']+", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_ALPHA_NUMERIC
            = Pattern.compile("^[a-zA-Z0-9]*$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_USERNAME
            = Pattern.compile("^[a-z0-9._-]{2,25}$", Pattern.CASE_INSENSITIVE);

//Validation methods for String input type in input on the form.
    public static boolean isValidString(String str) {
        if (null != str && str.length() > 0) {
            //Checking whether the string contains only characters and no numbers
            return str.chars().allMatch(Character::isLetter);
        } else {
            return false;
        }
    }

    //Validation methods for all different types of input on the form.
    public static boolean isValidData(String str) {
        if (null != str && str.length() > 0) {
            //Checking whether the string contains only characters and no numbers
            return true;
        } else {
            return false;
        }
    }

    //Validation methods for Number (int) datatype of input on the form.
    public static boolean isValidNum(String str) {
        if (null != str && str.length() > 0) {
            return str.chars().allMatch(Character::isDigit);

        } else {
            return false;
        }
    }

    //Validation methods for Image File Path
    public static boolean isValidPath(String str) {
        if (null != str && str.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    //Validation methods for all Decimal Numbers(Double) of Input on the form
    public static boolean isValidDouble(String str) {
        if (null != str && str.length() > 0) {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException numberFormatException) {
                //numberFormatException.printStackTrace();
                return false;
            }

        } else {
            return false;
        }
    }

    //Checking the date format inputed on the screen
    public static boolean checkDateFormat(String str) {
        //String test = "02/01/20";
        //Check if date is null or empty
        if (str == null || str.isEmpty()) {
            return false;
        }

        String format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(str);
            if (!sdf.format(date).equals(str)) {
                throw new ParseException(str + " is not a valid format for " + format, 0);
            }
            return true;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean isValidEmail(String emailStr) {
        if (emailStr.isEmpty()) {
            return false;
        }
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean isValidStringWithSpaces(String nameStr) {
        if (nameStr.isEmpty()) {
            return false;
        }
        Matcher matcher = VALID_STRING_WITH_SPACES.matcher(nameStr);
        return matcher.find();
    }

    public static boolean isValidAlphaNum(String str) {
        if (str.isEmpty()) {
            return false;
        }

        Matcher matcher = VALID_ALPHA_NUMERIC.matcher(str);
        return matcher.find();
    }

    public static boolean isValidUsername(String str) {
        if (str.isEmpty()) {
            return false;
        }

        Matcher matcher = VALID_USERNAME.matcher(str);
        return matcher.find();
    }
}
