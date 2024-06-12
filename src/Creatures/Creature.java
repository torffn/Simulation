package Creatures;

import java.util.Stack;

import Map.GameMap;

public abstract class Creature extends Entity {
protected int HP = 100;
Stack<PointOfCreatures> pathToTarget = new Stack<>();

public Creature(PointOfCreatures coordinates) {
	super(coordinates);
	}

public abstract void makeMove(GameMap map);
}
