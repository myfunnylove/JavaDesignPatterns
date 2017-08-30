package com.khasanov.FlyweightPattern;

import java.awt.*;

public class Tree {

    private int x;
    private int y;
    private TreeType treeType;

    public Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void draw(Graphics g){
        treeType.draw(x,y,g);
    }
}
