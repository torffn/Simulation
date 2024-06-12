package Creatures;

import Map.GameMap;
import SimulationProcess.Simulation;
import algorithm.PathFinder;

public class Predator extends Creature {

private int atackPower = 40;

public Predator(PointOfCreatures coordinates) {
	super(coordinates);

}

@Override
public String toString() {
	return "\uD83E\uDD8A";
}
@Override
public void makeMove(GameMap map) {
	pathToTarget = PathFinder.bfs(coordinates, Predator.class, Herbivore.class, map);
	if(pathToTarget!=null) {
		PointOfCreatures newCoordinates = pathToTarget.pop();
		Herbivore herbivore = (Herbivore) map.getEntity(newCoordinates);
		if(herbivore!=null) {
			herbivore.reduceHealth(atackPower);
			if(herbivore.getHealth()<=0) {
				map.removeEntity(coordinates);
				coordinates = newCoordinates;
				map.setCreature(newCoordinates, this);
			}
		}else {
			map.removeEntity(coordinates);
			coordinates = newCoordinates;
			map.setCreature(newCoordinates, this);
		}
		Simulation.pauseSimulation(false);
	}
	
}

}
