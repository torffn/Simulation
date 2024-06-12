package SimulationProcess;

import java.util.List;
import java.util.Random;

import Creatures.Creature;
import Creatures.Entity;
import Creatures.EntityType;
import Creatures.Grass;
import Creatures.Herbivore;
import Creatures.PointOfCreatures;
import Creatures.Predator;
import Creatures.Rock;
import Creatures.Tree;
import Map.GameMap;
import actions.Action;

public class Simulation {
public static final int height = 20;
public static final int width = 20;
private static boolean continueSimulation = true;
private static int numberOfIterations = 0;
GameMap gameMap = new GameMap();
MapRender mp = new MapRender();

public static int getHeigt() {
	return height;
}
public static int getWidth() {
	return width;
}

public void startSimulation() throws InterruptedException {
	Action.placeEntities(gameMap);
	while(continueSimulation) {
		nextTurn();
	}
}

public void nextTurn() throws InterruptedException {
	continueSimulation = false;
	mp.renderMap(gameMap);
	List<Creature> entitiesOnMap = gameMap.getAllEntitiesOnMap();
	for(Creature creature: entitiesOnMap) {
		if(gameMap.getEntity(creature.getCoordinates()).equals(creature)) {
			creature.makeMove(gameMap);
		}
	}
	if (numberOfIterations % 3 == 0) {
        Action.spawnAction(10, EntityType.GRASS, gameMap);
    }
    Thread.sleep(900);
    System.out.println("Iteration number: " + numberOfIterations);
    numberOfIterations += 1;
}
public static void pauseSimulation(Boolean status) {
	continueSimulation = !status;
}
}
