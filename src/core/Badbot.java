package core;

import java.util.ArrayList;


public class Badbot {
	static int networkSize = 100000;
	
	public static void main(String[] args) {

		System.out.println("Badbot modelling 1.0");
		for(int i = 0; i < 100; i++) {
			ArrayList<Host> network = new ArrayList<Host>();
			for(int j = 0; j < networkSize; j++) {
				Host tempHost = new Host();
				network.add(tempHost);
			}
			network.get(0).setInfected(true);
			System.out.println(i+":"+startSim(network));
		}
		System.out.println("Finished");
	}

	private static int startSim(ArrayList<Host> network) {
		Boolean allInfected = false;
		int dayCount = 0;
		while(!allInfected) {
			//System.out.println("Day: "+dayCount);
			boolean[] infectionList = getInfectionList(network);
			for(Host bot : network) {
				if(bot.isInfected()) {
					for(int i = 0; i< 9; i++) {
						bot.infect(infectionList, network);
					}
				}
			}
			for(int i = 0; i<networkSize; i++) {
				if(network.get(i).isInfected() != infectionList[i]) {
					//System.out.println("New host infected: "+i);
					network.get(i).setInfected(infectionList[i]);
				}
				
			}
			for(int i = 0; i<networkSize; i++) {
				if(!network.get(i).isInfected()) {
					allInfected = false;
					break;
				}
				allInfected = true;
			}
			dayCount++;
		}
		return dayCount;
		
	}

	private static boolean[] getInfectionList(ArrayList<Host> network) {
		boolean[] infectionList = new boolean[networkSize];
		for(int i = 0; i< networkSize; i++) {
			infectionList[i] = network.get(i).isInfected();
		}
		return infectionList;
	}

}
