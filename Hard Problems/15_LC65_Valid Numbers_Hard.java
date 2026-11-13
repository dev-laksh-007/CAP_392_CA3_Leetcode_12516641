
class Solution {
    public boolean isNumber(String s) {

        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        boolean numAfterExp = true;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Case 1: Digit
            if (ch >= '0' && ch <= '9') {
                num = true;
                numAfterExp = true;
            }

            // Case 2: Decimal point
            else if (ch == '.') {

                // Decimal is not allowed after exponent
                if (dot || exp) {
                    return false;
                }

                dot = true;
            }

            // Case 3: Exponent (e or E)
            else if (ch == 'e' || ch == 'E') {

                // Exponent needs a number before it
                if (exp || !num) {
                    return false;
                }

                exp = true;
                numAfterExp = false;
            }

            // Case 4: Positive or negative sign
            else if (ch == '+' || ch == '-') {

                // Sign is allowed only at the beginning
                // or immediately after exponent
                if (i != 0 && s.charAt(i - 1) != 'e'
                           && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Case 5: Any other character
            else {
                return false;
            }
        }

        return num && numAfterExp;
    }
}
