import java.util.*;

class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();

        //edge case
        if (str == null) return permutations;

        //add to permutation
        permutations.add(str);

        for ( int i = 0; i < str.length(); i++) {
            if(Character.isLetter(str.charAt(i))) {

                int n = permutations.size();

                //based on permutation size make modifications
                for ( int j = 0; j <= n; j++) {
                    char[] chars = permutations.get(j).toCharArray();

                    if(Character.isUpperCase(chars[i])) {
                        chars[i] = Character.toLowerCase(chars[i]);
                    } else {
                        chars[i] = Character.toUpperCase(chars[i]);
                    }

                    //add modified to the permutation
                    permutations.add(String.valueOf(chars));
                }
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}