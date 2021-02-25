package com.omar;

public enum OperationCode {
    ADD(0b000, "add"), //
    ADDI(0b001, "addi"), //
    NAND(0b010, "nand"), //
    LUI(0b011, "lui"), //
    SW(0b101, "sw"), //
    LW(0b100, "lw"), //
    BEQ(0b110, "beq"), //
    JALR(0b111, "jalr");

    private int id;
    private String name;

    private OperationCode(int id, String name) {

    }
}