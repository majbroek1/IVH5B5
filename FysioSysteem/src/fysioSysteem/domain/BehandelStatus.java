/**
 * 
 */
package fysioSysteem.domain;

/**
 * @author IVH5B5
 *
 */

public enum BehandelStatus {
	IN_ONDERZOEK, IN_BEHANDELING, UITBEHANDELD;
	
	public BehandelStatus getNext(){
		return values()[(ordinal() + 1) % values().length];
	}
}
