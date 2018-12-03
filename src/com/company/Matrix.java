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
        int[][] buf = new int[this.lenght][this.lenght];
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                buf[i][j] = this.arr[i][j];
            }
        }
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                this.arr[i][j] = buf[j][i];
            }
        }
    }

    boolean is(Matrix m) {
        boolean is = false;
        int count = 0;
        int[][] m_arr = m.getArr();
        for (int i = 0; i < lenght; i++){
            for (int j = 0; j < lenght; j++){
                if(m_arr[i][j] == this.arr[i][j]){count++; }
            }
        }
        if(count == (lenght*lenght)){ is = true;}
        return is;
    }

    //////////////////////////////////////////Get//////////////////////////
    public int getLength() {
        return this.lenght;
    }

    public int[][] getArr() {
        return this.arr;
    }
}
