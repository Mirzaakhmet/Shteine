package LAB3.Problem5;

import java.util.Vector;

public class DragonLaunch {
	private Vector<Person> kidnappedPeople;
	
	public DragonLaunch() {
        this.kidnappedPeople = new Vector<>();
    }
	
	public void kidnapDel() {
		kidnappedPeople.clear();
	}
	
	public void kidnap(Person p) {
        kidnappedPeople.add(p);
    }
	
	public String willDragonEatOrNot(){
		int boysWaiting = 0;
		for(Person p:kidnappedPeople) {
			if(p.getGender()==Gender.B) 
			{
				boysWaiting++;
			}
		
			else {
				
				if(boysWaiting>0) {
					
					boysWaiting--;
					
				}
				
				else { 
					return "Dinner is guaranteed for him";
							}
				
			}
		
		}
		
		return boysWaiting > 0 ? "Dinner is guaranteed for him" : "He's on a diet today.";
	
	}	
}
