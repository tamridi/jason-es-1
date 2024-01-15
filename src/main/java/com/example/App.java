package com.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Alunno a1 = new Alunno("Claudio", "Benvenuti", new Date(1979,9,22));
        Alunno a2 = new Alunno("Gino", "Stino", new Date(2000,9,24));
        Alunno a3 = new Alunno("Pino", "Agostino", new Date(1999,7,8));
        Alunno a4 = new Alunno("Franco", "Panco", new Date(1987,8,12));

        ArrayList <Alunno> arrayAlunni= new ArrayList<Alunno>();

        arrayAlunni.add(a1);
        arrayAlunni.add(a2);
        arrayAlunni.add(a3);
        arrayAlunni.add(a4);

        Classe c1 = new Classe(2, "A", "aula 2", arrayAlunni);


        XmlMapper xmlMapper = new XmlMapper();
        String s1 = xmlMapper.writeValueAsString(c1);
        xmlMapper.writeValue(new File("test.xml"), c1);

        Classe c2 = xmlMapper.readValue(new File("test.xml"), Classe.class);
        System.out.println(c2.aula);
        System.out.println(c2.numero);
        System.out.println(c2.sezione);

    }
}

