import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

class FileMatch {

    FileMatch(){
        adjustExistingAccounts();
        logUnmatchedTransactions();
    }

    private void adjustExistingAccounts(){
        try(Scanner inputOldmast = new Scanner(Paths.get("oldmast.txt"));
            Scanner inputTrans = new Scanner(Paths.get("trans.txt"));
            Formatter outputNewmast = new Formatter("newmast.txt");
        ){

            TransactionRecord transactionRecord = new TransactionRecord(inputTrans.nextInt(), inputTrans.nextDouble());
            while (inputOldmast.hasNext()){
                Account account = new Account(inputOldmast.nextInt(), inputOldmast.next(), inputOldmast.next(), inputOldmast.nextDouble());
                // advance through unmatching transaction records
                while (account.getAccountNumber() > transactionRecord.getAccountNumber() && inputTrans.hasNext()){
                    transactionRecord = new TransactionRecord(inputTrans.nextInt(), inputTrans.nextDouble());
                }
                // combine matching transaction records
                while (account.getAccountNumber() == transactionRecord.getAccountNumber()){
                    account.combine(transactionRecord);
                    if (inputTrans.hasNext()){
                        transactionRecord = new TransactionRecord(inputTrans.nextInt(), inputTrans.nextDouble());
                    }
                    else{
                        break;
                    }
                }

                outputNewmast.format("%d %s %s %.2f%n", account.getAccountNumber(), account.getFirstName(), account.getLastName(), account.getBalance());

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void logUnmatchedTransactions(){
        try(Scanner inputOldmast = new Scanner(Paths.get("oldmast.txt"));
            Scanner inputTrans = new Scanner(Paths.get("trans.txt"));
            Formatter outputLog = new Formatter("log.txt")
        ){
            Account account = new Account(inputOldmast.nextInt(), inputOldmast.next(), inputOldmast.next(), inputOldmast.nextDouble());
            while (inputTrans.hasNext()){
                TransactionRecord transactionRecord = new TransactionRecord(inputTrans.nextInt(), inputTrans.nextDouble());
                while (transactionRecord.getAccountNumber() > account.getAccountNumber() && inputOldmast.hasNext()){
                    account = new Account(inputOldmast.nextInt(), inputOldmast.next(), inputOldmast.next(), inputOldmast.nextDouble());
                }
                if (account.getAccountNumber() != transactionRecord.getAccountNumber()){
                    outputLog.format("Unmatched transaction record for account number %d%n", transactionRecord.getAccountNumber());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
