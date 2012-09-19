package ie.gcd.hci;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class MyOnItemSelectedListener implements OnItemSelectedListener
{
	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
	{
		
		if (pos == 0)
		{
			TipCalculator.percentage = 0; 
		}
		else if (pos == 1)
		{
			TipCalculator.percentage = 2; 
		}
		else if (pos == 2)
		{
			TipCalculator.percentage = 5; 
		}
		else if (pos == 3)
		{
			TipCalculator.percentage = 10; 
		}
		else if (pos == 4)
		{
			TipCalculator.percentage = 15; 
		}
		else if (pos == 5)
		{
			TipCalculator.percentage = 20; 
		}
		else if (pos == 6)
		{
			TipCalculator.percentage = 25; 
		}
		else if (pos == 7)
		{
			TipCalculator.percentage = 30; 
		}
		else if (pos == 8)
		{
			TipCalculator.percentage = 35; 
		}
		else if (pos == 9)
		{
			TipCalculator.percentage = 40; 
		}
		else if (pos == 10)
		{
			TipCalculator.percentage = 50; 
		}
				
		Toast.makeText(parent.getContext(), 
				parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
	}
	public void onNothingSelected(AdapterView parent)
	{
		// do nothing
	}
}