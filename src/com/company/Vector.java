package com.company;

public class Vector {

    private int arr[];
    private int lenght;

    //////////////////////////////////////////////constructor

    private Vector(int lenght, int... arr_buf) {
        this.arr = new int[lenght];
        this.lenght = lenght;
        for (int i = 0; i < lenght; i++) {
            arr[i] = arr_buf[i];
        }
    }

    private Vector(int arr_local[]) {
        this.lenght = arr_local.length;
        this.arr = arr_local;
    }

    ////////////////////////////////////////////////////functions

    static Vector create(int lenght, int... arr_buf) {
        Vector v = new Vector(lenght, arr_buf);
        return v;
    }

    void show() {
        System.out.print("Vector = ");
        for (int i = 0; i < this.lenght; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    void lenght() {
        double suma = 0;
        double sqrt = 0;
        for (int i = 0; i < this.lenght; i++) {
            suma += arr[i] * arr[i];
        }
        sqrt = Math.sqrt(suma);
        System.out.println("vector lenght  = " + sqrt);
    }

    void scaldob(Vector v) {
        double scal = 0;
        double buf = 0;
        for (int i = 0; i < this.lenght; i++) {
            buf = this.arr[i] * v.arr[i];
            scal += buf;
        }
        System.out.println("scal = " + scal);
    }

    Vector division_on_matrix(Matrix m) {
        int matrix_arr[][] = m.getArr();
        int summa[] = new int[lenght];
        int vector_count = 0;

        if (m.getLength() == this.lenght) {
            for (int i = 0; i < m.getLength(); i++) {
                for (int j = 0; j < m.getLength(); j++) {
                    matrix_arr[i][j] *= arr[j];
                    summa[vector_count] += matrix_arr[i][j];
                }
                vector_count++;
            }
        } else {
            System.out.println("error");
        }
        Vector vector = new Vector(summa);
        return vector;
    }

    void addition(Vector v) {
        for (int i = 0; i < lenght; i++) {
            this.arr[i] += v.arr[i];
        }
    }

    void substraction(Vector v) {
        for (int i = 0; i < lenght; i++) {
            this.arr[i] -= v.arr[i];
        }
    }

}




