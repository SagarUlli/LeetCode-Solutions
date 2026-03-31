class Solution {

    private static final String[] KEYS = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        result.add(""); // start with empty combination

        for (char digit : digits.toCharArray()) {
            String letters = KEYS[digit - '0'];
            List<String> temp = new ArrayList<>();

            for (String combination : result) {
                for (char ch : letters.toCharArray()) {
                    temp.add(combination + ch);
                }
            }

            result = temp; // move to next level
        }

        return result;
    }
}