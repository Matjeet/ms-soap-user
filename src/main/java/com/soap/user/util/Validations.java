package com.soap.user.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.soap.user.util.Constants.CELLPHONE_REGEX;
import static com.soap.user.util.Constants.EMAIL_REGEX;

public class Validations {

    private Validations() {
    }

    public static boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        return pattern.matcher(email).matches();
    }

    public static boolean isValidCellPhone(String cellphone){
        Pattern pattern = Pattern.compile(CELLPHONE_REGEX);
        return pattern.matcher(cellphone).matches();
    }

    public static void isFieldsNotEmptyOrNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("El objeto a validar no puede ser nulo");
        }

        Class<?> clazz = obj.getClass();
        List<String> errorMessages = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(obj);

                if (value == null) {
                    errorMessages.add("El campo '" + field.getName() + "' no puede ser nulo");
                } else if (value instanceof String && ((String) value).trim().isEmpty()) {
                    errorMessages.add("El campo '" + field.getName() + "' no puede estar vacío");
                }
                // Puedes agregar más validaciones para otros tipos aquí

            } catch (IllegalAccessException e) {
                errorMessages.add("No se pudo acceder al campo '" + field.getName() + "' para validación");
            }
        }

        if (!errorMessages.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", errorMessages));
        }
    }
}
