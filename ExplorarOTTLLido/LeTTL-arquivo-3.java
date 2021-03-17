/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * 2021-03-16
 * Primeiro código que localiza o predicado e o objeto que me interessam 
 * e insere no grafo. Tem algumas coisas para reverter e testar: 
 * - a URI completa na criação do Resource (quero que seja abreviada)
 * - testar com model.add(Statement)
 */

//package jena.examples.rdf ;

import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

import java.io.*;

public class LeTTL extends Object {

    /**
        NOTE that the file is loaded from the class-path and so requires that
        the data-directory, as well as the directory containing the compiled
        class, must be added to the class-path when running this and
        subsequent examples.
    */    
    static final String inputFileName  = "exemplo51.ttl";  // https://jena.apache.org/documentation/io/rdf-input.html#model-usage
                              
    public static void main (String args[]) {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        // read the file
        model.read(inputFileName);
 
        NodeIterator i = model.listObjects();
        
        
        RDFNode noEntity=null;
/*        
        System.out.println ("Lista de Objetos");
        
        while (i.hasNext()) {
            RDFNode noCorrente = i.next();
            System.out.println (noCorrente.toString());
            if (noCorrente.toString().matches("Entity")) noEntity=noCorrente; 
        }                   
*/        
        StmtIterator s = model.listStatements();
        RDFNode noActivity=null;
        Property pType=null;
        
        while (s.hasNext()) {
            Statement st = s.next();
            // System.out.println (st.toString());
            Resource S=st.getSubject();
            Property P=st.getPredicate();
            RDFNode O=st.getObject();
            System.out.println (O.toString());
            if (O.toString().matches(".*Activity")) {
              System.out.println ("ACHEI!" + st.toString());
              noActivity=O; 
              pType=P; // acho que statement com Activity como objeto só tem `S a Activity.`
            }
        }           
        
               // create the resource


        if ((noActivity!=null) && (pType!=null)) {
          System.out.println ("criando minha tripla.");
          // Resource minhaTripla = model.createResource(":12354353");
          Resource minhaTripla = model.createResource("http://example.com/12354353");
          minhaTripla.addProperty(pType, noActivity);
        }

        // write it to standard out
        model.write(System.out);            


    }
}
