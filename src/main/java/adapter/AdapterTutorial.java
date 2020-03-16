package adapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterTutorial {
    public static void main(String[] args) {
        PrinterInterface printer = new PrinterComp(new Printer());
        printer.consolePrint();

        List<PrinterInterface> printerInterfaces = new ArrayList<>();
        for (int i = 0; i < printerInterfaces.size(); i++) {
            printerInterfaces.get(i).consolePrint();
        }
    }
}
