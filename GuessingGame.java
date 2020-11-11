import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener{
  JTextField userGuess;
  JButton buttonGuess, buttonReplay;
  JLabel jlabGuess, jlabHighLow, jlabLastGuess;
  Random r;
  int randomNum;

  GuessingGame(){
    r = new Random();
    randomNum = r.nextInt(100) + 1;

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);

    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");

    buttonGuess = new JButton("Guess");
    buttonReplay = new JButton("Play Again");

    userGuess.addActionListener(this);
    buttonGuess.addActionListener(this);
    buttonReplay.addActionListener(this);

    jlabGuess = new JLabel("Enter your guess: ");
    jlabHighLow = new JLabel("");
    jlabLastGuess = new JLabel("");

    frame.add(jlabGuess);
    frame.add(userGuess);
    frame.add(buttonGuess);
    frame.add(jlabHighLow);
    frame.add(jlabLastGuess);
    frame.add(buttonReplay);

    frame.setVisible(true);
  }

    public void actionPerformed(ActionEvent ae){
      if(ae.getActionCommand().equals("Guess")){
        int guess = Integer.parseInt(userGuess.getText());
        if(guess < randomNum){
          jlabHighLow.setText("Too Low!");
        }
        else if (guess > randomNum){
          jlabHighLow.setText("Too High!");
        }
        else if (guess == randomNum){
          jlabHighLow.setText("You got it!");
        }
        jlabLastGuess.setText("Last guess was: " + guess);
      }
      else if(ae.getActionCommand().equals("Play Again")){
        randomNum = r.nextInt(100) + 1;
        jlabHighLow.setText("");
        jlabLastGuess.setText("");
        userGuess.setText("");
      }
      else {
        jlabHighLow.setText("You pressed ENTER. Please press the Guess Button.");
      }
    }
}