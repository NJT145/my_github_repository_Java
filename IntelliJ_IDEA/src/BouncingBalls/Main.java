package BouncingBalls;

import javax.swing.JFrame;
/**
 * BouncingBalls.Main Program for running the bouncing ball as a standalone application.
 * 
 * @author Hock-Chuan Chua
 * @version October 2010
 */
public class Main {
   // Entry main program
   public static void main(String[] args) {
      // Run UI in the Event Dispatcher Thread (EDT), instead of BouncingBalls.Main thread
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JFrame frame = new JFrame("A World of Balls");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new BallWorld(640, 480)); // BouncingBalls.BallWorld is a JPanel
            frame.pack();            // Preferred size of BouncingBalls.BallWorld
            frame.setVisible(true);  // Show it
         }
      });
   }
}
