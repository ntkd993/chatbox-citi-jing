package com.citi.innovation.nlp.tools;

import java.io.IOException;
import java.io.InputStream;

import com.citi.innovation.nlp.NLPConfig;

import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

public class CBLemmatizer {
	public static String[] tags(String[] tokens) {
		try {
			InputStream posModelIn = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(NLPConfig.LIMMATIZER);

			POSModel posModel = new POSModel(posModelIn);
			POSTaggerME posTagger = new POSTaggerME(posModel);
			String tags[] = posTagger.tag(tokens);
			return tags;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String[] lemmatize(String[] tokens, String[] tags) {
		try {
			InputStream dictLemmatizer = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(NLPConfig.LIMMATIZER);
			DictionaryLemmatizer lemmatizer = new DictionaryLemmatizer(dictLemmatizer);
			
			String[] lemmas = lemmatizer.lemmatize(tokens, tags);
			return lemmas;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
