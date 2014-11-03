/**
 * 
 */
package fysioSysteem.domain;

/**
 * @author IVH5B5
 *
 */

public enum Status {
	ACTIEF,INACTIEF;
	
	public Status getNext(){
		return values()[(ordinal() + 1) % values().length];
	}
}
