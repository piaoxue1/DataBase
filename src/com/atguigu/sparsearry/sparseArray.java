package com.atguigu.sparsearry;

public class sparseArray {
    public static void main(String[] args) {
        //创建二维数组
        //0,1,2代表没有，黑色，蓝色
        int[][] chessArr1 =new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[5][5]=8;
        //输出原始二维数组
        for (int[] row:chessArr1){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二维数组转换为稀疏数组
        //1.先遍历二维数组，得到非零数据的个数
        int sum=0;
        for (int[] ints : chessArr1) {
            for (int j = 0; j < 11; j++) {
                if (ints[j] != 0) {
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int[][] sparseArr =new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        //遍历二维数组，将稀疏数组的值存放到sparseArr中
        int count=0;
//        for (int i=0;i<chessArr1.length;i++){
        for (int i=0;i<chessArr1.length;i++){
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        for (int[] ints : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }
        System.out.println();
        //将稀疏数组转换为二维数组
        //先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] chessArr2 =new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.再读取稀疏数组后几行的数据，并赋给原始的二维数组即可。
        for (int i = 1; i <sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        System.out.println();
        for(int[] row: chessArr2){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
