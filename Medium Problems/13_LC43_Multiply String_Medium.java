
class Solution {
    public String reverseWords(String s) {

        // Remove spaces from beginning and end
        s = s.trim();

        // Split string into words
        String[] words = s.split("\\s+");

        // Create StringBuilder
        StringBuilder result = new StringBuilder();

        // Traverse words from last to first
        for (int i = words.length - 1; i >= 0; i--) {

            result.append(words[i]);

            // Add space between words
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
