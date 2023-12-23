package com.revature.coll.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList();

        l1.add("Raagul");
        l1.add("Sneha");
        l1.add("Udhaya");
        l1.add("Hari");
        l1.add("Janani");

        Iterator itr = l1.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        for(int i=0; i<l1.size(); i++){
            System.out.println(l1.get(i));
        }

        for(String s1:l1){
            System.out.println(s1);
        }

        l1.remove("Raagul");
        l1.remove(2);
    }
}
