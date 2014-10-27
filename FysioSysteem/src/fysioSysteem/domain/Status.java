/**
 * 
 */
package fysioSysteem.domain;

/**
 * @author Bob
 *
 */
public enum Status {
	ACTIEF,INACTIEF;
	
	public Status getNext(){
		return values()[(ordinal() + 1) % values().length];
	}
}
