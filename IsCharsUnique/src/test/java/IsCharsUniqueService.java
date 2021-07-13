import java.util.Locale;

public class IsCharsUniqueService {

    public static boolean chars(String text){
        text = text.toLowerCase(Locale.ROOT);
        for(int i = 0; i < text.length(); i++){
           for(int j = 0; j < text.length(); j++){
               if(text.charAt(i) == text.charAt(j) && i != j){
                   return true;
               }
           }
        }
        return false;
    }
}
