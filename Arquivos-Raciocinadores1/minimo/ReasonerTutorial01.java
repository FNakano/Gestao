/*
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.*;
import com.hp.hpl.jena.reasoner.*;
*/
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;
//import org.apache.jena.resoner.*;

public class ReasonerTutorial01 {

	private static String NS = "urn:x-hp-jena:eg/";
	
	public static void main(String args[]) {

	// Build a trivial example data set
	Model rdfsExample = ModelFactory.createDefaultModel();
	Property p = rdfsExample.createProperty(NS, "p");
	Property q = rdfsExample.createProperty(NS, "q");
	rdfsExample.add(p, RDFS.subPropertyOf, q);
	rdfsExample.createResource(NS+"a").addProperty(p, "foo");

	InfModel inf = ModelFactory.createRDFSModel(rdfsExample); 

	Resource a = inf.getResource(NS+"a");
	System.out.println("Statement: " + a.getProperty(q));
	}
}

