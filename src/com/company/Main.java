package com.company;

public class Main {

    public static void main(String[] args) {
      //  Matrix m2 = Matrix.create(3, 2, 4, 0, -2, 1, 3, -1, 0, 1);
        int[][] arr = {
                {2,5,7},
                {6,3,4},
                {5,-2,-3}
        };
        Matrix m3 = Matrix.create(arr);
        m3.inverse_matrix();
       // m3.algebraic_supplement_help(2,2);
    }
}
