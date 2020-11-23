package com.louis.algorithm.exam.头条;

import java.util.Scanner;

/**
 * #include <iostream>
 * #include <vector>
 * using namespace std;
 *
 * vector<vector<int> > TransitiveClosure(vector<vector<int> > &matrix)//寻找可达矩阵
 * {
 *     int N =matrix.size();
 *     vector<vector<int> > reachable;
 *     reachable.resize(N);
 *     for(int i=0;i<N;i++)
 *             reachable[i].resize(N);
 *
 * 	for(int i=0;i<N;i++)//进行遍历
 * 		for(int j=0;j<N;j++)
 *                {
 * 			if((i==j)||(matrix[i][j])==1)//发现可达
 * 				reachable[i][j]=1;
 * 			else
 * 				reachable[i][j]=0;
 *        }
 *
 * 	for(int k=0;k<N;k++)
 * 		for(int i=0;i<N;i++)
 * 			for(int j=0;j<N;j++)
 * 				reachable[i][j]=reachable[i][j]||(reachable[i][k]&&reachable[k][j]);//由文中公式可得
 * 	return reachable;
 * }
 *
 * int main(){
 *     int N,M;
 *     cin >> N >> M;
 *     vector<vector<int> > matrix;
 *     matrix.resize(N);
 *     for(int i=0;i<N;i++){
 *             matrix[i].resize(N);
 *         for(int j=0;j<N;j++){
 *             matrix[i][j]=0;
 *         }
 *     }
 *     for(int i=0;i<M;i++){
 *         int x,y;
 *         cin >> x >> y;
 *         matrix[y-1][x-1]=1;
 *     }
 *
 *     //胜利ector<pair<int,int> > island;
 *
 *     vector<vector<int> > reachable=TransitiveClosure(matrix);
 *     int sum=0;
 *     for(int i=0;i<N;i++){
 *         int count=0;
 *         for(int j=0;j<N;j++){
 *             if(reachable[i][j]==1)
 *                 count++;
 *         }
 *         if(count==N)
 *             sum++;
 *     }
 *
 *     cout << sum << endl;
 *     return 0;
 * */
public class DouYin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int[][] num=new int[M][M];
        for (int i=0;i<M;i++){
            int row=scanner.nextInt();
            int col=scanner.nextInt();
            num[col-1][row-1]=1;
        }
        int[][] res=Matrix(num);
        int count=0;
        for (int i=0;i<N;i++){
            int index=0;
            for(int j=0;j<N;j++){
                if (res[i][j]==1){
                    index++;
                }
                if (index==N){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static int[][] Matrix(int[][] num) {
        int N = num.length;
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j || num[i][j] == 1) res[i][j] = 1;
                else res[i][j] = 0;
            }

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    boolean b1=res[j][i]==1?true:false;
                    boolean b2=res[i][k]==1?true:false;
                    boolean b3=res[j][k]==1?true:false;
                    if (b3||(b1&&b2)){
                        res[j][k]=1;
                    }else {
                        res[j][k]=0;
                    }
                }
            }
        }
        return res;
    }

}
