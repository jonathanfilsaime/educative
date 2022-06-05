import java.util.*;

class EvaluateExpression {
    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();

        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
        } else {
            for ( int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if (!Character.isDigit(currentChar)) {

                    List<Integer> left = diffWaysToEvaluateExpression(input.substring(0,i));
                    List<Integer> right = diffWaysToEvaluateExpression(input.substring(i + 1));

                    for (int partLeft: left) {
                        for (int partRight : right) {
                            if (currentChar == '+') {
                                result.add(partLeft + partRight);
                            }
                            if (currentChar == '-') {
                                result.add(partLeft - partRight);
                            }
                            if (currentChar == '*') {
                                result.add(partLeft * partRight);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }
}