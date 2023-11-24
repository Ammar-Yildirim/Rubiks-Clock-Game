/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RubiksClockGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the graphical user interface for the Rubik's Clock game.
 * Allows users to interact with the clock puzzle and displays the current state of the game.
 * 
 * The clock puzzle is displayed as a 5x5 grid, where buttons can be clicked to change the time of the four clock adjacent to them.
 * The labels represent the current state of the clock puzzle.
 * The GUI includes a menu bar with options to reset the puzzle and exit the game.
 * 
 * @author Dell
 */
public class RubiksClockGUI {
    private int counter;
    
    private final JFrame frame;
    private final JPanel boardPanel;
    private Clocks clocks;
    private final JLabel[][] clockLabels;
    
    /**
    * Constructs a new RubiksClockGUI.
    * Initializes the frame, clocks, and graphical components for the game.
    * Sets up the menu bar with options to reset the puzzle and exit the game.
    */
    public RubiksClockGUI(){
        frame = new JFrame("Rubiks Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        clocks = new Clocks();
        boardPanel = new JPanel(new GridLayout(5,5));
        clockLabels = new JLabel[3][3];
        
        for(int i=0; i<5;i++){
            for(int j=0;j<5;j++){
                JLabel label = new JLabel("",SwingConstants.CENTER);
                if((i == 1 || i == 3) && (j == 1 || j == 3)){
                    JButton button = new JButton();
                    button.addActionListener(new ButtonListener(i,j));
                    button.setText("+");
                    button.setFont(new Font("Roboto", Font.BOLD, 16));
                    button.setPreferredSize(new Dimension(80, 80));
                    boardPanel.add(button);
                }
                else{
                    if((i + j) % 2 == 1){
                        label.setVisible(false);
                    }
                    else{
                        label.setFont(new Font("Roboto", Font.BOLD, 16));
                        label.setBackground(Color.lightGray);
                        label.setOpaque(true);
                        clockLabels[i/2][j/2] = label;
                    }
                    label.setPreferredSize(new Dimension(80,80));
                    boardPanel.add(label);
                }
            }
        }
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Menu");
        menuBar.add(fileMenu);
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        resetMenuItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                clocks.setUpClocks();
                refresh();
                counter = 0;
            }
        });
        fileMenu.add(resetMenuItem);
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        refresh();
        
        frame.getContentPane().add(boardPanel);
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Refreshes the displayed labels on the GUI based on the current state of the clocks.
     */
    public void refresh(){
        for(int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                int num = clocks.getTime(i,j);  
                clockLabels[i][j].setText(String.valueOf(num));
            }
        }
    }
    
    /**
     * Checks if the game is finished and displays a message if it is.
     * If the game is finished, resets the clock puzzle and updates the display.
     */
    public void isFinished(){
        if(clocks.isFinished()){
            String message = "Game Finished in: " + counter + " steps";
            JOptionPane.showMessageDialog(frame, message,"Game-End",JOptionPane.INFORMATION_MESSAGE);
            clocks.setUpClocks();
            refresh();
            counter = 0;
        }
    }
    
    /**
     * ActionListener for the buttons on the GUI.
     * Changes the clock puzzle when a button is clicked, increments the step counter, 
     * refreshes the display, and checks if the game is finished.
     */
    class ButtonListener implements ActionListener{
        private final int i;
        private final int j;
        
        public ButtonListener(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            clocks.changeClocks(i, j);
            counter++;
            refresh();
            isFinished();
        }
    }
    
}
