/**
 * Filename: MauiTagController.java
 * Description: Controller class that handles the Restful Web Service POST request.
 * 
 * Copyright: This file cannot be released, distributed or copied without the written 
 * permission of the Defense Technical Information Center (DTIC)
 * 
 *  
 * @author The Defense Technical Information Center
 * @version 1.0, 09/19/2017
 * 
 */
package dtic.mil.mauitagger.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.configuration.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dtic.mil.mauitagger.entity.TagRequest;
import dtic.mil.mauitagger.manager.MauiManager;
import dtic.mil.mauitagger.model.ExternalEvidence;

@RestController
@RequestMapping(value = { "/api/mauitagger" })
public class MauiTagController {

	final private Logger log = LoggerFactory.getLogger(MauiTagController.class);

	@Resource
	MauiManager mauiManager;

	public MauiTagController() {
		log.info("MauiTagController");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getTags", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<ExternalEvidence> getTags(@RequestBody TagRequest request)
			throws ConfigurationException {
		List<ExternalEvidence> results = null;
		int count = request.getCount();

		if (count <= 0) {
			count = 50;
		}

		String text = request.getSampleText();
		if (text.length() > 5) {
			results = mauiManager.getRelated(request.getSampleText(), count);
		}
		
		return results;
	}

}
