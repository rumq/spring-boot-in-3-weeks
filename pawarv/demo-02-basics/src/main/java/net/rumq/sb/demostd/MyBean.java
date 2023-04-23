package net.rumq.sb.demostd;

public class MyBean {
    private String field1;
    private String field2;

    public void setField1(String f1) {
        this.field1 = f1;

    }

    public void setField2(String f2) {
        this.field2 = f2;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "MYBEAN: " + field1 + " " + field2 + "";
    }

}
