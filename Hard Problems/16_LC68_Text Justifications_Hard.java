
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        ArrayList<String> result = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            int j = i;
            int letters = 0;

            // Step 1: Find how many words fit in one line
            while (j < words.length &&
                   letters + words[j].length() + (j - i) <= maxWidth) {

                letters += words[j].length();
                j++;
            }

            int gaps = j - i - 1;

            StringBuilder line = new StringBuilder();

            // Step 2: Last line or only one word
            if (j == words.length || gaps == 0) {

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                // Add remaining spaces at the end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }

            // Step 3: Normal line (fully justified)
            else {

                int totalSpaces = maxWidth - letters;

                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int spaces = spacesPerGap;

                        // Give extra spaces to left gaps
                        if (extraSpaces > 0) {
                            spaces++;
                            extraSpaces--;
                        }

                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());

            // Move to next line
            i = j;
        }

        return result;
    }
}
