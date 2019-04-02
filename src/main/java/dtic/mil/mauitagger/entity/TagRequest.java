/**
 * Filename: TagRequest.java
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

package dtic.mil.mauitagger.entity;

import java.util.HashMap;
import java.util.Map;

public class TagRequest {
	private static final long serialVersionUID = 1L;

	private int count = 50;
	private String sampleText;

	public TagRequest() {

	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	public String getSampleText() {
		return sampleText;
	}

	public void setSampleText(String sampleText) {
		this.sampleText = sampleText;
	}

}
