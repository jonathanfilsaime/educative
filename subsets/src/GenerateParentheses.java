import java.util.*;

class Parenth {
    String str;
    int openCount;
    int closeCount;

    public Parenth(String s, int openCount, int closeCount) {
        str = s;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}
class GenerateParentheses {
    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        Queue<Parenth> queue = new LinkedList<>();
        queue.add(new Parenth("", 0, 0));

        while(!queue.isEmpty()) {
            Parenth currentParenth = queue.poll();

            if (currentParenth.openCount == num && currentParenth.closeCount == num) {
                result.add(currentParenth.str);
            } else {

                if (currentParenth.openCount < num) {
                    queue.add(new Parenth(currentParenth.str + "(", currentParenth.openCount + 1, currentParenth.closeCount ));
                }

                if (currentParenth.openCount > currentParenth.closeCount) {
                    queue.add(new Parenth(currentParenth.str + ")", currentParenth.openCount, currentParenth.closeCount + 1));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}