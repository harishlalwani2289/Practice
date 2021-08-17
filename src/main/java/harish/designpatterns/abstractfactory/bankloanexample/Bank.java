package harish.designpatterns.abstractfactory.bankloanexample;

public interface Bank {
    public String getBankName();
}

class HDFCBank implements Bank {

    String bankName;

    public HDFCBank() {
        this.bankName = "HDFC";
    }

    @Override
    public String getBankName() {
        return bankName;
    }
}

class ICICIBank implements Bank {

    String bankName;

    public ICICIBank() {
        this.bankName = "ICICI";
    }

    @Override
    public String getBankName() {
        return bankName;
    }
}

class SBIBank implements Bank {

    String bankName;

    public SBIBank() {
        this.bankName = "SBI";
    }

    @Override
    public String getBankName() {
        return bankName;
    }
}
