/* @author Donald Wyand
 * @date 10/8/23
 * ICS 211 RPS project
 * 
*/

/* ****************************************************************
 *                          Milestones
 * ****************************************************************
 * - GUI baseline functionality[]
 * - Buttons[]
 * - Documentation[]
 * - Game mechanics[]
 * - GUI game frame[]
 * - FileWrite.java[]
 * - Functionality testing[]
 * - Ensure MVP[]
 * - GUI design[]
 */

 /* * Design notes
  *  - Use as many images as possible
  *  Options will be displayed in a roundel if possible
  */
import java.awt.BorderLayout;

import javax.swing.*;

public class RPS {
    public static void main(String[] args){
        JFrame frame = new JFrame("Rock Paper Scissers v1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout(0, 0));
        // Creating assets and buttons
        JLabel title = new JLabel("Welcome to Rock Paper Scissors!");
        JButton guide = new JButton ("How to play");
        JButton play = new JButton ("Play against AI");
        JButton Rock = new JButton ("Rock");
        JButton Paper = new JButton ("Paper");
        JButton Scissers = new JButton ("Scissers");
    }
}
