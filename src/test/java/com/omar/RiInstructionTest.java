package com.omar;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RiInstructionTest {
    @Test
    public void shouldConstruct() {
        RiInstruction inst = new RiInstruction(OperationCode.LUI, Register.R1, 2);

        assertEquals("Failed to set OperationCode", OperationCode.LUI, inst.getOpCode());
        assertEquals("Failed to set Register", Register.R1, inst.getRegisterA());
        assertEquals("Failed to set immediate", 2, inst.getImmediate());
    }

    @Test
    public void shouldParsetoHex() {
        RiInstruction inst = new RiInstruction(OperationCode.LUI, Register.R0, 7);
        byte[] instHex = inst.parseToHex();
        // 011 000 0000000111
        // 0110 0000 0000 0111
        //  6   0   0   7
        assertArrayEquals("Failed to parse to Hex", new byte[] { 0x60, 0x07 }, instHex);
    }

    @Test
    public void shouldParseToString() {
        RiInstruction inst = new RiInstruction(OperationCode.LUI, Register.R4, 11);
        String instString = inst.toString();
        assertEquals("Failed to parse to String", "lui r4 11", instString);
    }

    @Test(expected = InstructionFormatException.class)
    public void shouldThrowExceptionOnOutOfRangeImmediate() {
        new RiInstruction(OperationCode.LUI, Register.R3, 710);
    }
}
