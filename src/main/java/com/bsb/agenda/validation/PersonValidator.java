package com.bsb.agenda.validation;

import com.bsb.agenda.model.entity.Person;
import com.bsb.agenda.model.request.PersonRequest;

import java.util.regex.Pattern;

public class PersonValidator {
    public static boolean validateFirstName(String firstName) {
        return firstName != null && !firstName.trim().isEmpty();
    }
    public static boolean validateLastName(String lastName) {
        return lastName != null && !lastName.trim().isEmpty()&& !lastName.equals("");
    }
    public static boolean validateCell(String cell) {
        if (cell == null || cell.trim().isEmpty()) {
            return false;
        }
        Pattern cellPattern = Pattern.compile("\\d{10}");
        return cellPattern.matcher(cell).matches();
    }
    public static boolean validateAddress(String address) {
        return address != null && !address.trim().isEmpty();
    }

    public static boolean validateProvince(String province) {
        return province != null && !province.trim().isEmpty();
    }

    public static boolean validateCountry(String country) {
        return country != null && !country.trim().isEmpty();
    }
    public static boolean validatePerson(Person person) {
        return validateFirstName(person.getFirstName()) &&
                validateLastName(person.getLastName()) &&
                validateAddress((person.getAddress()))&&
                validateProvince(person.getPhoneLine())&&
                validateCountry(person.getCoutry())&&
                validateCell(person.getCell());
    }
    public static boolean validatePerson(PersonRequest request) {
        return validateFirstName(request.getFirstName()) &&
                validateLastName(request.getLastName()) &&
                validateAddress((request.getAddress()))&&
                validateProvince(request.getPhoneLine())&&
                validateCountry(request.getCoutry())&&
                validateCell(request.getCell());
    }
}
