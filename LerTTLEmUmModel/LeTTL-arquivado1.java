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
 * Baixado de https://jena.apache.org/tutorials/rdf_api.html#ch-Reading-RDF e
 * modificado inspirado em 
 * https://jena.apache.org/documentation/io/rdf-input.html#model-usage
 * para criar um modelo a partir de um arquivo ttl.
 * o arquivo exemplo51.ttl é uma cópia do exemplo de
 * https://www.w3.org/TR/prov-o/#Association
 * 
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

        InputStream in = FileManager.get().open( inputFileName );
        if (in == null) {
            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
        }
        
        // read the file
        model.read(in, "");
                    
        // write it to standard out
        model.write(System.out);            
    }
}
