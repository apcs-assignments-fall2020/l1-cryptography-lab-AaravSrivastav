import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key1 = "";
        int keyRep = (int)((message.length() / key.length()) + 1);
        for(int j = 0; j<keyRep; j++)
        {
            key1+=key;
        }
        String newMsg = "";
        int space = 0;
        for(int i = 0; i<message.length(); i++)
        {
            if(!Character.isLetter(message.charAt(i)))
            {
                newMsg += message.charAt(i);
                space++;
            }
            else if(!Character.isLetter((char)((message.charAt(i) + str.indexOf(key1.charAt(i-space))))) )
            {
                newMsg += (char)(message.charAt(i) -(26 - str.indexOf(key1.charAt(i-space))));
            }
            else
            {
                newMsg += (char)(message.charAt(i) + str.indexOf(key1.charAt(i-space)));
            }
        }
        return newMsg;
    }

    public static String decryptVigenere(String message, String key) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key1 = "";
        int keyRep = (int)((message.length() / key.length()) + 1);
        for(int j = 0; j<keyRep; j++)
        {
            key1+=key;
        }
        String newMsg = "";
        int space = 0;
        for(int i = 0; i<message.length(); i++)
        {
            if(!Character.isLetter(message.charAt(i)))
            {
                newMsg += message.charAt(i);
                space++;
            }
            else if(!Character.isLetter((char)((message.charAt(i) - str.indexOf(key1.charAt(i-space))))) )
            {
                newMsg += (char)(message.charAt(i) + (26 - str.indexOf(key1.charAt(i-space))));
            }
            else
            {
                newMsg += (char)(message.charAt(i) - str.indexOf(key1.charAt(i-space)));
            }
        }
        return newMsg;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
