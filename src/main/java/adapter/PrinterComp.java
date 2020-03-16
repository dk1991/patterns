package adapter;

public class PrinterComp implements PrinterInterface {

    private final Printer printer;

    public PrinterComp(Printer printer) {
        this.printer = printer;
    }

    public void consolePrint() {
        printer.print();
    }
}
