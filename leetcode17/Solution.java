import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String digits = "22";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> ret = new ArrayList<String>();

        //Boundary Conditions
        if ( digits.length()==0 ) return ret;

        //Start
        ret.add("");
        for (int i=0; i<digits.length(); i++) {

            char ch = digits.charAt(i);
            //Grab the corresponding letters
            char[] letter = {'0', '0', '0', '0'};
            switch (ch) {
                case '2': letter[0] = 'a'; letter[1] = 'b'; letter[2] = 'c'; letter[3] = '0'; break;
                case '3': letter[0] = 'd'; letter[1] = 'e'; letter[2] = 'f'; letter[3] = '0'; break;
                case '4': letter[0] = 'g'; letter[1] = 'h'; letter[2] = 'i'; letter[3] = '0'; break;
                case '5': letter[0] = 'j'; letter[1] = 'k'; letter[2] = 'l'; letter[3] = '0'; break;
                case '6': letter[0] = 'm'; letter[1] = 'n'; letter[2] = 'o'; letter[3] = '0'; break;
                case '7': letter[0] = 'p'; letter[1] = 'q'; letter[2] = 'r'; letter[3] = 's'; break;
                case '8': letter[0] = 't'; letter[1] = 'u'; letter[2] = 'v'; letter[3] = '0'; break;
                case '9': letter[0] = 'w'; letter[1] = 'x'; letter[2] = 'y'; letter[3] = 'z'; break;
                default: break;
            }
            //Add the letters to the List
            int size = ret.size();
            for (int m=0; m<4; m++) {
                for (int j=0; j<size; j++) {
                    if ( letter[m] != '0' )
                        ret.add( ret.get(j) + letter[m] );
                }
            }
            for (int m=0; m<size; m++) {
                ret.remove(0);
            }
        }
        return ret;

    }
}