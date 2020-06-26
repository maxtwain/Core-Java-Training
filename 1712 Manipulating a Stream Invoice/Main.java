/*
Use the class Invoice provided in the exercises folder with this chapter's examples to create an array of Invoice objects.  Use the sample data shown in Fig 17.25.  Class Invoice includes four instance variables - a partNumber (type String), a partDescription (type String), a quantity of the item being purchased (type int), and a pricePerItem (type double), and corresponding get methods.  Perform the following queries on the array of Invoice objects and display the results:

A) Use streams to sort the Invoice objects by partDescription, then display the results.
B) Use streams to sort the Invoice objects by pricePerItem, then display the results.
C) Use streams to map each Invoice to its partDescription and quantity, sort the results by quantity, then display the results.
D) Use streams to map each Invoice to its partDescription and the value of the Invoice (i.e. quantity * pricePerItem).  Order the results by Invoice value.
E) Modify Part (d) to select the Invoice values in the range $200 to $500.
F) Find any one Invoice in which the partDescription contains the word "saw".

Fig. 17.25:
Part Number     Part Description     Quantity        Price
83              Electric Sander     7               57.98
24              Power saw           18              99.99
7               Sledge hammer       11              21.50
77              Hammer              76              11.99
39              Lawn Mower          3               79.50
68              Screwdriver         106             6.99
56              Jig saw             21              11.00
3               Wrench              34              7.50

 My notes:  I am not quite sure what it means to map an Invoice to its part number and quantity, but I am able to display a sorted stream of part numbers and matching quantities.
 */

import java.util.Arrays;
import java.util.Comparator;

class Main{
    public static void main(String[] args){
        Invoice[] invoiceArr = {
                new Invoice("83", "Electric sander", 7, 57.98),
                new Invoice("24", "Power saw", 18, 99.99),
                new Invoice("7", "Sledge hammer", 11, 21.50),
                new Invoice("77", "Hammer", 76, 11.99),
                new Invoice("39", "Lawn mower", 3, 79.50),
                new Invoice("68", "Screwdriver", 106, 6.99),
                new Invoice("56", "Jig saw", 21, 11.00),
                new Invoice("3", "Wrench", 34, 7.50)
        };

        partA(invoiceArr);
        partB(invoiceArr);
        partC(invoiceArr);
        partD(invoiceArr);
        partE(invoiceArr);
        partF(invoiceArr);
    }

    private static void partA(Invoice[] invoices){

        System.out.printf("%-13s%16s%10s%7s%n", "Part number", "Part description", "Quantity", "Price");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(invoice -> System.out.printf("%-13s%16s%10d%7.2f%n", invoice.getPartNumber(), invoice.getPartDescription(), invoice.getQuantity(), invoice.getPricePerItem()));
        System.out.println();
    }

    private static void partB(Invoice[] invoices){
        System.out.printf("%-13s%16s%10s%7s%n", "Part number", "Part description", "Quantity", "Price");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getPricePerItem))
                .forEach(invoice -> System.out.printf("%-13s%16s%10d%7.2f%n", invoice.getPartNumber(), invoice.getPartDescription(), invoice.getQuantity(), invoice.getPricePerItem()));
        System.out.println();
    }

    private static void partC(Invoice[] invoices){
        System.out.printf("%16s  %-9s%n", "Part description", "Quantity");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getQuantity))
                .forEach(invoice -> System.out.printf("%16s  %-9d%n", invoice.getPartDescription(), invoice.getQuantity()));
        System.out.println();
    }

    private static void partD(Invoice[] invoices){
        System.out.printf("%16s   %-7s%n", "Part description", "Value");
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getInvoiceAmount))
                .forEach(invoice -> System.out.printf("%16s  %7.2f%n", invoice.getPartDescription(), invoice.getInvoiceAmount()));
        System.out.println();
    }

    private static void partE(Invoice[] invoices){
        System.out.printf("%16s   %-7s%n", "Part description", "Value");
        Arrays.stream(invoices)
                .filter(invoice -> invoice.getInvoiceAmount() >= 200 && invoice.getInvoiceAmount() <= 500)
                .sorted(Comparator.comparing(Invoice::getInvoiceAmount))
                .forEach(invoice -> System.out.printf("%16s  %7.2f%n", invoice.getPartDescription(), invoice.getInvoiceAmount()));
        System.out.println();
    }

    private static void partF(Invoice[] invoices){
        System.out.printf("%-13s%16s%10s%7s%n", "Part number", "Part description", "Quantity", "Price");
        Arrays.stream(invoices)
                .filter(invoice -> invoice.getPartDescription().contains("saw"))
                .forEach(invoice -> System.out.printf("%-13s%16s%10d%7.2f%n", invoice.getPartNumber(), invoice.getPartDescription(), invoice.getQuantity(), invoice.getPricePerItem()));
        System.out.println();
    }
}