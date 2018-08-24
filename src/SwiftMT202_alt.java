import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2;
import com.prowidesoftware.swift.model.SwiftBlock2Input;
import com.prowidesoftware.swift.model.SwiftBlock3;
import com.prowidesoftware.swift.model.mt.mt2xx.MT202;

public class SwiftMT202_alt {
    public static void main(String [] args){

        MT202 mt202 = new MT202();

        SwiftBlock1 swiftBlock1 = new SwiftBlock1();
        swiftBlock1.setSender("COPZBEB0AXXX");

        SwiftBlock2 swiftBlock2 = new SwiftBlock2Input();
        ((SwiftBlock2Input) swiftBlock2).setReceiver("BANKDEFFXXXX");
        swiftBlock2.setMessageType("202");
        ((SwiftBlock2Input) swiftBlock2).setDeliveryMonitoring("1");
        ((SwiftBlock2Input) swiftBlock2).setObsolescencePeriod("020");

        SwiftBlock3 swiftBlock3 = new SwiftBlock3();
        swiftBlock3.generateMUR(false);
        swiftBlock3.



        mt202.getSwiftMessage().setBlock1(swiftBlock1);
        mt202.getSwiftMessage().setBlock2(swiftBlock2);
        mt202.getSwiftMessage().setBlock3(swiftBlock3);

        printline(mt202.message());

    }

    private static void printline(String message){
        System.out.println(message);
    }
}
