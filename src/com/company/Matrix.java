package com.company;

public class Matrix {
    private int arr[][];
    private int lenght;

    private Matrix(int lenght, int... arr_buf) {
        this.arr = new int[lenght][lenght];
        int count = 0;
        this.lenght = lenght;
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                arr[i][j] = arr_buf[count++];
            }
        }
    }

    static Matrix create(int lenght, int... arr_buf) {
        Matrix m = new Matrix(lenght, arr_buf);
        return m;
    }

    void show() {
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    void addition(Matrix m) {
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                this.arr[i][j] += m.arr[i][j];
            }
        }
    }

    void subtraction(Matrix m) {
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                this.arr[i][j] -= m.arr[i][j];
            }
        }
    }

    void transpose() {
        Matrix buf = new Matrix(this.lenght, this.arr[lenght][lenght]);
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                this.arr[i][j] = buf.arr[j][i];
            }
        }
    }


    //////////////////////////////////////////Get//////////////////////////
    public int getLength() {
        return this.lenght;
    }

    public int[][] getArr() {
        return this.arr;
    }
}
