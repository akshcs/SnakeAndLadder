package com.example.LLD.entity;

import com.example.LLD.entity.intf.Entity;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int cellCount;
    private Map<Integer, Entity> entityMap;

    public Entity getEntity(int pos) {
        if(entityMap.containsKey(pos)){
            return entityMap.get(pos);
        }
        return null;
    }

    public void addEntity(Entity entity) {
        entityMap.put(entity.getStart(), entity);
    }

    public Board(int cellCount) {
        this.cellCount = cellCount;
        entityMap = new HashMap<>();
    }
    public boolean isLadderOrSnake(int pos){
        return entityMap.containsKey(pos);
    }
    public boolean isOutsideBoard(int pos){
        return (pos > cellCount);
    }
}
