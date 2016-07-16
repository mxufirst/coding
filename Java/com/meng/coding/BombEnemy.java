package com.meng.coding;

public class BombEnemy
{

	public static void main(String[] args)
	{
		char[][] grid = {{'0', 'E' ,'0' ,'0'},{'E' ,'0' ,'W' ,'E'},{'0' ,'E' ,'0' ,'0'}};
		BombEnemy be = new BombEnemy();
		System.out.println(be.maxKilledEnemies(grid));
	}
	
	public int maxKilledEnemies(char[][] grid) {
        int max = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] kills = new int[grid.length][grid[0].length];
        //by rows
        for (int i = 0; i < grid.length; i++) {
            int start = 0, count = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'E') {
                    count++;
                } 
                if (grid[i][j] == 'W' || j == grid[0].length - 1) {
                    fill(kills, grid, i, i, start, j, count);
                    count = 0;
                    start = j + 1;
                }
            }
        }
        
        //by columns
        for (int j = 0; j < grid[0].length; j++) {
            int start = 0, count = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 'E') {
                    count++;
                } 
                if (grid[i][j] == 'W' || i == grid.length - 1) {
                    fill(kills, grid, start, i, j, j, count);
                    count = 0;
                    start = i + 1;
                }
            }
        }
        
        //find max
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(kills[i][j], max);
            }
        }
        
        return max;
    }
    
    private void fill(int[][] kills, char[][] grid, int r1, int r2, int c1, int c2, int count) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == '0') {
                    kills[i][j] += count;
                }
            }
        }
    }

}
