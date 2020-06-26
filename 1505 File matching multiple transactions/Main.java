/*
It's possible (and actually common) to have several transaction records with the same record key.  This situation occurs, for example, when a customer makes several purchases and cash payments during a business period.  Rewrite your accounts receivable file matching program from Exercise 15.4 to provide for the possibility of handling several transaction records with the same record key.  Modify the test data of CreateData.java to include the additional transaction records in Fig. 15.18.

Fig 15.18: Additional transaction records
Account number; Dollar amount;
300 83.89
700 80.78
700 1.53
 */

class Main{
    public static void main(String[] args){
        TestData testData = new TestData();
        FileMatch fileMatch = new FileMatch();
    }
}