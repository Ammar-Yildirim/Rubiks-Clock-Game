/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RubiksClockGame;

import java.util.Random;

/**
 * Represents the 9 clocks in the Rubik's Clock game.
 * The 9 clocks can be represented as a 3x3 matrix of integers, where one 
 * integer represents the time of that clock.
 * The goal of the game is to set time to 12 for all clocks.
 * 
 * 
 * @author Ammar Yildirim
 */
public class Clocks {
    private int matrix [][] = new int[3][3];
    
     /**
     * Constructs a new Clocks object by calling method setUpClocks();
     */
    public Clocks(){
        setUpClocks();
    }
    
    /**
     * Gets the time of the clock at the specified coordinates.
     *
     * @param i The row index.
     * @param j The column index.
     * @return The value of the clock at the specified coordinates.
     */
    public int getTime(int i,int j){
        return matrix[i][j];
    }
    
    /**
     * Changes the time of the clocks based on the clicked button.
     * Buttons can be located only at (1,1), (3,1), (1,3), (3,3), so we 
     * do not accept clicks from other coordinates.
     *
     * @param i The row index.
     * @param j The column index.
     */
    public void changeClocks (int i, int j) {
        if((i == 1 || i == 3) && (j == 1 || j == 3)){
            matrix[i/2][j/2] = (matrix[i/2][j/2]) % 12 + 1;
            matrix[i/2][(j/2)+1] = (matrix[i/2][(j/2)+1]) % 12 + 1;
            matrix[(i/2)+1][j/2] = (matrix[(i/2)+1][j/2]) %12 + 1;
            matrix[(i/2)+1][(j/2)+1] = (matrix[(i/2)+1][(j/2)+1]) % 12 + 1;
        }
    }
    
    /**
    * Resets the time of the clocks to 12.
    */
    private void resetClocks(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                matrix[i][j] = 12;
            }
        }
    }
    
    /**
     * Sets up the clocks to a random time, while ensuring the game remains solvable.
     * It achieves this by setting all the clocks to 12, and then stimulating
     * clicks in different positions.
     * Buttons can be located only at (1,1) (3,1) (1,3) (3,3), hence the
     * generated clicks can be only at the aforementioned coordinates.
     */
    public void setUpClocks(){
        resetClocks();
        
        Random rand = new Random();
        int randNum = rand.nextInt(10) + 3;
        
        for(int i=0; i<randNum; i++){
            int randi = rand.nextBoolean()? 1 : 3;
            int randj = rand.nextBoolean()? 1 : 3;
            
            this.changeClocks(randi, randj);
        }
    }

    /**
     * Checks if the clock puzzle is finished.
     * The puzzle is finished if all clocks show 12.
     *
     * @return True if the clock puzzle is finished, false otherwise.
     */
    public boolean isFinished(){
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                if (matrix[i][j] !=12){
                    return false;
                }
            }
        }
        return true;
    }
}
