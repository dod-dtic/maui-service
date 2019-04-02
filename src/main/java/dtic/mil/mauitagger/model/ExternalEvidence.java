/**
 * Filename: ExternalEvidence.java
 * Description: POJO Class.
 * 
 * Copyright: This file cannot be released, distributed or copied without the written 
 * permission of the Defense Technical Information Center (DTIC)
 * 
 *  
 * @author The Defense Technical Information Center
 * @version 1.0, 09/19/2017
 * 
 */
package dtic.mil.mauitagger.model;

public class ExternalEvidence {
	private String name;
	private String id;
	private double score;

	public ExternalEvidence() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
