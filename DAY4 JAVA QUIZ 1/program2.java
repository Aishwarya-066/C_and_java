package javapro;

public class program2 {
    public static void main(String[] args) {
   
        SavingsAccount savings = new SavingsAccount(1000.0);
        CheckingAccount checking = new CheckingAccount(500.0);
        LoanAccount loan = new LoanAccount(-2000.0, 0.05); 

      
        savings.deposit(5500.0);
        checking.withdraw(200.0);
        loan.deposit(1000.0); 

        System.out.println("Savings balance: " + savings.getBalance());
        System.out.println("Checking balance: " + checking.getBalance());
        System.out.println("Loan balance: " + Math.abs(loan.getBalance()));
    }
}
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}
abstract class AbstractAccount implements Account {
    private double balance;

    public AbstractAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
class SavingsAccount extends AbstractAccount {
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

}

class CheckingAccount extends AbstractAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }
}

class LoanAccount extends AbstractAccount {
    private double interestRate;

    public LoanAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }
}

//OUTPUT:
//
//run:
//Savings balance: 6500.0
//Checking balance: 300.0
//Loan balance: 1000.0
//BUILD SUCCESSFUL (total time: 0 seconds)
