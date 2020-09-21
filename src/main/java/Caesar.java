import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        String encryptMsg = "";
        for(int i=0; i<message.length(); i++)
        {
            if((message.charAt(i) <= 'W' || (message.charAt(i) >= 'a' && message.charAt(i) <= 'w')) && message.charAt(i) != ' ')
            {
                encryptMsg += (char)(message.charAt(i)+3);
            }
            else if(message.charAt(i) == ' ')
            {
                encryptMsg += ' ';
            }
            else if((message.charAt(i)>='x' && message.charAt(i)>='z') || (message.charAt(i)>='X' && message.charAt(i)>='Z'))
            {
                encryptMsg += (char)(message.charAt(i)-23);
            }
            
        }
        return encryptMsg;
    }

    public static String decryptCaesar(String message) {
        String decryptMsg = "";
        for(int i=0; i<message.length(); i++)
        {
            if((message.charAt(i) >= 'd' || (message.charAt(i) >= 'D' && message.charAt(i) <= 'Z')) && message.charAt(i) != ' ')
            {
                decryptMsg += (char)(message.charAt(i)-3);
            }
            else if(message.charAt(i) == ' ')
            {
                decryptMsg += ' ';
            }
            else if((message.charAt(i)>='a' && message.charAt(i)>='c') || (message.charAt(i)>='A' && message.charAt(i)>='C'))
            {
                decryptMsg += (char)(message.charAt(i)+23);
            }
            
        }
        return decryptMsg;
    }

    public static String encryptCaesarKey(String message, int key) {
        String encryptMsg = "";
        for(int i=0; i<message.length(); i++)
        {
            if((message.charAt(i) <= 90-key || (message.charAt(i) >= 'a' && message.charAt(i) <= 122-key)) && message.charAt(i) != ' ')
            {
                encryptMsg += (char)(message.charAt(i)+key);
            }
            else if(message.charAt(i) == ' ')
            {
                encryptMsg += ' ';
            }
            else if((message.charAt(i)>='x' && message.charAt(i)>='z') || (message.charAt(i)>='X' && message.charAt(i)>='Z'))
            {
                encryptMsg += (char)(message.charAt(i)-(26-key));
            }
            
        }
        return encryptMsg;
    }

    public static String decryptCaesarKey(String message, int key) {
        String decryptMsg = "";
        for(int i=0; i<message.length(); i++)
        {
            if((message.charAt(i) >= 97+key || (message.charAt(i) >= 97+key && message.charAt(i) <= 'Z')) && message.charAt(i) != ' ')
            {
                decryptMsg += (char)(message.charAt(i)+key);
            }
            else if(message.charAt(i) == ' ')
            {
                decryptMsg += ' ';
            }
            else if((message.charAt(i)>='a' && message.charAt(i)>='c') || (message.charAt(i)>='A' && message.charAt(i)>='C'))
            {
                decryptMsg += (char)(message.charAt(i) - (26-key));
            }
            
        }
        return decryptMsg;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
