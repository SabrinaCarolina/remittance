package br.com.adrianoaluizio.models.enums;

import br.com.adrianoaluizio.utils.LayoutUtil;

public enum CleanerType {
    ACCENTS{
        @Override
        public String cleaner(String s) {
            return LayoutUtil.removeAccents(s);
        }
    },
    NUMBER_ONLY{
        @Override
        public String cleaner(String s) {
            return LayoutUtil.cleanNumber(s);
        }
    };

    public abstract String cleaner(String s);
}
