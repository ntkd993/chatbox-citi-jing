package com.citi.innovation.nlp.tools;

import java.io.IOException;
import java.io.InputStream;

import com.citi.innovation.nlp.NLPConfig;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class CBTokenizer {
	public static String[] tokens(String input){
		try {
			InputStream tokenModelIn = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(NLPConfig.TOKENS);
			
			TokenizerModel tokenModel = new TokenizerModel(tokenModelIn);
			Tokenizer tokenizer = new TokenizerME(tokenModel);
			String tokens[] = tokenizer.tokenize(input);
			return tokens;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
