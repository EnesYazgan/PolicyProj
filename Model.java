import java.io.*;
import java.util.*;

/*Completed 12/5//2017
   @author Enes Yazgan (eiyazgan@ucsc.edu)
 */

class Model{
	public static void main(String args[]) throws IOException{
		if(args.length == 2){
			//Read file
			String file_name = args[0];
			int numLines = 50;
			BufferedReader br = new BufferedReader(new FileReader(file_name));
			
			//now it creates the String[] input, and puts each
			//line in as a string
			String[] input = new String[numLines];
			br = new BufferedReader(new FileReader(file_name));
			int counter = 0;
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
				
				while (line != null) {
					input[counter] = line;
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
					
					counter++;
				}
				String everything = sb.toString();
			} finally {
				br.close();
			}
			
			//printArr(input);
			
			State[] states = new State[numLines];
			String[] sd = new String[9];
			State temp;
			StringTokenizer st;
			boolean outlier;
			
			for(int i = 0; i < input.length; i++){
				st = new StringTokenizer(input[i]);
				counter = 0;
				while(st.hasMoreTokens()){
					//System.out.println(st.nextToken());
					sd[counter] = st.nextToken();
					counter++;
				}
				if(pi(sd[8]) == 1){
					outlier = true;
				} else {
					outlier = false;
				}
				
				temp = new State(sd[0],pi(sd[1]),pd(sd[2]),pd(sd[3]),pd(sd[4]),pd(sd[5]),pd(sd[6]),pd(sd[7]),outlier);
				states[i] = temp;
			}
			
			//printStateArr(states);
			
			double[] policyRates = new double[]{12.54,15.781,17.05,18.2,23.1,25.817,26.633,28.525,28.814,31.257};
			
			Scanner sc = new Scanner(System.in);
			String state;
			int tier;
			int timeframe;
			int implementation;
			System.out.println("Sexual Education Policy Effectiveness Model");
			System.out.println("Select State (Use Abbreviations):");
			state = sc.next();
			System.out.println("Select Policy Tier to Switch To:");
			tier = sc.nextInt();
			System.out.println("Select timeframe (in years):");
			timeframe = sc.nextInt();
			System.out.println("Select in how many years implementation is expected:");
			implementation = sc.nextInt();
			
			System.out.printf("Chose to model a tier %d policy in %s over the course of %d years with an expected implementation in %d years from now.\n", tier, state, timeframe, implementation);
			
			
			int picked = -1;
			for(int i = 0; i < states.length; i++){
				//System.out.println(state.toUpperCase() + " " + states[i].name());
				if(state.toUpperCase().equals(states[i].name())){
					picked = i;
				}
			}
			
			double[] currentTrend = new double[timeframe];
			double birthNum = states[picked].births();
			for(int i = 0; i < timeframe; i++){
				birthNum = states[picked].births() + ((states[picked].teens()*Math.pow((1+(states[picked].growthrate()/100)),i))-states[picked].teens())*(states[picked].birthrate()/1000);
				currentTrend[i] = birthNum;
			}
			
			
			double[] projectedTrend = new double[timeframe];
			double bB = 0;
			for(int i = 0; i < timeframe; i++){
				if(i < implementation){
					birthNum = states[picked].births() + ((states[picked].teens()*Math.pow((1+(states[picked].growthrate()/100)),i))-states[picked].teens())*(states[picked].birthrate()/1000);
					bB = birthNum;
				} else {
					birthNum = bB + ((states[picked].teens()*Math.pow((1+(states[picked].growthrate()/100)),i-(implementation-1)))-states[picked].teens())*(policyRates[tier-1]/1000);
				}
				projectedTrend[i] = birthNum;
			}
			
			System.out.println("If kept same:");
			
			printArrD(currentTrend);
			
			System.out.println("If implemented:");
			
			printArrD(projectedTrend);
			
			//Write output file
			String output_file = args[1];
			try{
				PrintWriter solutionFile = new PrintWriter(output_file, "UTF-8");
				for(int i = 0; i < currentTrend.length; i++){
					solutionFile.println(i);
				}
				solutionFile.println();
				for(int i = 0; i < currentTrend.length; i++){
					solutionFile.println(currentTrend[i]);
				}
				solutionFile.println();
				for(int i = 0; i < projectedTrend.length; i++){
					solutionFile.println(projectedTrend[i]);
				}
				solutionFile.close();
			} catch (IOException e) {
				System.out.println("Error");
			}
		} else {
			System.err.println("Need two args, Usage: java -jar Model.jar [input.txt] [output.txt]");
		}
		
		
	}
	public static double pd(String d){
		return Double.parseDouble(d);
	}
	public static int pi(String i){
		return Integer.parseInt(i);
	}
	public static void printArr(String[] s){
		System.out.println("\nArr:");
		for(int i = 0; i < s.length; i++){
			System.out.println(s[i] + " ");	
		}
		System.out.println("--");
	}
	public static void printArrD(double[] s){
		System.out.println("\nArr:");
		for(int i = 0; i < s.length; i++){
			System.out.println(s[i] + " ");	
		}
		System.out.println("--");
	}
	
	public static void printStateArr(State[] s){
		System.out.println("\nStates Tiers:");
		for(int i = 0; i < s.length; i++){
			System.out.println(s[i].name() + ": " + s[i].tier() + 
			" " + s[i].birthrate() + " "  + s[i].teens() + " "
			+ s[i].growthrate() + " " + s[i].births() + " "
			 + s[i].density() + " " + s[i].uninsured() + " "
			  + s[i].outlier() + " ");	
		}
		System.out.println("\n--");
	}
}

