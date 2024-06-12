package actions;

import Creatures.Entity;
import Creatures.EntityType;
import Creatures.Grass;
import Creatures.Herbivore;
import Creatures.PointOfCreatures;
import Creatures.Predator;
import Creatures.Rock;
import Creatures.Tree;

public class EntityFctory {
public static Entity createEntity(EntityType entityType, PointOfCreatures coordinates) {
	return switch(entityType) {
	case GRASS -> new Grass(coordinates);
	case ROCK -> new Rock(coordinates);
	case TREE -> new Tree(coordinates);
	case HERBIVORE -> new Herbivore(coordinates);
	case PREDATOR -> new Predator(coordinates);
	};
			
}
}
