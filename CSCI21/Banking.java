public class Banking {
    public static void main(String[] args){
        Acct johnAcct = new Acct();

        System.out.println("John Initial: " + johnAcct.getBal());
        johnAcct.deposit(200.00);
        System.out.println("John Updated: " + johnAcct.getBal());
        
        johnAcct.withdraw(300.00);
        System.out.println("John Updated: " + johnAcct.getBal());
    }
}
