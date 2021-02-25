package com.omar;

import java.nio.FloatBuffer;
import java.util.List;
import java.util.Map;

public class AssemblyCode {
    private List<Instruction> instructions;
    private Map<String, Integer> labels;

    public AssemblyCode() {

    }

    public static AssemblyCode fromFile(String location) {
        return new AssemblyCode();
    }

    /**
     * 
     */
    public void addInstruction(Instruction instruction) {

    }

    public void setLabel(String labelName, int position) {

    }

    public List<String> parseToStringList() {
        return null;
    }

}