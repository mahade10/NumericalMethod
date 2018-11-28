package code;

public class NewtonDividedDifference {
	// CPP program for implementing 
	// Newton divided difference formula  
	  
	// Function to find the product term 
	public float proterm(int i, float value, float x[]) 
	{ 
	    float pro = 1; 
	    for (int j = 0; j < i; j++) { 
	        pro = pro * (value - x[j]); 
	    } 
	    return pro; 
	} 
	  
	// Function for calculating 
	// divided difference table 
	public void dividedDiffTable(float x[], float y[][], int n) 
	{ 
	    for (int i = 1; i < n; i++) { 
	        for (int j = 0; j < n - i; j++) { 
	            y[j][i] = (y[j][i - 1] - y[j + 1] 
	                         [i - 1]) / (x[j] - x[i + j]); 
	        } 
	    } 
	} 
	  
	// Function for applying Newton's 
	// divided difference formula 
	float applyFormula(float value, float x[], 
	                   float y[][], int n) 
	{ 
	    float sum = y[0][0]; 
	  
	    for (int i = 1; i < n; i++) { 
	      sum = sum + (proterm(i, value, x) * y[0][i]); 
	    } 
	    return sum; 
	} 
	  
	// Function for displaying  
	// divided difference table 
	public void printDiffTable(float y[][],int n) 
	{ 
	    for (int i = 0; i < n; i++) { 
	        for (int j = 0; j < n - i; j++) { 
	            //cout << setprecision(4) <<  y[i][j] << "\t "; 
	            System.out.print(y[i][j]+" ");
	        }
	        System.out.println();
	    } 
	} 
	  
	// Driver Function 
	public static void main(String[] args){
	    // number of inputs given 
		NewtonDividedDifference ob = new NewtonDividedDifference();
	    int n = 5; 
	    float value, sum; 
	    float x[] = { 2, 3, 6, 7,9 }; 
	   float y[][]= new float [10][10];
	  
	    // y[][] is used for divided difference 
	    // table where y[][0] is used for input 
	    y[0][0] = 15; 
	    y[1][0] = 39; 
	    y[2][0] = 243; 
	    y[3][0] = 375;
	    y[4][0] = 771;
	  
	    // calculating divided difference table 
	    ob.dividedDiffTable(x, y, n); 
	  
	    // displaying divided difference table 
	    ob.printDiffTable(y,n); 
	  
	    // value to be interpolated 
	    value = 5; 
	  
	    // printing the value 
	   // cout << "\nValue at " << value << " is "
	              // << applyFormula(value, x, y, n) << endl; 
	    System.out.println(value+ " is :"+ob.applyFormula(value,x,y,n));
	} 

}
