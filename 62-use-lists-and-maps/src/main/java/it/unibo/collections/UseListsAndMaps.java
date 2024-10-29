package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    static private final int RANGE_INITIAL_VALUE = 1000;
    static private final int RANGE_FINAL_VALUE = 2000;
    static private final int NUM_ELEMENT_TO_ADD = 100_000;
    static private final int TYMES_TO_READ_MIDDLE_ELEMENT = 1000;

    static private final long EUROPE_POPULATION = 742_452_000;
    static private final long ASIA_POPULATION = 4_298_723_000L;
    static private final long AMERICA_POPULATION = 972_005_000;
    static private final long OCEANIA_POPULATION = 38_304_000;
    static private final long ANTARTICA_POPULATION = 0;
    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */


        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
        final List<Integer> arrayList = new ArrayList<>();
        for(int i = RANGE_INITIAL_VALUE; i < RANGE_FINAL_VALUE; i++){
            arrayList.add(i);
        }

        final List<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(arrayList);

        int tempSwapVariable = arrayList.get(arrayList.size() - 1);
        arrayList.set(arrayList.size() - 1, arrayList.get(0));
        arrayList.set(0, tempSwapVariable);

        for(final var elem : arrayList){
            System.out.println(elem);
        }

        long time = System.nanoTime();
        for(int i = 0; i < NUM_ELEMENT_TO_ADD; i++){
            arrayList.addFirst(i);
        }
        time = System.nanoTime() - time;
        System.out.println("Time to insert " + NUM_ELEMENT_TO_ADD + " in a array list is " + TimeUnit.NANOSECONDS.toMillis(time) + " milliseconds");
        
        time = System.nanoTime();
        for(int i = 0; i < NUM_ELEMENT_TO_ADD; i++){
            linkedList.addFirst(i);
        }
        time = System.nanoTime() - time;
        System.out.println("Time to insert " + NUM_ELEMENT_TO_ADD + " in a linked list is " + TimeUnit.NANOSECONDS.toMillis(time) + " milliseconds");

        time = System.nanoTime();
        for(int i = 0; i < TYMES_TO_READ_MIDDLE_ELEMENT; i++){
            arrayList.get(arrayList.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Time to read " + TYMES_TO_READ_MIDDLE_ELEMENT + " times the middle element in a array list is " + TimeUnit.NANOSECONDS.toMillis(time) + " milliseconds");
        time = System.nanoTime();
        for(int i = 0; i < TYMES_TO_READ_MIDDLE_ELEMENT; i++){
            linkedList.get(arrayList.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Time to read " + TYMES_TO_READ_MIDDLE_ELEMENT + " times the middle element in a linked list is " + TimeUnit.NANOSECONDS.toMillis(time) + " milliseconds");

        final Map<String, Long> continenMap = new HashMap<>();
        continenMap.put("Americas", AMERICA_POPULATION);
        continenMap.put("Europe", EUROPE_POPULATION);
        continenMap.put("Asia", ASIA_POPULATION);
        continenMap.put("Antartica", ANTARTICA_POPULATION);
        continenMap.put("Oceania", OCEANIA_POPULATION);

        long worldPopulation = 0;
        for(final String continent : continenMap.keySet()){
            worldPopulation = worldPopulation + continenMap.get(continent);
        }
        System.out.println("World population is up to: " + worldPopulation + " people");

    }
}
