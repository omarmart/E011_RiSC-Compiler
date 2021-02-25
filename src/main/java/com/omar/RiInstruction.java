package com.omar;

public class RiInstruction implements Instruction {
    private final OperationCode opCode;
    private final Register registerA;
    private final int immediate;

    public RiInstruction(OperationCode opCode, Register registerA, int immediate) {
        this.opCode = opCode;
        this.registerA = registerA;
        this.immediate = immediate;
    }

    @Override
    public byte[] parseToHex() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

    public OperationCode getOpCode() {
        return opCode;
    }

    public Register getRegisterA() {
        return registerA;
    }

    public int getImmediate() {
        return immediate;
    }

}
