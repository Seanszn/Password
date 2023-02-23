import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        if(args.length != 1){
            System.out.println("There is no password");
            System.exit(1);
        }
        String password = args[0];
        if(password.length() < 8 || password.length() > 16){
            System.exit(0);
        }
        Set<Character> upperCaseLetters = new TreeSet<>();
        Set<Character> lowerCaseLetters = new TreeSet<>();
        Set<Character> numbers = new TreeSet<>();
        Set<Character> specialSymbols = new TreeSet<>();

        for(int i = (int) 'A'; i<= (int) 'Z'; i++){
            Character c = (char) i;
            upperCaseLetters.add(c);
            lowerCaseLetters.add(Character.toLowerCase(c));
        }


        for(int i = (int) '0'; i <= (int)'9'; i++){
            numbers.add((char) i);
        }

        String spec = "~!@#$%^&*()-=+_";
        for(Character c: spec.toCharArray()){
            specialSymbols.add(c);
        }
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        count.put("Uppers", 0);
        count.put("Lowers", 0);
        count.put("Numbers", 0);
        count.put("Special", 0);
        count.put("Validity", 0);

        for(Character d: password.toCharArray()){
            if(upperCaseLetters.contains(d)){
                count.put("Uppers",count.get("Uppers")+1);
            }else if(lowerCaseLetters.contains(d)){
                count.put("Lowers",count.get("Lowers")+1);
            }else if(numbers.contains(d)){
                count.put("Numbers", count.get("Numbers")+1);
            }else if(specialSymbols.contains(d)){
                count.put("Special", count.get("Special")+1);
            }else{
                System.out.println("Invalid password");
            }
        }

        if(count.get("Uppers")>0){
            count.put("Validity", count.get("Validity")+1);     
        }
        if(count.get("Lowers")>0){
            count.put("Validity", count.get("Validity")+1);     
        }
        if(count.get("Numbers")>0){
            count.put("Validity", count.get("Validity")+1);     
        }
        if(count.get("Special")>0){
            count.put("Validity", count.get("Validity")+1);     
        }

        if(count.get("Validity")>=3){
            System.out.println("Valid password");
        }else{
            System.out.println("Password is not valid.");
        }
    }
}