/**
 * Filename: MauiManager.java
 * Description: The class that interfaces with the open source Maui library
 * 
 * Copyright: This file cannot be released, distributed or copied without the written 
 * permission of the Defense Technical Information Center (DTIC)
 * 
 *  
 * @author The Defense Technical Information Center
 * @version 1.0, 09/19/2017
 * 
 */
package dtic.mil.mauitagger.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.entopix.maui.main.MauiWrapper;
import com.entopix.maui.stemmers.SremovalStemmer;
import com.entopix.maui.stopwords.StopwordsEnglish;
import com.entopix.maui.util.Topic;
import com.entopix.maui.vocab.Vocabulary;
import com.entopix.maui.vocab.VocabularyStoreFactory;
import com.entopix.maui.vocab.VocabularyStore_HT;

import dtic.mil.mauitagger.model.ExternalEvidence;

public class MauiManager {

	final static private Logger log = LoggerFactory
			.getLogger(MauiManager.class);

	private MauiWrapper mauiWrapper;
	private Configuration _configuration;
	private Configuration taggerOptions;
	private Vocabulary loadedVocab;

	private String vocabularyPath = null;
	private String modelPath = null;

	public MauiManager(String mauiVocab, String mauiModel) {
		this.vocabularyPath = mauiVocab;
		this.modelPath = mauiModel;

		loadMauiWrapper();
	}

	private void loadMauiWrapper() {

		if (vocabularyPath == null) {
			vocabularyPath = "/d2/config/mauitagger/dtic_thes.rdf";
		}

		if (modelPath == null) {
			modelPath = "/d2/config/mauitagger/dtic_maui_model";
		}

		mauiWrapper = null;
		try {
			// Use default stemmer, stopwords and language
			SremovalStemmer stemmer = new SremovalStemmer();

			VocabularyStoreFactory
					.setPrefferedVocabStoreType(VocabularyStore_HT.class);

			mauiWrapper = new MauiWrapper(modelPath, vocabularyPath, "skos",
					null, stemmer, "en");
			mauiWrapper.setModelParameters(vocabularyPath, stemmer, null, "en");

		} catch (Exception e) {
			log.error("Problem while loading and initializing vocabulary and model\n"
					+ e);
			throw new RuntimeException();
		}
	}

	public List<ExternalEvidence> getRelated(String text, int topicsPerDocument) {
		List<ExternalEvidence> results = new ArrayList<ExternalEvidence>();
		try {
			List<Topic> topics = new ArrayList<Topic>();
			topics = mauiWrapper.extractTopicsFromTextAsResults(text,
					topicsPerDocument);
			for (Topic t : topics) {
				ExternalEvidence e = new ExternalEvidence();
				e.setId(t.getId());
				e.setName(t.getTitle());
				e.setScore(t.getProbability());

				results.add(e);
			}

		} catch (Exception e) {
			log.error("Exception extracting topics {}", e);
			throw new RuntimeException();
		}

		return results;
	}

}