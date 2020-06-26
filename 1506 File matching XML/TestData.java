
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

class TestData {
    TestData() {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element accountListElement = doc.createElement("accountList");
            doc.appendChild(accountListElement);

            addAccount(doc, accountListElement, new Account(100, "Alan", "Jones", 348.17));
            addAccount(doc, accountListElement, new Account(300, "Mary", "Smith", 27.19));
            addAccount(doc, accountListElement, new Account(500, "Sam", "Sharp", 0.00));
            addAccount(doc, accountListElement, new Account(700, "Suzy", "Green", -14.22));

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("oldmast.xml"));
            transformer.transform(source, result);

        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element transactionListElement = document.createElement("transactionList");
            document.appendChild(transactionListElement);

            addTransaction(document, transactionListElement, new TransactionRecord(100, 27.14));
            addTransaction(document, transactionListElement, new TransactionRecord(300, 62.11));
            addTransaction(document, transactionListElement, new TransactionRecord(300, 83.89));
            addTransaction(document, transactionListElement, new TransactionRecord(400, 100.56));
            addTransaction(document, transactionListElement, new TransactionRecord(700, 80.76));
            addTransaction(document, transactionListElement, new TransactionRecord(700, 1.53));
            addTransaction(document, transactionListElement, new TransactionRecord(900, 82.17));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("trans.xml"));
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
        balanceElement.appendChild(doc.createTextNode(String.valueOf(account.getBalance())));
        accountElement.appendChild(balanceElement);

        Element firstNameElement = doc.createElement("firstName");
        firstNameElement.appendChild(doc.createTextNode(account.getFirstName()));
        accountElement.appendChild(firstNameElement);

        Element lastNameElement = doc.createElement("lastName");
        lastNameElement.appendChild(doc.createTextNode(account.getLastName()));
        accountElement.appendChild(lastNameElement);
    }

    private void addTransaction(Document document, Element rootElement, TransactionRecord transactionRecord){
        Element transactionElement = document.createElement("transaction");
        rootElement.appendChild(transactionElement);

        Element accountNumberElement = document.createElement("accountNumber");
        accountNumberElement.appendChild(document.createTextNode(String.valueOf(transactionRecord.getAccountNumber())));
        transactionElement.appendChild(accountNumberElement);

        Element transactionAmountElement = document.createElement("transactionAmount");
        transactionAmountElement.appendChild(document.createTextNode(String.valueOf(transactionRecord.getTransactionAmount())));
        transactionElement.appendChild(transactionAmountElement);
    }
}
