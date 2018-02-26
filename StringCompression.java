package CrackingTheCodingInterview;

public class StringCompression {
    public String compress(String str){
        if(str == null){
            throw new IllegalArgumentException("Input string is invalid!");
        }

        if(str.length() == 0){
            return str;
        }

        int finalLength = countCompression(str);

        if(finalLength >= str.length()){
            return str;
        }

        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;

        for(int i=0; i<str.length(); i++){
            countConsecutive++;

            if((i >= str.length()) || (str.charAt(i) != str.charAt(i+1))){
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.toString();
    }

    private int countCompression(String str){
        int countConsecutive = 0;
        int compressedLength = 0;

        for(int i=0; i<str.length(); i++){
            countConsecutive++;

            if((i >= str.length()) || (str.charAt(i) != str.charAt(i+1))){
                compressedLength += String.valueOf(countConsecutive).length() + 1;
                countConsecutive = 0;
            }
        }

        return compressedLength;
    }
}
