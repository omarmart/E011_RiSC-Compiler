package com.omar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RrrInstructionParserTest {
    private String instruction;
    private OperationCode opCode;
    private Register registerA;
    private Register registerB;
    private Register registerC;

    public RrrInstructionParserTest(String instruction, OperationCode opCode, Register registerA, Register registerB,
            Register registerC) {
        this.instruction = instruction;
        this.opCode = opCode;
        this.registerA = registerA;
        this.registerB = registerB;
        this.registerC = registerC;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> instructions() {
        //devuelve distintos casos de test
        Collection<Object[]> instructions = new ArrayList<>();
        instructions.add(new Object[] { "add 1 7 3", OperationCode.ADD, Register.R1, Register.R7, Register.R3 });
        instructions.add(new Object[] { "nand r2 r6 r4", OperationCode.NAND, Register.R2, Register.R6, Register.R4 });
        instructions.add(new Object[] { "nand r5 4 r2", OperationCode.NAND, Register.R5, Register.R4, Register.R2 });

        return instructions;
    }

    @Test
    public void shouldParseRrrInstruction() {
        InstructionParser parser = new InstructionParser();
        Instruction parsedInstruction = parser.parse(instruction);
        assertThat("Not an instance of RrrInstruction", parsedInstruction, instanceOf(RrrInstruction.class));

        RrrInstruction rrrInstruction = (RrrInstruction) parsedInstruction;
        assertEquals("Failed to parse opcode", rrrInstruction.getOpCode(), opCode);
        assertEquals("Failed to parse Register A", rrrInstruction.getRegisterA(), registerA);
        assertEquals("Failed to parse Register B", rrrInstruction.getRegisterB(), registerB);
        assertEquals("Failed to parse Register C", rrrInstruction.getRegisterC(), registerC);
    }
}
