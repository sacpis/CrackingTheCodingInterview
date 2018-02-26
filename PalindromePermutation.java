package CrackingTheCodingInterview;

public class PalindromePermutation {
    public boolean isPermutationOfPalindrome(String phrase){
        int[] table = getCharFrequency(phrase);
        return checkMaxOneOdd(table);
    }

    private boolean checkMaxOneOdd(int[] table){
        boolean foundOneOdd = false;

        for(int count : table){
            if(count % 2 == 1){
                if(foundOneOdd){
                    return false;
                }

                foundOneOdd = true;
            }
        }

        return true;
    }

    private int[] getCharFrequency(String phrase){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for(char c : phrase.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
            }
        }

        return table;
    }

    private int getCharNumber(char c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if(a <= val && val <= z){
            return val - a;
        }

        return -1;
    }
}
