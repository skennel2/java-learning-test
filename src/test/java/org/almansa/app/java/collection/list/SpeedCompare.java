package org.almansa.app.java.collection.list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import org.junit.Test;

public class SpeedCompare {
    //@Test
    public void ArrayList의_초기사이즈를_지정해주었을때_속도비교() {
        ArrayList<String> arrayList = new ArrayList<>(50000000);

        for (int i = 0; i < 50000000; i++) {
            arrayList.add(new Integer(i).toString());
        }

        assertEquals(50000000, arrayList.size());
    }

    //@Test
    public void ArrayList에_초기사이즈를_지정하지않았을때_속도비교() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 50000000; i++) {
            arrayList.add(new Integer(i).toString());
        }

        assertEquals(50000000, arrayList.size());
    }
    
    //@Test
    public void Vector의_초기사이즈를_지정해주었을때_속도비교() {
        Vector<String> arrayList = new Vector<>(5000000);

        for (int i = 0; i < 5000000; i++) {
            arrayList.add(new Integer(i).toString());
        }

        assertEquals(5000000, arrayList.size());
    }

    //@Test
    public void Vector에_초기사이즈를_지정하지않았을때_속도비교() {
        Vector<String> arrayList = new Vector<>();
        for (int i = 0; i < 5000000; i++) {
            arrayList.add(new Integer(i).toString());
        }

        assertEquals(5000000, arrayList.size());
    }    

    //@Test
    public void LinkedList_속도비교() {
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 50000000; i++) {
            linkedList.add(new Integer(i).toString());
        }

        linkedList.get(49999999);
    }

    //@Test
    public void ArrayList_속도비교() {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 50000000; i++) {
            arrayList.add(new Integer(i).toString());
        }

        arrayList.get(49999999);
    }
}
