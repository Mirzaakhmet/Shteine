package LAB3.Problem1;

public class Data {
	private double sum;
	private double max;
	private int cnt;
	
	public  Data(){
		sum = 0;
		cnt = 0;
		max = -Double.MAX_VALUE;
	}
	
	public void add(double val) {
		sum += val;
		if (cnt == 0 || max < val) {
			max = val;
		}
		cnt++;
	}
	
	public double getAvg() {
		if(cnt>0) {
			return setAvg();
		}
		else {
			return 0;
		}
	}
	
	public double setAvg() {
		return sum/cnt;
	}

	
	public double getMax() {
	if (cnt>0) {
		return max;
	}
	else {
		return 0;
	}
	}
}
