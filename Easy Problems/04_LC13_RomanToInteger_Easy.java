class Solution {
    public int romanToInt(String s) {
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = value(s.charAt(i));

           
            if (i + 1 < s.length() && current < value(s.charAt(i + 1))) {
                total = total - current;
            } else {
                total = total + current;
            }
        }

        return total;
    }

    private int value(char symbol) {
        if (symbol == 'I') return 1;
        if (symbol == 'V') return 5;
        if (symbol == 'X') return 10;
        if (symbol == 'L') return 50;
        if (symbol == 'C') return 100;
        if (symbol == 'D') return 500;
        return 1000; // M
    }
}
