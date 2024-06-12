package actions;

import java.util.Random;

import Creatures.Entity;
import Creatures.EntityType;
import Creatures.PointOfCreatures;
import Map.GameMap;
import SimulationProcess.Simulation;

public class Action {
public void initAuctions() {}
public void turnAuction() {}
public static void placeEntities(GameMap map) {
	spawnAction(40, EntityType.GRASS, map);
	spawnAction(14, EntityType.HERBIVORE, map);
	spawnAction(3, EntityType.PREDATOR, map);
	spawnAction(10, EntityType.ROCK, map);
	spawnAction(20, EntityType.TREE, map);
}
public static void spawnAction(Integer amount, EntityType entity, GameMap map) {
	Random rand = new Random();
	for(int i = 0; i<amount; i++) {
		int j = 0;
		while(j==0) {
			int x = rand.nextInt(Simulation.width);
			int y = rand.nextInt(Simulation.height);
			PointOfCreatures coordinates = new PointOfCreatures(x,y);
			if(map.isPlaceEmpty(coordinates)) {
				map.setCreature(coordinates, EntityFctory.createEntity(entity, coordinates));
				j++;
			}
		}
	}
	
}



}
