package com.omar;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RrrInstructionTest {
    @Test
    public void shouldConstruct() {
        RrrInstruction inst = new RrrInstruction(OperationCode.ADD, Register.R7, Register.R6, Register.R5);

        assertEquals("Failed to set OperationCode", OperationCode.ADD, inst.getOpCode());
        assertEquals("Failed to set RegisterA", Register.R7, inst.getRegisterA());
        assertEquals("Failed to set RegisterB", Register.R6, inst.getRegisterB());
        assertEquals("Failed to set immediate", Register.R5, inst.getRegisterC());
    }

    @Test
    public void shouldParsetoHex() {
        RrrInstruction inst = new RrrInstruction(OperationCode.NAND, Register.R2, Register.R5, Register.R3);
        byte[] instHex = inst.parseToHex();
        // 010 010 101 0000 011
        // 0100 1010 1000 0011
        //  4   A   8   3
        assertArrayEquals("Failed to parse to Hex", new byte[] { (byte) 0x4A, (byte) 0x83 }, instHex);
    }

    @Test
    public void shouldParseToString() {
        RrrInstruction inst = new RrrInstruction(OperationCode.ADD, Register.R3, Register.R2, Register.R1);
        String instString = inst.toString();
        assertEquals("Failed to parse to String", "add r3 r2 r1", instString);
    }
}
