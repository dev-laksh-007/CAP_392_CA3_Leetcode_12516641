class Solution {
    public boolean isPalindrome(String s) {
        String clean = "";

        for (int i = 0; i < s.length(); i++) {
            char letter = Character.toLowerCase(s.charAt(i));

            if (Character.isLetterOrDigit(letter)) {
                clean = clean + letter;
            }
        }

        String backwards = "";

        for (int i = clean.length() - 1; i >= 0; i--) {
            backwards = backwards + clean.charAt(i);
        }

        return clean.equals(backwards);
    }
}
