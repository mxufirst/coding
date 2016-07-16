package com.meng.coding;

import java.util.Deque;
import java.util.LinkedList;

public class SnakeGame {
    
    class Pos {
        int r;
        int c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (! (o instanceof Pos)) return false;
            Pos p = (Pos) o;
            return r == p.r && c == p.c;
        }
        @Override
        public int hashCode() {
            return r + 17 * c;
        }
    }
    int width, height, f;
    Deque<Pos> snack;
    int[][] food;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        f = 0;
        this.food = food;
        snack = new LinkedList<>();
        snack.offer(new Pos(0, 0));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Pos head = snack.peekLast();
        int r = head.r;
        int c = head.c;
        switch (direction) {
            case "U" : r--; break;
            case "L" : c--; break;
            case "R" : c++; break;
            case "D" : r++; break;
        }
        
        if (r < 0 || r >= height || c < 0 || c >= width) return -1;
        Pos newHead = new Pos(r, c);
        Pos foodPos = f < food.length ? new Pos(food[f][0], food[f][1]) : null;
        if (!newHead.equals(foodPos)) {
            snack.pollFirst();
            if (snack.contains(newHead)) return -1;
        } else {
            f++;
        }
        snack.offerLast(newHead);
        return f;
        
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */