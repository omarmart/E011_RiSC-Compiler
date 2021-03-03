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
public class RiInstructionParserTest {
    private String instruction;
    private OperationCode opCode;
    private Register registerA;
    private int immediate;

    public RiInstructionParserTest(String instruction, OperationCode opCode, Register registerA, int immediate) {
        this.instruction = instruction;
        this.opCode = opCode;
        this.registerA = registerA;
        this.immediate = immediate;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> instructions() {
        Collection<Object[]> instructions = new ArrayList<>();
        instructions.add(new Object[] { "lui 1 17", OperationCode.LUI, Register.R1, 17 });
        instructions.add(new Object[] { "lui r2 23", OperationCode.LUI, Register.R2, 23 });

        return instructions;
    }

    @Test
    public void shouldParseRiInstruction() {
        InstructionParser parser = new InstructionParser();
        Instruction parsedInstruction = parser.parse(instruction);
        assertThat("Not an instance of RiInstruction", parsedInstruction, instanceOf(RiInstruction.class));

        RiInstruction riInstruction = (RiInstruction) parsedInstruction;
        assertEquals("Failed to parse opcode", riInstruction.getOpCode(), opCode);
        assertEquals("Failed to parse Register A", riInstruction.getRegisterA(), registerA);
        assertEquals("Failed to parse immediate", riInstruction.getImmediate(), immediate);
    }
}
