package com.example.LLD.entity.impl;

import com.example.LLD.entity.intf.Entity;

public class Ladder implements Entity {

    private final int end;
    private final int start;

    public Ladder(int start, int end) {
        this.end = end;
        this.start = start;
    }

    @Override
    public int getStart() {
        return start;
    }

    @Override
    public int getEnd() {
        return end;
    }
}
