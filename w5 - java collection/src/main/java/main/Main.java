package main;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.CsvReader;
import util.CsvWriter;
import util.Employee;

public class Main {
    public static void main(final String[] args) {
	final ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
	final CsvReader reader = (CsvReader) context.getBean("csvReader");
	final CsvWriter writer = (CsvWriter) context.getBean("CsvWriter");
	final Set<Employee> empSet = reader.read();
	System.out.println(" File has been written at : " + writer.write(empSet));

    }
}
