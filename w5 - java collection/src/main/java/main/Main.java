package main;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.Employee;
import util.ICsvReader;
import util.ICsvWriter;

public class Main {
    public static void main(final String[] args) {
	final ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
	final ICsvReader reader = (ICsvReader) context.getBean("csvReader");
	final ICsvWriter writer = (ICsvWriter) context.getBean("CsvWriter");
	final Set<Employee> empSet = reader.read();
	System.out.println(" File has been written at : " + writer.write(empSet));

    }
}
