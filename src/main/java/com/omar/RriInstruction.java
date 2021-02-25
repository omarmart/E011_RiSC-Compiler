package com.omar;

public class RriInstruction implements Instruction {
    private final OperationCode opCode;
    private final Register registerA;
    private final Register registerB;
    private final int immediate;

    public RriInstruction(OperationCode opCode, Register registerA, Register registerB, int immediate) {
        this.opCode = opCode;
        this.registerA = registerA;
        this.registerB = registerB;
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

    public Register getRegisterB() {
        return registerB;
    }

    public int getImmediate() {
        return immediate;
    }

}
