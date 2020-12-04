import java.util.Random;
import java.util.Scanner;

public class App {

    public static String flipCoin(){
        if(new Random().nextInt(2) == 0){ return "HEADS"; }
        return "TAILS";
    }

    public static void run(LinkedList list){

        String result = flipCoin();
        System.out.print("Last Result: " + result);
        LinkedList.insert(list, result);
        LinkedList.printList(list);
    }

    public static int getInput(){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Coins to be flipped (enter an integer, ex. 53): ");
            return sc.nextInt();
        } finally{
            sc.close();
        }
    }
    public static void clearBash() {  
        /*
        These are ANSI escape codes.
        \033 stands for ESC (ANSI value 27).
        ESC [ is a kind of escape sequence called Control Sequence Introducer (CSI).
        CSI commands starts with ESC[ followed by zero or more parameters.
        \033[H (ie, ESC[H) and \033[J are CSI codes.
        \033[H moves the cursor to the top left corner of the screen (ie, the first column of the first row in the screen).
        and
        \033[J clears the part of the screen from the cursor to the end of the screen.
        */
        System.out.print("\033[H\033[2J");
    }

    
    public static void main(String[] args) throws Exception {
        LinkedList llist = new LinkedList();

        int limit = getInput();
        for(int i = 0; i < limit; i++){
            System.out.println("Totally " + i + " coin(s) flipped.");
            run(llist);
            Thread.sleep(1000);
            clearBash();
        }
    }
}
