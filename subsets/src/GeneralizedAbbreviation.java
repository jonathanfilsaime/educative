import java.util.*;

class AbbreviatedWord {
    StringBuilder str;
    int start;
    int count;

    public AbbreviatedWord(StringBuilder str, int start, int count) {
        this.str = str;
        this.start = start;
        this.count = count;
    }
}

class GeneralizedAbbreviation {

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<>();
        Queue<AbbreviatedWord> queue = new LinkedList<>();
        queue.add(new AbbreviatedWord(new StringBuilder(""), 0,0));
        while(!queue.isEmpty()) {
            AbbreviatedWord currentWord = queue.poll();

            if(currentWord.start == word.length()) {
                if(currentWord.count != 0) currentWord.str.append(currentWord.count);
                result.add(currentWord.str.toString());
            } else {
                queue.add(new AbbreviatedWord(new StringBuilder(currentWord.str), currentWord.start + 1, currentWord.count + 1));
                if(currentWord.count != 0) currentWord.str.append(currentWord.count);
                queue.add(new AbbreviatedWord(new StringBuilder(currentWord.str).append(word.charAt(currentWord.start)), currentWord.start + 1, 0));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}