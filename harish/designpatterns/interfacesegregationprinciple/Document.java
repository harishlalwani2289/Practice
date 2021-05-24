package practice.harish.designpatterns.interfacesegregationprinciple;

public class Document {
}

interface Machine {
    void printDocument(Document d);

    void fax(Document d);

    void scan(Document d);
}

class MultiFunctionalPrinter implements Machine {

    @Override
    public void printDocument(Document d) {
        //
    }

    @Override
    public void fax(Document d) {
        //
    }

    @Override
    public void scan(Document d) {
        //
    }
}

class OldFashionedPrinter implements Machine {

    @Override
    public void printDocument(Document d) {
        //
    }

    @Override
    public void fax(Document d) {
        // We don't need this
    }

    @Override
    public void scan(Document d) {
        // We don't need this
    }
}

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}

// YAGNI -- You ain't going to need it
class JustAPrinter implements Printer {

    @Override
    public void print(Document d) {
    //
    }
}

class PhotoCopier implements Printer,Scanner {

    @Override
    public void print(Document d) {
        // Meaningful
    }

    @Override
    public void scan(Document d) {
        // Meaningful
    }
}

interface MultiFunctinalDevice extends  Printer, Scanner {
}

class MultiFunctionalMachine implements  MultiFunctinalDevice {


    private Printer printer;
    private Scanner scanner;

    public MultiFunctionalMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }


    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}
