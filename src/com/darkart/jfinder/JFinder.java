package com.darkart.jfinder;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class JFinder {

	public static void main(String[] args) {
		String query = args.length > 0 ? args[0] : ".*";
		String searchPath = args.length > 1 ? args[1] : ".";
		String ignore = args.length > 2 ? args[2] : "\\.svn";
		
		final Matcher matcher = buildMatcher(query);
		final Matcher ignorer = buildIgnorer(ignore);
		
		long startTime = Calendar.getInstance().getTimeInMillis();
		
		new ClasspathResource(searchPath.split(File.pathSeparator)).traverse(new Visitor() {
			
			@Override
			public void visit(List<Node> path, Node node) {
				if (matcher.match(path, node)) {
					System.out.println(path);
				}
			}
		}, ignorer);
		
		long endTime = Calendar.getInstance().getTimeInMillis();
		long duration = endTime - startTime;
		System.out.println("# Search finished! Took " + (duration > 1E3 ? duration/1E3 + " sec." : duration + " ms."));
	}

	private static Matcher buildIgnorer(String ignore) {
		Matcher ignorer = new FileNameMatcher();
		ignorer.setQuery(ignore);
		return ignorer;
	}

	private static Matcher buildMatcher(String query) {
		Matcher nMatcher = new FileNameMatcher();
		nMatcher.setQuery(query);
		Matcher cMatcher = new FileContentMatcher();
		cMatcher.setQuery(query);
		CompositeMatcher m = new CompositeMatcher();
		m.setMatchers(Arrays.asList(nMatcher, cMatcher));
		return m;
	}

}
