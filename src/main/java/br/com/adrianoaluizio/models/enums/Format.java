package br.com.adrianoaluizio.models.enums;

import br.com.dld.suppledate.Shape;
import br.com.dld.suppledate.SuppleDate;
import br.com.adrianoaluizio.utils.LayoutUtil;

import java.math.BigDecimal;
import java.time.LocalDate;

public enum Format {
    NONE {
        @Override
        public String format(Object o) {
            if (o == null) {
                return "";
            }
            return o.toString();
        }
    }, DATE_DDMMYY {
        @Override
        public String format(Object o) {
            if (o == null) {
                return "";
            }
            return SuppleDate.of((LocalDate) o).format(Shape.BASIC_D2).toString();
        }
    }, DECIMAL_DD {
        @Override
        public String format(Object o) {
            if (o == null) {
                return "";
            }
            return Integer.toString(LayoutUtil.roundScale((BigDecimal) o));
        }
    };

    public abstract String format(Object o);
}
