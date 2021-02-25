package com.omar;

public class RrrInstruction implements Instruction {
    private OperationCode opCode;
    private Register registerA;
    private Register registerB;
    private Register registerC;

    public RrrInstruction(OperationCode opCode, Register registerA, Register registerB, Register registerC) {
        this.opCode = opCode;
        this.registerA = registerA;
        this.registerB = registerB;
        this.registerC = registerC;
    }

    @Override
    public String parseToHex() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}
