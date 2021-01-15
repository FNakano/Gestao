/**
 *
 */
//package tr.com.srdc.ontmalizer.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tr.com.srdc.ontmalizer.XSD2OWLMapper;

public class MinhaClasse {
    public static void main(String[] args) throws Exception {

        // This part converts XML schema to OWL ontology.
        XSD2OWLMapper mapping = new XSD2OWLMapper(new File("indoorgmlnavi.xsd"));
        mapping.setObjectPropPrefix("");
        mapping.setDataTypePropPrefix("");
        mapping.convertXSD2OWL();

        // This part prints the ontology to the specified file.
        FileOutputStream ont;
//        try {
            File f = new File("indoorgmlnavi.owl");
//             f.getParentFile().mkdirs();
            ont = new FileOutputStream(f);
//            mapping.writeOntology(ont, "N3");
            mapping.writeOntology(ont, "RDF/XML");
            ont.close();
//        } catch (Exception e) {
//            LOGGER.error("{}", e.getMessage());
//        }
    }
}

