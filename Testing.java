import java.util.Scanner;

public class Testing {
    int x = 0;
    public static void main(String[] args) {
        int y, z = 0;
        
        Testing test = new Testing();
        System.out.println(test.x);

        Scanner scan = new Scanner(System.in);
        y = scan.nextInt();
        System.out.println(y);
        z = scan.nextInt();
        System.out.println(z);
        scan.close();

        char letter = 'c';
        String imText = String.valueOf(letter);
        System.out.println(imText);

        CalledProgram callP = new CalledProgram();
        callP.Addition(5, 20);
        callP.Addition(65, 987);
        callP.Addition(4, 12);
        
        callP.displayTotalSum();
    }
}

