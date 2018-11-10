/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author vivekdalal
 */
public class FileDataValidator {

    public static final String ORDER = "ORDER";
    public static final String PRODUCT = "PRODUCT";
    public static final String INT_TYP = "INT";
    public static final String STR_TYP = "STR";
    public static final String DOUBLE_TYP = "DOUBLE";
    public static final String[] ORDER_TYPE_CHECK = {"INT", "INT", "INT", "INT", "INT", "INT", "DOUBLE"};
    public static final String[] PRODUCT_TYPE_CHECK = {"INT", "DOUBLE", "DOUBLE", "DOUBLE"};

    //Validating each record from the file
    public static boolean checkIfRecordIsValid(String[] row, String typeOfRecord) throws Exception {
        //Integer.parseInt(prodRow[0]), Integer.parseInt(prodRow[1]), Integer.parseInt(prodRow[2]), Integer.parseInt(prodRow[3])
        //Integer.parseInt(orderRow[1]), Integer.parseInt(orderRow[2]), Integer.parseInt(orderRow[4]), Double.parseDouble(orderRow[6]), Integer.parseInt(orderRow[3])
        if (row == null) {
            throw new Exception("Null row for a " + typeOfRecord);
        }

        if (PRODUCT.equalsIgnoreCase(typeOfRecord)) {

            if (!checkElementCount(row.length, 4)) {
                //Incorrect number of elements in the row.
                throw new Exception("Incorrect number of elements in the row for a " + typeOfRecord + " record");
            }

            if (!checkElementDataType(row, PRODUCT_TYPE_CHECK)) {
                throw new Exception("Incorrect datatype of one or more element in the row. for a " + typeOfRecord + " record");
            }

        } else if (ORDER.equalsIgnoreCase(ORDER)) {

            if (!checkElementCount(row.length, 7)) {
                //Incorrect number of elements in the row.
                throw new Exception("Incorrect number of elements in the row for a " + typeOfRecord + " record");
            }

            if (!checkElementDataType(row, ORDER_TYPE_CHECK)) {
                throw new Exception("Incorrect datatype of one or more element in the row. for a " + typeOfRecord + " record");
            }

        } else {
            throw new Exception("Incorrect recordType. Only allowed types are ORDER and PRODUCT");
        }

        //Record is valid
        return true;
    }

    public static boolean checkElementCount(int length, int expectedLength) {
        return (expectedLength == length) ? true : false;

    }

    public static boolean checkElementDataType(String[] row, String[] typeDetails) {
        //Checking if each element has correct datatype
        for (int i = 0; i < row.length; i++) {
            //Calling the validator method to check the same
            if (typeDetails[i].equalsIgnoreCase(INT_TYP)) {
                if (!Validator.isValidNum(row[i])) {
                    System.out.println("Incorrect data : " + row[i]);
                    return false;
                }
            } else if (typeDetails[i].equalsIgnoreCase(DOUBLE_TYP)) {
                if (!Validator.isValidDouble(row[i])) {
                    System.out.println("Incorrect data : " + row[i]);
                    return false;
                }
            }
        }

        return true;
    }

}
