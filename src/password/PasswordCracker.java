package password;
import java.util.*;


public class PasswordCracker {
    public static void main(String[] args) {
        // Programa conductor se inicializa todos los input y un set que lleva las contraseñas de usuario,
        // y un hashmap que lleva las palabras y un booleano si dentro del login attemp se encuentra una de las
        // palabras que se ingresa.
        Scanner input = new Scanner(System.in);
        System.out.print("Test Cases: ");
        int testCases = input.nextInt();
        for(int i = 0; i < testCases; i++){
            System.out.print("Number of users with password: ");
            int usersWithPassword = input.nextInt();
            Set<String> dict = new HashSet<>();
            Map<String,Boolean> map = new HashMap<>();
            System.out.print("Password for each user: ");
            for(int j = 0; j < usersWithPassword; j++){
                dict.add(input.next());
            }
            System.out.print("Login attempt: ");
            String loginAttempt = input.next();
            boolean result = searchPassword(loginAttempt,dict,"",map);
            if (!result){
                System.out.println("WRONG PASSWORD");
            }
        }
    }

    private static boolean searchPassword(String sentence, Set<String> dict, String recursionString,
                                          Map<String,Boolean> map){
        // funcion que se llama en forma de recursion  y primera linea es la condicion para acabar la iteracion,
        // si se llega a cumplir la condicion sino se retorna false y se maneja en la funcion conductor.
        if (sentence == null || sentence.length() == 0){
            System.out.println("password: "+recursionString.trim());
            return true;
        }
        if (map.containsKey(sentence)){
            return map.get(sentence);
        }
        for(String word : dict){
            if (!sentence.startsWith(word)){
                continue;
            }
            if (searchPassword(sentence.substring(word.length()),dict,recursionString + word + " ",map)){
                map.put(sentence,true);
                return true;
            }
        }
        map.put(sentence,false);
        return false;
    }
}
