package ie.gcd.hci;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.NumberKeyListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class TipCalculator extends Activity {

	public static int percentage;


	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                	
        // Respond to Text Input -------------------------------------
        final EditText edittext = (EditText) findViewById(R.id.edittext);
        edittext.setKeyListener(new NumberKeyListener()
        {
        	protected char[] getAcceptedChars() 
        	{
        		// restrict input to these characters 
        		char[] numberChars = {'0','1','2','3','4','5','6','7','8','9','.'};
        		return numberChars;
        	}

			public int getInputType() {
				// TODO Auto-generated method stub
				return 0;
			}			
        });
        // Respond to Text Input END -------------------------------------
        
        // Spinner Start -------------------------------------------------
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
        (this, R.array.percentage_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
        // Spinner End ---------------------------------------------------

        // Respond to Calculate Button Pressed ---------------------
        // Alert Dialog for showing calculation result
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please enter a decimal number")
               .setCancelable(false)
//               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                   public void onClick(DialogInterface dialog, int id) {
//                	   TipCalculator.this.finish();
//                   }
//               })
               .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                   }
               });
        
        final Button button = (Button) findViewById(R.id.calculate);
        button.setOnClickListener(new OnClickListener() 
        {
        	public void onClick(View v) 
        	{
        		try
        		{
        			double bill = Double.valueOf(edittext.getText().toString());

        			double tip = bill / 100 * percentage;
        			double total = bill + tip;

//        			Used for Testing
        			String tipString = Double.toString(tip);
//        			String percentageString = Integer.toString(percentage);
        			
        			String totalString = Double.toString(total);

        			AlertDialog alert = builder.create();
        	        alert.setTitle("Tip: €"+tipString);
        	        	// Icon for AlertDialog
    	        		alert.setMessage("Total: €"+totalString);
//        	        	alert.setIcon(R.drawable.icon);
        	        	alert.show();
        		}
        		catch(Exception e)
        		{
//        			Error catching ie StringWriter not longer needed
//        			StringWriter sw = new StringWriter();
//        			PrintWriter pw = new PrintWriter(sw);
//        			e.printStackTrace(pw);
        			AlertDialog alertDialog = builder.create();
        			alertDialog.setTitle("ERROR!");
//        			alertDialog.setMessage(sw.toString());
//        			alertDialog.setButton("OK", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){return;}});
//        			alertDialog.setButton("OK", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){return;}});

        			alertDialog.show();
        		}
          	}
        });
        // Respond to Calculate Button Pressed END ---------------------
    }
}