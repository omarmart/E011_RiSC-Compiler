package com.omar;

public enum Register {

    R0(0), R1(1), R2(2), R3(3), R4(4), R5(5), R6(6), R7(7);

    private int value;

    private Register(int value) {
        this.value = value;
    }

}
