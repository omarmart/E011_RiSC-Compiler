package com.omar;

import java.rmi.server.Operation;

public class RiInstruction implements Instruction {
    private OperationCode opCode;
    private Register registerA;
    private int immediate;

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

}
