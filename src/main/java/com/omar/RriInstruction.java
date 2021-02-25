package com.omar;

public class RriInstruction implements Instruction {
    private OperationCode opCode;
    private Register registerA;
    private Register registerB;
    private int immediate;

    public RriInstruction(OperationCode opCode, Register registerA, Register registerB, int immediate) {
        this.opCode = opCode;
        this.registerA = registerA;
        this.registerB = registerB;
        this.immediate = immediate;
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
