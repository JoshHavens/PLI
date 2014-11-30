import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class RockPaperScissors extends Applet implements ActionListener {
    private Button rockButton;
    private Button scissorsButton;
    private Button paperButton;
    private String buttonPressed = ""; // the label of the button pressed
    private int computerValue = -1;  
    private int myValue;
    
    
    public void init() {
    this.setSize(700, 400);
    Font myFont = new Font("TimesRoman", Font.BOLD, 50);
    this.setFont(myFont);
    
	rockButton = new Button("Rock");
	//rockButton.setSize(1000, 1000);
	
	scissorsButton = new Button("Scissors");
	//scissorsButton.setSize(1000, 1000);
	
	paperButton = new Button("Paper");
	//paperButton.setSize(1000,1000);
	
	
	add(rockButton);
	add(scissorsButton);
	add(paperButton);
	rockButton.addActionListener(this);
	scissorsButton.addActionListener(this);
	paperButton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event) {
	buttonPressed = ((Button)event.getSource()).getLabel();
	computerValue = randomNumber012();
	translator(buttonPressed);
	repaint();
    }
    
    // paint is called each time a button is pressed
    public void paint(Graphics g) {    
    	computerChoice(g);
	winner(g, computerValue, myValue);
    }
    
    //Randomly generate one of the numbers 0, 1, 2.
    int randomNumber012(){
	return (int)(Math.random()*3);
    }
    
    //Prints on the screen one of the strings "Rock", "Scissors", or "Paper" if 
    //one of the generated numbers is 0, 1, or 2, respectively.
    void computerChoice(Graphics g){
	
	if(computerValue == 0){
	    g.drawString("Computer's choice: Rock", 75, 200);
	}
	else if(computerValue == 1){
	    g.drawString("Computer's choice: Scissors", 75, 200); 
	}
	
	else if(computerValue == 2){
	    g.drawString("Computer's choice: Paper", 75, 200); 
	}
    }
    

    //Translates "Rock" to 0, "Scissors" to 1, and "Paper" to 2.
    void translator(String s){
	if(s.equals("Rock")){
	    myValue = 0;
	}
	else if(s.equals("Scissors")){
	    myValue = 1;
	}
	
	else if(s.equals("Paper")){
	    myValue = 2;
	}
    }
    
    //Decides the winner. cv means computer value, mv means my value.
    void winner(Graphics g, int cv, int mv){
	//Before playing, nothing happens, so print nothing.
	if(cv == -1){
	    g.drawString("", 150, 300);
	}
	//If the machine and the player have the same thing, it is a draw.
	else if(cv == mv){
	    g.drawString("Result: Draw", 150, 300);
	}
	
	//Computer beats if
	//it has Rock and you have scissors, or it has  scissors and you have paper or
	//you have paper and I have rock.
	else if(cv == 0 && mv == 1 || 
		cv == 2 && mv == 0 || 
		cv == 1 && mv == 2){
	    g.drawString("Result: Computer wins", 150, 300); 
	}
	
	//You win in any other case
	else{
	    g.drawString("Result: You win", 150, 300);
	}
    }
}