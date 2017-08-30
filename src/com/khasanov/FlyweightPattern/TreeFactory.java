package com.khasanov.FlyweightPattern;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {

    static Map<String,TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color,String otherData){

        TreeType treeType = treeTypes.get(name);

        if (treeType == null){

            treeType = new TreeType(name,color,otherData);
            treeTypes.put(name,treeType);
            System.out.println("Cached tree....");
        }

        return treeType;
    }
}
