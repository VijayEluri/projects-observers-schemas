package org.andwellness.grammar.custom;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.andwellness.grammar.parser.ConditionParser;
import org.andwellness.grammar.parser.ParseException;
import org.andwellness.grammar.syntaxtree.sentence;

/**
 * A validator for conditions that relies on classes generated from JavaCC and JTB to parse and retrieve data from condition
 * sentences.  
 * 
 * @author selsky
 */
public final class ConditionValidator {
	
	/**
	 * Prevent instantiation.
	 */
	private ConditionValidator() {
		
	}
	
	/**
	 * For command line use for testing. Provide the condition to be validated as the first argument. The condition must be a
	 * double-quoted string.
	 */
	public static void main(String args[]) throws IOException, ConditionParseException {
		Map<String, List<String>> map = validate(args[0]);
		System.out.println(map);
	}
	
	/**
	 * Validates the provided condition sentence.
	 * 
	 * @param conditionSentence
	 * @return Map of id-value list pairs for each id-operation-value in the provided sentence
	 * @throws ConditionParseException if the sentence does not conform to our grammar (see spec/condition-grammar.jj) 
	 */
	public static Map<String, List<String>> validate(String conditionSentence) {
		sentence s = null;
		
		try {
			
			s = new ConditionParser(new StringReader(conditionSentence)).sentence(); // the JavaCC classes use some strange
			                                                                         // programming conventions 
			ConditionDepthFirst<Map<String, List<String>>> visitor = new ConditionDepthFirst<Map<String, List<String>>>();
			Map<String, List<String>>map = new HashMap<String, List<String>>(); 
			visitor.visit(s, map);
			return map;
			
		} catch (ParseException pe) {
			
			throw new ConditionParseException("Condition parse failed for condition sentence: " + conditionSentence, pe);
		}
	}
}
