import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Formatter;

class FileMatch {

    FileMatch(){
        adjustExistingAccounts();
        logUnmatchedTransactions();
    }

    private void adjustExistingAccounts(){
        try{
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document inOldmast = documentBuilder.parse(new File("oldmast.xml"));
            Document inTrans = documentBuilder.parse(new File("trans.xml"));

            Document outNewmast = documentBuilder.newDocument();
            Element accountListElement = outNewmast.createElement("accountList");
            outNewmast.appendChild(accountListElement);

            // get first TransactionRecord object
            NodeList transactionList = inTrans.getChildNodes().item(0).getChildNodes();
            int transIndex = 0;
            NodeList transactionXML = transactionList.item(transIndex).getChildNodes();
            int transactionAccountNumber = Integer.parseInt(transactionXML.item(0).getTextContent());
            double transactionAmount = Double.parseDouble(transactionXML.item(1).getTextContent());
            TransactionRecord transactionRecord = new TransactionRecord(transactionAccountNumber, transactionAmount);

            NodeList accountList = inOldmast.getChildNodes().item(0).getChildNodes();
            for (int accIndex = 0; accIndex < accountList.getLength(); ++accIndex){

                // get next Account object
                NodeList accountXML = accountList.item(accIndex).getChildNodes();
                int accountNumber = Integer.parseInt(accountXML.item(0).getTextContent());
                double balance = Double.parseDouble(accountXML.item(1).getTextContent());
                String firstName = accountXML.item(2).getTextContent();
                String lastName = accountXML.item(3).getTextContent();
                Account account = new Account(accountNumber, firstName, lastName, balance);

                // advance through unmatching transaction records
                while (account.getAccountNumber() > transactionRecord.getAccountNumber() && transIndex < transactionList.getLength()){
                    ++transIndex;
                    transactionXML = transactionList.item(transIndex).getChildNodes();
                    transactionAccountNumber = Integer.parseInt(transactionXML.item(0).getTextContent());
                    transactionAmount = Double.parseDouble(transactionXML.item(1).getTextContent());
                    transactionRecord = new TransactionRecord(transactionAccountNumber, transactionAmount);
                }

                // combine matching transaction records
                while (account.getAccountNumber() == transactionRecord.getAccountNumber()){
                    account.combine(transactionRecord);
                    if (transIndex < transactionList.getLength()){
                        ++transIndex;
                        transactionXML = transactionList.item(transIndex).getChildNodes();
                        transactionAccountNumber = Integer.parseInt(transactionXML.item(0).getTextContent());
                        transactionAmount = Double.parseDouble(transactionXML.item(1).getTextContent());
                        transactionRecord = new TransactionRecord(transactionAccountNumber, transactionAmount);
                    }
                    else{
                        break;
                    }
                }

                // write Account to Document
                addAccount(outNewmast, accountListElement, new Account(account.getAccountNumber(), account.getFirstName(), account.getLastName(), account.getBalance()));
            }

            // write Document into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(outNewmast);
            StreamResult result = new StreamResult(new File("newmast.xml"));
            transformer.transform(source, result);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addAccount(Document doc, Element rootElement, Account account){
        Element accountElement = doc.createElement("account");
        rootElement.appendChild(accountElement);

        Element accountNumberElement = doc.createElement("accountNumber");
        accountNumberElement.appendChild(doc.createTextNode(String.valueOf(account.getAccountNumber())));
        accountElement.appendChild(accountNumberElement);

        Element balanceElement = doc.createElement("balance");
        balanceElement.appendChild(doc.createTextNode(String.format("%.2f", account.getBalance())));
        accountElement.appendChild(balanceElement);

        Element firstNameElement = doc.createElement("firstName");
        firstNameElement.appendChild(doc.createTextNode(account.getFirstName()));
        accountElement.appendChild(firstNameElement);

        Element lastNameElement = doc.createElement("lastName");
        lastNameElement.appendChild(doc.createTextNode(account.getLastName()));
        accountElement.appendChild(lastNameElement);
    }

    private void logUnmatchedTransactions(){
        try (Formatter outLog = new Formatter("log.txt")){

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document inOldmast = documentBuilder.parse(new File("oldmast.xml"));
            Document inTrans = documentBuilder.parse(new File("trans.xml"));

            // get first Account object
            NodeList accountList = inOldmast.getChildNodes().item(0).getChildNodes();
            int accIndex = 0;
            NodeList accountXML = accountList.item(accIndex).getChildNodes();
            int accountNumber = Integer.parseInt(accountXML.item(0).getTextContent());
            double balance = Double.parseDouble(accountXML.item(1).getTextContent());
            String firstName = accountXML.item(2).getTextContent();
            String lastName = accountXML.item(3).getTextContent();
            Account account = new Account(accountNumber, firstName, lastName, balance);

            NodeList transactionList = inTrans.getChildNodes().item(0).getChildNodes();
            for (int transIndex = 0; transIndex < transactionList.getLength(); ++transIndex){

                // get next Transaction object
                NodeList transactionXML = transactionList.item(transIndex).getChildNodes();
                int transactionAccountNumber = Integer.parseInt(transactionXML.item(0).getTextContent());
                double transactionAmount = Double.parseDouble(transactionXML.item(1).getTextContent());
                TransactionRecord transactionRecord = new TransactionRecord(transactionAccountNumber, transactionAmount);

                // advance through unmatching records
                while (account.getAccountNumber() < transactionRecord.getAccountNumber() && accIndex + 1 < accountList.getLength()){
                    ++accIndex;
                    accountXML = accountList.item(accIndex).getChildNodes();
                    accountNumber = Integer.parseInt(accountXML.item(0).getTextContent());
                    balance = Double.parseDouble(accountXML.item(1).getTextContent());
                    firstName = accountXML.item(2).getTextContent();
                    lastName = accountXML.item(3).getTextContent();
                    account = new Account(accountNumber, firstName, lastName, balance);
                }

                // write unmatched account to file
                if (account.getAccountNumber() != transactionRecord.getAccountNumber()){
                    outLog.format("Unmatched transaction record for account number %d%n", transactionRecord.getAccountNumber());
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
