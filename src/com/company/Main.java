package com.company;

public class Main {

    public static void main(String[] args) {
        Matrix m1 = Matrix.create(3, 2, 3, 0, -2, 1, 3, -1, 0, 1);
        Matrix m2 = Matrix.create(3, 2, 4, 0, -2, 1, 3, -1, 0, 1);
        m1.show();
        System.out.println("");
        m1.transpose();
        m1.show();

       // 2 -2 -1
       // 3 1 0
       // 0 3 1
    }
}
