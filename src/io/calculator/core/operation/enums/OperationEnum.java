package io.calculator.core.operation.enums;

public enum OperationEnum {

        ADD("[+]"),
        DIVIDE("[/]"),
        MULTIPLY("[*]"),
        SUBTRACT("[-]");

    private OperationEnum(String regExp) {
        this.regExp = regExp;
    }

    private String regExp;

    public String getRegExp() {
        return regExp;
    }

}
