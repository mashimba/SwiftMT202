import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.mt2xx.MT202;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Currency;

public class ClassMT202 {

    private static final String FILENAME = "output.out";

    public static void main(String[] args) {

        String senderAddress = "UBPHPHMMXXX";
        String receiverAddress = "PHSBPHMMXXX";
        String transactionRef = "UBPH01060001";
        String relatedRef = "NONREF";
        String amount = "100000000";
        String beneficiaryInstitution = "PHSBPHMMXXX";
        String senderToReceiverInfo = "/TBB/TD INVESTMENT";

        final MT202 mt202 = new MT202();

        /**
         * Mandatory fields in MT202
         */
        mt202.setSender(senderAddress);
        mt202.setReceiver(receiverAddress);

        Field20 field20 = new Field20()
                .setReference(transactionRef);
        mt202.addField(field20);

        Field21 field21 = new Field21()
                .setReference(relatedRef);
        mt202.addField(field21);

        Field32A field32A = new Field32A()
                .setAmount(amount)
                .setCurrency(Currency.getInstance("PHP"))
                .setDate(Calendar.getInstance());
        mt202.addField(field32A);


        Field58A field58A = new Field58A()
                .setBIC(beneficiaryInstitution);
        mt202.addField(field58A);

        /**
         * </ mandatory fields in MT202
         */

        //Optional fields
        Field72 field72 = new Field72()
                .setComponent1(senderToReceiverInfo);
        mt202.addField(field72);

        printline(mt202.message());

        fileWriter(mt202.message());



    }

    //creating file into directory
    private static void fileWriter(String message) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;

        File fileDirectory = new File("output");

        if (!fileDirectory.exists()) {
            fileDirectory.mkdir();
        } else {
            printline("Directory exists!!");
        }

        try {
            fileWriter = new FileWriter(fileDirectory + File.separator + FILENAME);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(message);
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printline(String message) {
        System.out.println(message);
    }


}
