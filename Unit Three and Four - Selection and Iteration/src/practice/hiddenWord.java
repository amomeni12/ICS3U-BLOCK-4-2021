package practice;

public class hiddenWord {
    private String hiddenWord;  
    public hiddenWord(String word){
        hiddenWord = word; 
    }
        
    public String getHint(String word){
        String hint = "" ;
        for(int i = 0; i < word.length(); i++){
            String current = word.substring(i, i+1);
            String hidden = hiddenWord.substring(i, i+1); 
            if(current.equals(hidden)){
                hint += current; 
            }else if(hiddenWord.indexOf(current) >= 0){
                hint += "+"; 
            }else{
                hint += "*"; 
            }
        }
        return hint; 
    }
}
