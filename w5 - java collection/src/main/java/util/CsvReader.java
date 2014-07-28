package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("csvReader")
public class CsvReader implements ICsvReader {

    @Value("${inputFile_Name}")
    private String fileName;
    @Value("${delimiter}")
    private String delimiter;

    public Set<Employee> read() {

	BufferedReader br = null;
	String line = "";
	StringTokenizer st = null;
	final Set<Employee> empSet = new TreeSet<Employee>();
	try {
	    final URI uri = ClassLoader.getSystemResource(fileName).toURI();
	    br = new BufferedReader(new FileReader(uri.getPath()));
	    while ((line = br.readLine()) != null) {

		// use comma as separator
		st = new StringTokenizer(line, delimiter);
		try {
		    final String fn = st.nextToken();
		    final String ln = st.nextToken();
		    final String idString = st.nextToken();
		    final String skill = st.nextToken();
		    final String loc = st.nextToken();
		    if (!"".equals(fn.trim()) && !"".equals(idString)) {
			final Employee emp = new Employee(fn, ln, Long.parseLong(idString), skill, loc);
			empSet.add(emp);
		    }
		} catch (final Exception ae) {
		    continue;
		}
	    }

	} catch (final FileNotFoundException e) {
	    e.printStackTrace();
	} catch (final IOException e) {
	    e.printStackTrace();
	} catch (final URISyntaxException e) {
	    e.printStackTrace();
	} finally {
	    if (br != null) {
		try {
		    br.close();
		} catch (final IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	return empSet;
    }
}
