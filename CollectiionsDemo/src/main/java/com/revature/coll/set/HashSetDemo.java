package com.revature.coll.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet();

        s1.add("Raagul");
        s1.add("Sneha");
        s1.add("Raagul");
        s1.add("Udhaya");

        //System.out.println(s1);
        Iterator itr = s1.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
