package file_io_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Transaction{
    String transactionID;
    String customerID;
    double transactionAmount;
    LocalDate date;
    Transaction(String transactionID,String customerID,double transactionAmount,LocalDate date){
        this.transactionID=transactionID;
        this.customerID=customerID;
        this.transactionAmount=transactionAmount;
        this.date=date;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return transactionID+" "+customerID+" "+transactionAmount+" "+date;
    }
}

public class TransactionManagement {
    static ArrayList<Transaction>transactions=new ArrayList<>();

    private static void writeEmployeeToFile(String path_file,ArrayList<Transaction>transactions) {
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(path_file,true))){
            for(Transaction transaction:transactions){
                writer.write(transaction.toString());
                writer.write("\n");
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

    static void addTransaction(Scanner scanner){
        System.out.println("Enter the transaction Id");
        String transaction_id=scanner.next();
        System.out.println("Enter the Customer Id");
        String customer_id=scanner.next();
        System.out.println("Enter the amount");
        double amount=scanner.nextDouble();
        LocalDate date=LocalDate.now();
        transactions.add(new Transaction(transaction_id,customer_id,amount,date));
        writeEmployeeToFile("src/file_io_2/transactons.txt",transactions);
    }

    static void filterTransaction(Scanner scanner){
        System.out.println("Enter the a threshold");
        double threshhold=scanner.nextInt();
        ArrayList<Transaction>filteredtransactions=new ArrayList<>();
        for(Transaction transaction:transactions){
            if(transaction.getTransactionAmount()>threshhold){
                filteredtransactions.add(transaction);
            }
        }
        writeEmployeeToFile("src/file_io_2/filtered_transactions.txt",filteredtransactions);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int choice;
        do{
            System.out.println("Enter the choice");
            System.out.println("1.Add Transaction");
            System.out.println("2.Filter");
            System.out.println("3.exit");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    addTransaction(scanner);
                    break;
                case 2:
                    filterTransaction(scanner);
                    break;
                case 3:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("invalid input");
            }
        }while(choice<3);

    }
}
