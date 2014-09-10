package edu.elon.edu.mobile.topsecret_gws;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	private Button oneButton;
	private Button twoButton;
	private Button threeButton;
	private Button fourButton;
	private Button cheat;
	
	private TextView guessView;
	private TextView displayPass;
	
	private ArrayList<Integer> password;
	private ArrayList<Integer> guess;
	
	public MainActivity(){
		password = new ArrayList<Integer>();
		guess = new ArrayList<Integer>();
	}
	
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        guess.clear();
        password.clear();
        createRandomPassword();
        
        guessView = (TextView) findViewById(R.id.password_guess);
        

		oneButton = (Button) findViewById(R.id.button_one);
		oneButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				guess.add(1);			
				String aGuess = createString(1);
				guessView.setText(aGuess);
				if(guess.size() == 4){
					if(testGuessVsPassword()){
						Intent i = new Intent(MainActivity.this, CorrectActiviy.class);
						String thePassword = passwordString();
						i.putExtra(CorrectActiviy.ANSWER, thePassword);
						startActivity(i);
					}
					
				}
			}
		});
		
		twoButton = (Button) findViewById(R.id.button_two);
		twoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				guess.add(2);
				String aGuess = createString(2);
				guessView.setText(aGuess);
				if(guess.size() == 4){
					Intent i = new Intent(MainActivity.this, CorrectActiviy.class);
					if(testGuessVsPassword()){
						String thePassword = passwordString();
						i.putExtra(CorrectActiviy.ANSWER, thePassword);
						startActivity(i);
					}
				}

			}
		});
		
		threeButton = (Button) findViewById(R.id.button_three);
		threeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				guess.add(3);
				String aGuess = createString(3);
				guessView.setText(aGuess);
				if(guess.size() == 4){
					if(testGuessVsPassword()){
						Intent i = new Intent(MainActivity.this, CorrectActiviy.class);
						String thePassword = passwordString();
						i.putExtra(CorrectActiviy.ANSWER, thePassword);
						startActivity(i);
					}
				}

			}
		});
		
		fourButton = (Button) findViewById(R.id.button_four);
		fourButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				guess.add(4);
				String aGuess = createString(4);
				guessView.setText(aGuess);
				if(guess.size() == 4){
					if(testGuessVsPassword()){
						Intent i = new Intent(MainActivity.this, CorrectActiviy.class);
						String thePassword = passwordString();
						i.putExtra(CorrectActiviy.ANSWER, thePassword);
						startActivity(i);
					}
				}
			}
		});
		
		displayPass = (TextView) findViewById(R.id.password_text);      
		cheat = (Button) findViewById(R.id.button_showPassword);
		cheat.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				displayPass.setText(passwordString());
			}
		});
		
		
	
		
		
		
    }
    
    
    @Override
	protected void onResume(){
    	super.onResume();
		guess.clear();
        password.clear();
        guessView.setText("");
        displayPass.setText("");
        createRandomPassword();
        
	}
    
    public void createRandomPassword(){
    	int counter = 1;
    	for(int i = 0; i<4;i++){
    		password.add(counter);
    		counter++;
    	}  
    	Collections.shuffle(password);
    	System.out.println(passwordString());
    	
    }
    
    public boolean testGuessVsPassword(){
    	Boolean answer = true;
    	int messageResId = 0;
    	for(int i = 0; i<password.size();i++){
    		if(guess.get(i) != password.get(i)){
    			guess.clear();
    			
    			messageResId = R.string.nope_toast;
    			answer =  false;
    			Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT).show();
    			i = 100;
    		}
    	}
    	
    	return answer;
    }
    
    public String createString(int num){
    	String aGuess = "";
    	for(int aNum: guess){
			aGuess = aGuess + aNum;
		}
		return aGuess;
    }
    
    public String passwordString(){
    	String pass = "";
    	for(int i = 0; i<password.size();i++){
    		pass = pass + password.get(i);
		}
		return pass;
    }
}
