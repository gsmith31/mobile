package edu.elon.edu.mobile.topsecret_gws;



import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class CorrectActiviy extends Activity{
	
	public static final String ANSWER = "theAnswer";
	
	private TextView displayPassword;
	
	private String aPassword;
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.correct_activity);
		
		aPassword = getIntent().getStringExtra(ANSWER);
		
		displayPassword = (TextView) findViewById(R.id.display_password);
		displayPassword.setText(aPassword);
		
		
		
		
		
	}

}
