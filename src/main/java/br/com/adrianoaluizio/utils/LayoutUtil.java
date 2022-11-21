package br.com.adrianoaluizio.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Normalizer;

public class LayoutUtil {
    public static String verifyDigit(String wallet, String number ) {
        number = StringUtils.leftPad(number, 11, "0");
        number = wallet + number;
        int sequencial = 2;
        int position = number.length() - 1;
        int dac = 0;
        for (int i = number.length(); i > 0; i--) {
            int j = Character.getNumericValue(number.charAt(position));
            dac += (j * sequencial);
            if (sequencial == 2) {
                sequencial = 7;
            } else {
                sequencial--;
            }
            position--;
        }
        int mod = (dac % 11);
        String verify = "";
         switch (mod) {
             case 0:
                 verify ="0";
                 break;
             case 1:
                 verify = "P";
                 break;
             default:
                 verify = String.valueOf(11 - mod);
                 break;
        };
        return verify;
    }

    public static <T extends Number> int roundScale(T value) {
        BigDecimal val = new BigDecimal(value.toString());
        return (val.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(100))).intValue();
    }

    public static String removeAccents(String text) {
        text = text.replace("\n", "")
                .replace("\r", "")
                .replace("\t", "")
                .replace("&", "E");
        return Normalizer.normalize(text, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public static String cleanNumber(String number) {
        return number.replaceAll("\\D", "");
    }
}
