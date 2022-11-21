package br.com.adrianoaluizio.processors;

import br.com.adrianoaluizio.models.enums.FillOrientation;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public class AttSpecProcessorAssistant {
    public Object getValue(Field field, Object o) {
        try {
            field.setAccessible(true);
            return field.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public String resize(String s, int length, FillOrientation fillOrientation, char c) {
        if (s.length() >= length) {
            return s.substring(0, length);
        }
        if (fillOrientation == FillOrientation.LEFT) {
            return StringUtils.leftPad(s, length, c);
        }
        return StringUtils.rightPad(s, length, c);
    }


}
