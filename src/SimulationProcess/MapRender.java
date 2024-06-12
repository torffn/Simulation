package SimulationProcess;

import Creatures.Entity;
import Creatures.PointOfCreatures;
import Map.GameMap;

public class MapRender {
	public void renderMap(GameMap map) {
		for(int i = 1;i<=Simulation.height; i++) {
			for(int j = 1; j<=Simulation.width; j++) {
				PointOfCreatures temp = new PointOfCreatures(i,j);
				if(map.getGameMap().containsKey(temp)) {
					System.out.print(map.getGameMap().get(temp));}
				else {
					System.out.print("\uD83D\uDFEB");}}
			System.out.println("");}
		
	}
}
