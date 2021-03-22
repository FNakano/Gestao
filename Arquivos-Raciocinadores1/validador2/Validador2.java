
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

import org.apache.jena.riot.*;      // https://jena.apache.org/documentation/javadoc/arq/org/apache/jena/riot/RDFDataMgr.html

import org.apache.jena.reasoner.*;     // https://www.javatips.net/api/org.apache.jena.reasoner.validityreport.report

import java.util.Iterator;   // https://www.w3schools.com/java/java_iterator.asp


public class Validador2 {


    static String inputFileName  = "indoorgml.owl"; // convertido pelo ontmalizer
	
    public static void main(String args[]) {

        if (args.length!=1) {
            System.out.println(" ... Validador2 <arq_entrada>");
            System.exit(0);
        }

        Model data = RDFDataMgr.loadModel(args[0]);   // havia um bug aqui!
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

