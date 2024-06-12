package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Map;
import Creatures.Creature;
import Creatures.Entity;
import Creatures.PointOfCreatures;
import SimulationProcess.MapRender;
import SimulationProcess.Simulation;

public class GameMap{
HashMap<PointOfCreatures, Entity> map = new HashMap<>();

public void setCreature(PointOfCreatures coordinates, Entity entity) {
	map.put(coordinates, entity);
		
}
public HashMap<PointOfCreatures, Entity> getGameMap(){
	return map;
}
public Entity getEntity(PointOfCreatures coordinates) {
	return map.get(coordinates);
}
public boolean isPlaceEmpty(PointOfCreatures coordinates) {
	 return !map.containsKey(coordinates);
}
public void removeEntity(PointOfCreatures coordinates) {
	map.remove(coordinates);
}
public List<Creature> getAllEntitiesOnMap() {
    List<Creature> entities = new ArrayList<>();
    for (Map.Entry<PointOfCreatures, Entity> entry: map.entrySet()) {
        Entity entity = entry.getValue();
        if (entity instanceof Creature) {
            entities.add((Creature) entity);
        }
    }
    return entities;
}
public void doMove(PointOfCreatures end, Entity entity) {
	PointOfCreatures start = entity.getCoordinates();
	Entity entity1 = entity;
	entity1.setCoordinates(end);
	map.remove(start);
	map.put(end, entity1);
	}
}
