package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static final String PRICE_REGEX = "^(?<amount>\\d+([.,]?\\d+)) (?<symbol>[^\\d\\s]+)$";

    public static Price parsePrice(String price) {
        Pattern pattern = Pattern.compile(PRICE_REGEX);
        Matcher matcher = pattern.matcher(price);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("'%s' doesn't match the price pattern: %s".formatted(price, PRICE_REGEX));
        }
        return new Price(matcher.group("amount"), matcher.group("symbol"));
    }
}
