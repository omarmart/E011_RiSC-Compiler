package com.omar;

public class RrrInstruction implements Instruction {
    private final OperationCode opCode;
    private final Register registerA;
    private final Register registerB;
    private final Register registerC;

    public RrrInstruction(OperationCode opCode, Register registerA, Register registerB, Register registerC) {
        this.opCode = opCode;
        this.registerA = registerA;
        this.registerB = registerB;
        this.registerC = registerC;
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

    public Register getRegisterC() {
        return registerC;
    }

}
