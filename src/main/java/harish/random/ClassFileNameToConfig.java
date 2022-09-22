package harish.random;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassFileNameToConfig {
    public static void main(String[] args) {
        String[] classFileNames = {"HawkeyeShipDivertListener.java", "ACLHawkeyeListener.java",
                "FulfillmentPlanListener.java",
                "FulfillmentRejectDataListener.java",
                "FulfilmentEventListener.java",
                "GlsEventListener.java",
                "HawkeyeShipDivertListener.java",
                "InventoryAdjustmentListener.java",
                "InventoryMoveEventListener.java",
                "OaaSListener.java",
                "RDCFulfillmentPlanListener.java",
                "RDCPickCancellationListener.java",
                "RDCPutawayRejectDataListener.java",
                "RDCShippingContainerConfirmationListener.java",
                "RDCSorterDivertListener.java",
                "RDCSymboticPutawayListener.java",
                "RFCFulfillmentPlanListener.java",
                "WitronFulfillmentConfirmationEventListener.java",
                "WitronInitialFulfillmentPlanListener.java",
                "WitronShippingContainerConfirmationListener.java",
                "PickUpdateListener.java",
                "YmsGateOutListener.java",
                "YmsLoadEventListener.java"};
        Arrays.stream(classFileNames).forEach(classFileName -> getConfigName(classFileName));
    }

    private static void getConfigName(String classFileName) {
        String[] camelCaseWords = classFileName
                .substring(0, classFileName.lastIndexOf('.'))
                .split("(?=[A-Z])");
        List<String> lowerCaseWords = Arrays.stream(camelCaseWords).map(camelCaseWord -> camelCaseWord.toLowerCase()).collect(Collectors.toList());
        String configName = "listener-config["+String.join(".", lowerCaseWords) + ".enabled]";
        System.out.println(configName);
    }
}
