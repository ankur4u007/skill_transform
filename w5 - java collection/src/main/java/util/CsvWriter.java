package util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("CsvWriter")
public class CsvWriter implements ICsvWriter {

    @Value("${outputFile_Name}")
    private String fileName;

    public String write(final Set<Employee> empSet) {
	BufferedWriter bw = null;
	String path = null;
	try {
	    final URI uri = ClassLoader.getSystemResource(fileName).toURI();
	    path = uri.getPath();
	    bw = new BufferedWriter(new FileWriter(path));
	    for (final Employee emp : empSet) {
		bw.write(emp.toCSV());

	    }

	} catch (final FileNotFoundException e) {
	    e.printStackTrace();
	} catch (final IOException e) {
	    e.printStackTrace();
	} catch (final URISyntaxException e) {
	    e.printStackTrace();
	} finally {
	    if (bw != null) {
		try {
		    bw.close();
		} catch (final IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	return path;
    }
}
