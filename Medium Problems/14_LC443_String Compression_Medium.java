
class Solution {
    public int compress(char[] chars) {

        int index = 0;
        int i = 0;

        while (i < chars.length) {

            char current = chars[i];
            int count = 0;

            // Count consecutive same characters
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }

            // Store the character
            chars[index] = current;
            index++;

            // Store count if greater than 1
            if (count > 1) {

                String num = String.valueOf(count);

                for (int j = 0; j < num.length(); j++) {
                    chars[index] = num.charAt(j);
                    index++;
                }
            }
        }

        return index;
    }
}
