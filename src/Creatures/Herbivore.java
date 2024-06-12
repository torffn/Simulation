package Creatures;

import Map.GameMap;
import SimulationProcess.Simulation;
import algorithm.PathFinder;

public class Herbivore extends Creature{

public Herbivore(PointOfCreatures coordinates) {
		super(coordinates);}

public void makeMove(GameMap map) {
	pathToTarget = PathFinder.bfs(coordinates, Herbivore.class, Grass.class, map);
	if(pathToTarget!=null) {
		PointOfCreatures newCoordinates = pathToTarget.pop();
		map.doMove(newCoordinates, this);
		coordinates = newCoordinates;
		Simulation.pauseSimulation(false);
	}
}
public void reduceHealth(int damage) {
	HP -= damage;
}
public int getHealth() {
	return HP;
}

@Override
public String toString() {
	return "\uD83D\uDC14";
}

}
