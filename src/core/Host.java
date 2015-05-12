package core;

import java.util.ArrayList;
import java.util.Random;

public class Host {
	
	private boolean infected = false;

	public Host() {
		
	}

	public boolean isInfected() {
		return infected;
	}

	public void setInfected(boolean infected) {
		this.infected = infected;
	}

	public void infect(boolean[] infectionList, ArrayList<Host> network) {
		Random rndG = new Random();
		double rndDouble = rndG.nextDouble();
		//System.out.println("Double is:"+rndDouble);
		if(rndDouble < 0.2) {
			//System.out.println("Infecting");
			boolean finInfection = false;
			while(!finInfection) {
				int target = rndG.nextInt(Badbot.networkSize);
				//System.out.println("Target is: "+target);
				if(!network.get(target).isInfected()) {
					infectionList[target] = true;
					finInfection = true;
					//System.out.println("Host "+target+" is not infected");
				}
			}
		}
	}

}
