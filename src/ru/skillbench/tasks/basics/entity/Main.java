package ru.skillbench.tasks.basics.entity;


import ru.skillbench.tasks.basics.math.ArrayVectorImpl;

public class Main {
    public static void main(String[] args) {
        ArrayVectorImpl arrayVector = new ArrayVectorImpl();
        ArrayVectorImpl arrayVector1 = new ArrayVectorImpl();
        arrayVector.set(3.0, 12.0, 2.0, 4.0, 5.0);
        arrayVector1.set(2.0, 2.0, 5.0);

        double d = arrayVector.getNorm();
        System.out.println(d);
    }
}

