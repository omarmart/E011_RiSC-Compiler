package com.omar;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RriInstructionTest {
    @Test
    public void shouldConstruct() {
        RriInstruction inst = new RriInstruction(OperationCode.ADDI, Register.R7, Register.R6, 37);

        assertEquals("Failed to set OperationCode", OperationCode.ADDI, inst.getOpCode());
        assertEquals("Failed to set RegisterA", Register.R7, inst.getRegisterA());
        assertEquals("Failed to set RegisterB", Register.R6, inst.getRegisterB());
        assertEquals("Failed to set immediate", 37, inst.getImmediate());
    }

    @Test
    public void shouldParsetoHex() {
        RriInstruction inst = new RriInstruction(OperationCode.SW, Register.R5, Register.R4, 2);
        byte[] instHex = inst.parseToHex();
        // 100 101 100 0000010
        // 1001 0110 0000 0010
        //  9   6   0   2
        assertArrayEquals("Failed to parse to Hex", new byte[] { (byte) 0x96, 0x02 }, instHex);
    }

    @Test
    public void shouldParseToString() {
        RriInstruction inst = new RriInstruction(OperationCode.LW, Register.R6, Register.R3, 8);
        String instString = inst.toString();
        assertEquals("Failed to parse to String", "lw r6 r3 8", instString);
    }

    @Test(expected = InstructionFormatException.class)
    public void shouldThrowExceptionOnOutOfRangeImmediate() {
        new RriInstruction(OperationCode.BEQ, Register.R1, Register.R2, 820);
    }
}
