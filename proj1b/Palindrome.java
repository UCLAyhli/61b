public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> D = new ArrayDeque<Character>();
        for (int i = 0; i<word.length();i++){
            D.addLast(word.charAt(i));
        }
        return D;
    }
    public boolean isPalindrome(String word){
        Deque<Character> D = wordToDeque(word);
        int flag = 0;
        if (word.length()<=1){
            return true;
        }
        else {
            if (word.length()%2 == 0){
                for(int i = 0; i<word.length()/2;i++){
                    if (D.get(i) != D.get(word.length()-1-i)){
                        flag = 1;
                    }
                }
            }
            else {
                for(int i = 0; i<(word.length()-1)/2;i++){
                    if (D.get(i) != D.get(word.length()-1-i)){
                        flag = 1;
                    }
                }
            }
        }
        if (flag==1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> D = wordToDeque(word);
        int flag = 1;
        if (word.length()<=1){
            return true;
        }
        else {
            if (word.length()%2 == 0){
                for(int i = 0; i<word.length()/2;i++){
                    if (cc.equalChars(D.get(i), D.get(word.length()-1-i))){
                        flag = 0;
                    }
                }
            }
            else {
                for(int i = 0; i<(word.length()-1)/2;i++){
                    if (cc.equalChars(D.get(i), D.get(word.length()-1-i))){
                        flag = 0;
                    }
                }
            }
        }
        if (flag==1){
            return false;
        }
        else {
            return true;
        }
    }
}
