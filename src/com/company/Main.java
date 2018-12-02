package com.company;

public class Main {

    public static void main(String[] args) {
        Matrix m1 = Matrix.create(3, 2, 4, 0, -2, 1, 3, -1, 0, 1);

        m1.show();


        Vector v3 = Vector.create(3, 1, 2, -1);

        v3.show();

        Vector v2 = v3.division_on_matrix(m1);
        v2.show();
        v2.addition(v3);
        v2.show();
    }
}
