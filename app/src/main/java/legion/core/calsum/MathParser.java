package legion.core.calsum;

import android.text.TextUtils;

class MathParser {

    private static final char MULTIPLY = '×';
    private static final char DIVIDE = '÷';
    private static final char MINUS = '-';
    private static final char PLUS = '+';

    public String calculate(String expression) {
        if (TextUtils.isEmpty(expression)) return expression;

        try {

            expression = trimOperators(expression);

            for (int i = expression.length() - 1; i >= 0; i--) {
                if (expression.charAt(i) == PLUS) {
                    String first = expression.substring(0, i);
                    String second = expression.substring(i + 1, expression.length());
                    return String.valueOf(Double.parseDouble(calculate(first)) + Double.parseDouble(calculate(second)));
                }
            }
            for (int i = expression.length() - 1; i >= 0; i--) {
                if (expression.charAt(i) == MINUS) {
                    String first = expression.substring(0, i);
                    String second = expression.substring(i + 1, expression.length());
                    return String.valueOf(Double.parseDouble(calculate(first)) - Double.parseDouble(calculate(second)));
                }
            }
            for (int i = expression.length() - 1; i >= 0; i--) {
                if (expression.charAt(i) == DIVIDE) {
                    String first = expression.substring(0, i);
                    String second = expression.substring(i + 1, expression.length());
                    return String.valueOf(Double.parseDouble(calculate(first)) / Double.parseDouble(calculate(second)));
                }
            }
            for (int i = expression.length() - 1; i >= 0; i--) {
                if (expression.charAt(i) == MULTIPLY) {
                    String first = expression.substring(0, i);
                    String second = expression.substring(i + 1, expression.length());
                    return String.valueOf(Double.parseDouble(calculate(first)) * Double.parseDouble(calculate(second)));
                }
            }
            return expression;

        } catch (Exception e) {
            return "Error";
        }
    }

    private String trimOperators(String expression) {
        while (expression.matches("[+\\-×÷.](.*)")) {
            expression = expression.substring(1, expression.length());
            System.out.println(expression);
        }

        while (expression.matches("(.*)[+\\-×÷.]")) {
            expression = expression.substring(0, expression.length() - 1);
            System.out.println(expression);
        }

//        char lastChar = expression.charAt(expression.length() - 1);
//        switch (lastChar) {
//            case PLUS:
//            case MINUS:
//            case MULTIPLY:
//            case DIVIDE:
//                expression = expression.substring(0, expression.length() - 1);
//                break;
//        }

        return expression;
    }
}
