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
public class RriInstructionParserTest {

    private String instruction;
    private OperationCode opCode;
    private Register registerA;
    private Register registerB;
    private int immediate;

    public RriInstructionParserTest(String instruction, OperationCode opCode, Register registerA, Register registerB,
            int immediate) {
        this.instruction = instruction;
        this.opCode = opCode;
        this.registerA = registerA;
        this.registerB = registerB;
        this.immediate = immediate;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> instructions() {
        //devuelve distintos casos de test
        Collection<Object[]> instructions = new ArrayList<>();
        instructions.add(new Object[] { "addi 3 2 1", OperationCode.ADDI, Register.R3, Register.R2, 1 });
        instructions.add(new Object[] { "sw r1 r3 32", OperationCode.SW, Register.R1, Register.R3, 32 });
        instructions.add(new Object[] { "lw 1 r5 60", OperationCode.LW, Register.R1, Register.R5, 60 });
        instructions.add(new Object[] { "beq r4 2 51", OperationCode.BEQ, Register.R4, Register.R2, 51 });

        return instructions;
    }

    @Test
    public void shouldParseRriInstruction() {
        InstructionParser parser = new InstructionParser();
        Instruction parsedInstruction = parser.parse(instruction);
        assertThat("Not an instance of RriInstruction", parsedInstruction, instanceOf(RriInstruction.class));

        RriInstruction rriInstruction = (RriInstruction) parsedInstruction;
        assertEquals("Failed to parse opcode", rriInstruction.getOpCode(), opCode);
        assertEquals("Failed to parse Register A", rriInstruction.getRegisterA(), registerA);
        assertEquals("Failed to parse Register B", rriInstruction.getRegisterB(), registerB);
        assertEquals("Failed to parse immediate", rriInstruction.getImmediate(), immediate);
    }
}
