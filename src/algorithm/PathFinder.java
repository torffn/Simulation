package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Creatures.Entity;
import Creatures.Herbivore;
import Creatures.PointOfCreatures;
import Map.GameMap;
import SimulationProcess.Simulation;

public class PathFinder {
	private static final int[][] DIRECTIONS_FOR_SHIFT = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
public static Stack<PointOfCreatures> bfs(PointOfCreatures coordinates, Class<? extends Entity> searcher, 
		Class<? extends Entity> target, GameMap board){
	Queue<PointOfCreatures> queueOfCoordinates = new LinkedList<>();
	HashMap<PointOfCreatures, PointOfCreatures> previousCoordinates = new HashMap<>();
	queueOfCoordinates.add(coordinates);
	HashSet<PointOfCreatures> visited = new HashSet<>();
	visited.add(coordinates);
	while(!queueOfCoordinates.isEmpty()) {
		PointOfCreatures current = queueOfCoordinates.poll();
		Entity entity = board.getEntity(current);
		if(entity != null && (entity.getClass()).equals(target)) {
			return findPath(previousCoordinates, current);
		}
		int currentY = current.getY();
		int currentX = current.getX();
		int numberForDirectionsOfShift = 4;
		if((Herbivore.class.equals(target))) {
			numberForDirectionsOfShift = 8;
		}
		for(int i = 0; i < numberForDirectionsOfShift; i++) {
			int newX = currentX + DIRECTIONS_FOR_SHIFT[i][0];
			int newY = currentY + DIRECTIONS_FOR_SHIFT[i][1];
			PointOfCreatures neighbor = new PointOfCreatures(newX, newY);
			if(isCoordinateValidForCreature(neighbor, target, board) && !visited.contains(neighbor)) {
				queueOfCoordinates.add(neighbor);
				visited.add(neighbor);
				previousCoordinates.put(neighbor, current);
			}
		}
	}
return null;
}
private static boolean isCoordinateValidForCreature(PointOfCreatures coordinates, Class<? extends Entity> target, GameMap board) {
	int x = coordinates.getX();
	int y = coordinates.getY();
	Entity entity = board.getEntity(coordinates);
	Simulation sim = new Simulation();
	if(entity!=null) {
		return target.equals(entity.getClass());
	}
	return (sim.getWidth() > x && x>=0) && (sim.getHeigt() > y && y >=0);
}
private static Stack<PointOfCreatures> findPath(HashMap<PointOfCreatures, PointOfCreatures> previousCoordinates, 
		PointOfCreatures current){
	Stack<PointOfCreatures> path = new Stack<>();
	while(current != null) {
		path.add(current);
		current = previousCoordinates.get(current);
	}
	path.pop();
	return path;
}
}
