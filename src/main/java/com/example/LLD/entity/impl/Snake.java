package com.example.LLD.entity.impl;

import com.example.LLD.entity.intf.Entity;

public class Snake implements Entity {
    public Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }
    private final int start;
    private final int end;
    @Override
    public int getEnd() {
        return this.end;
    }
    @Override
    public int getStart() {
        return this.start;
    }
}
