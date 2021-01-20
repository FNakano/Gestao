
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

import org.apache.jena.riot.*;      // https://jena.apache.org/documentation/javadoc/arq/org/apache/jena/riot/RDFDataMgr.html

import org.apache.jena.reasoner.*;     // https://www.javatips.net/api/org.apache.jena.reasoner.validityreport.report

import java.util.Iterator;   // https://www.w3schools.com/java/java_iterator.asp


public class Validador1 {


    static final String inputFileName  = "vc-db-1.rdf"; // do tutorial 5 de Jena
	
    public static void main(String args[]) {


        Model data = RDFDataMgr.loadModel(inputFileName);
        InfModel infmodel = ModelFactory.createRDFSModel(data);
        ValidityReport validity = infmodel.validate();
        if (validity.isValid()) {
            System.out.println("OK");
        } else {
            System.out.println("Conflicts");
            for (Iterator i = validity.getReports(); i.hasNext(); ) {
                System.out.println(" - " + i.next());
            }
        }
    }
}

