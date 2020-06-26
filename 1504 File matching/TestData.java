import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;

class TestData {

    TestData() {
        try (Formatter toOldmast = new Formatter("oldmast.txt")) {

            writeAccount(toOldmast, new Account(100, "Alan", "Jones", 348.17));
            writeAccount(toOldmast, new Account(300, "Mary", "Smith", 27.19));
            writeAccount(toOldmast, new Account(500, "Sam", "Sharp", 0.00));
            writeAccount(toOldmast, new Account(700, "Suzy", "Green", -14.22));

        } catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
            e.printStackTrace();
        }

        try (Formatter toTrans = new Formatter("trans.txt")) {

            writeTrans(toTrans, new TransactionRecord(100, 27.14));
            writeTrans(toTrans, new TransactionRecord(300, 62.11));
            writeTrans(toTrans, new TransactionRecord(400, 100.56));
            writeTrans(toTrans, new TransactionRecord(900, 82.17));

        } catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
            e.printStackTrace();
        }
    }


    private static void writeAccount(Formatter formatterOutput, Account account){
        formatterOutput.format("%d %s %s %.2f%n", account.getAccountNumber(), account.getFirstName(), account.getLastName(), account.getBalance());
    }

    private static void writeTrans(Formatter formatterOutput, TransactionRecord transactionRecord){
        formatterOutput.format("%d %.2f%n", transactionRecord.getAccountNumber(), transactionRecord.getTransactionAmount());
    }
}
