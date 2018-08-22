package org.almansa.app.java.objectcompare;

import java.util.Comparator;

import testobject.Fruit;

public class FruitPriceComparator implements Comparator<Fruit>{

    @Override
    public int compare(Fruit o1, Fruit o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
    
}
