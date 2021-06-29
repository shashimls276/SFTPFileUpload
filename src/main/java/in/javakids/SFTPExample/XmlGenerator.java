/**
 * 
 */
package in.javakids.SFTPExample;

import in.javakids.SFTPExample.model.Address;
import in.javakids.SFTPExample.model.Employee;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 * @author ab68478
 *
 */
public class XmlGenerator {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setAge("20");
		e.setName("shashi");

		Address address = new Address();

		address.setAddressline1("Bangalore");
		address.setCity("Bangalore");

		Set<Address> addr = new HashSet<Address>();
		addr.add(address);
		e.setAddress(addr);

		String xmlContent = jaxbObjectToXML(e);
		System.out.println(xmlContent);
	}

	public static String jaxbObjectToXML(Object object) {
		String xmlContent = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			StringWriter sw = new StringWriter();

			jaxbMarshaller.marshal(object, sw);

			xmlContent = sw.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xmlContent;
	}

}
