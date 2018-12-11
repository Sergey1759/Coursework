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
        this.show();
    }

    private Matrix(int[][] arr_buf) {
        this.lenght = arr_buf.length;
        this.arr = arr_buf;
        this.show();
    }

    static Matrix create (int[][] arr_buf) {
        boolean buf = false;
        int count = 0;

        for(int i = 0; i < arr_buf.length; i++){
            if(arr_buf[i].length == arr_buf.length){
                count++;            }
        }
        buf = count == arr_buf.length ?  true : false;
        if(buf){
            Matrix m = new Matrix(arr_buf);
            return m;
        } else {
            System.out.println("You entered the wrong data");
            return null;
        }
    }
    static Matrix create(int lenght, int... arr_buf) {
        if(arr_buf.length == lenght*lenght){
            Matrix m = new Matrix(lenght, arr_buf);
            return m;
        } else {
            System.out.println("You entered the wrong data");
            return null;
        }

    }

    void show() {
        System.out.println("");
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
        this.show();
    }

    void subtraction(Matrix m) {
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                this.arr[i][j] -= m.arr[i][j];
            }
        }
        this.show();
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
        this.show();
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
    int determinant(){
        switch (this.lenght){
            case 1 : {
                return arr[1][1];
            }
            case 2:{
                int buf = this.arr[0][0]* this.arr[1][1]- this.arr[0][1]* this.arr[1][0] ;
                return buf;
            }
            case 3: {
                int buf =
                                (this.arr[0][0]* this.arr[1][1] * this.arr[2][2]) +
                                (this.arr[0][1]* this.arr[1][2] * this.arr[2][0]) +
                                (this.arr[0][2]* this.arr[1][0] * this.arr[2][1]) -
                                (this.arr[0][2]* this.arr[1][1] * this.arr[2][0]) -
                                (this.arr[0][0]* this.arr[1][2] * this.arr[2][1]) -
                                (this.arr[0][1]* this.arr[1][0] * this.arr[2][2]);

               // a11·a22·a33 + a12·a23·a31 + a13·a21·a32 - a13·a22·a31 - a11·a23·a32 - a12·a21·a33
                return buf;
            }

            default: {
                System.out.println(" Sorry I do not know how determinants of other matrices are determined");
                return 0;
            }
        }
    }
    private Matrix algebraic_supplement_help(int s_i,int s_j){
        int[][] my_arr =  new int[this.arr.length - 1][this.arr.length - 1];
        int count_i = 0;
        int count_j = 0;
       // System.out.println("arr.length " +  arr.length);
        for (int i  = 0; i < arr.length; i++){
            for (int j  = 0; j < arr.length; j++){
                if (s_i != i && s_j != j) {
                   // System.out.println("count_i = " + count_i + " count_j = " + count_j);
                    if(count_j == this.arr.length-1){
                        count_i = count_i + 1;
                        count_j = 0;
                    }
                    my_arr[count_i][count_j] = this.arr[i][j];
                    count_j = count_j + 1;
                    //System.out.println("s_i = " + s_i + "  s_j = "  + s_j +" i = " + i + " j = " + j);
                }
            }
        }

        Matrix m1 = Matrix.create(my_arr);
        return m1;
    }
    private void minus1 (){
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr.length; j++){
                    this.arr[i][j]= this.arr[i][j] * (-1);
                }
            }
            this.show();
        }
    //////////////////////////////////////////////////////
    Matrix  inverse_matrix(){
        int[][] arr =  new int[this.arr.length][this.arr.length];
        int count = 1;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                count = (i+j) % 2 == 0 ?  1 : -1;
                arr[i][j] = count * (algebraic_supplement_help(i,j)).determinant();
            }
        }
        Matrix m = Matrix.create(arr);
        m.transpose();
        m.minus1();
        return m;
    }

    //////////////////////////////////////////Get//////////////////////////
    public int getLength() {
        return this.lenght;
    }

    public int[][] getArr() {
        return this.arr;
    }
}
