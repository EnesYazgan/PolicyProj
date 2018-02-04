// State.java

public class State{
	private String name; //state
	private int tier; //sex ed policy tier
	private double birthrate; //birth rate
	private double teens; // teen population
	private double growthrate; // annual population growth
	private double births; // number of births
	private double density; // population density
	private double uninsured; // percent uninsured
	private boolean outlier; //outlier state
	// Constructor
	// Creates a new empty state
	public State(String n, int ti, double br, double te, double g, double b, double d, double u, boolean o){
		this.name = n;
		this.tier = ti;
		this.birthrate = br;
		this.teens = te;
		this.growthrate = g;
		this.births = b;
		this.density = d;
		this.uninsured = u;
		this.outlier = o;	
	}
	void setTier(int t){
		tier = t;
	}
	// Access functions 
	String name(){
		return name;
	}
	int tier(){
		return tier;
	}
	double birthrate(){
		return birthrate;
	}
	double teens(){
		return teens;
	}
	double growthrate(){
		return growthrate;
	}
	double births(){
		return births;
	}
	double density(){
		return density;
	}
	double uninsured(){
		return uninsured;
	}
	boolean outlier(){
		return outlier;
	}
}