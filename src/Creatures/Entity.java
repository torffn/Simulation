package Creatures;

public abstract class Entity {
protected PointOfCreatures coordinates;

protected Entity(PointOfCreatures coordinates) {
	this.coordinates = coordinates;
	
}
public void setCoordinates(PointOfCreatures coordinates) {
	this.coordinates = coordinates;
}
public PointOfCreatures getCoordinates() {
	return coordinates;
}
}
