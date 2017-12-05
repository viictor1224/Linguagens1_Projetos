/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thomazerlach.CadastroAluno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author thomazerlach
 */
public class CsvFileWriter {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ";";
    private static final String NEW_LINE_SEPARATOR = "\n";
    
    //Student attributes index
    private static final int ALUNO_NOME = 0;
    private static final int ALUNO_IDADE = 1;
    private static final int ALUNO_END = 2;
    private static final int ALUNO_RG = 3;
    private static final int ALUNO_CPF = 4;

     
    //CSV file header
    private static final String FILE_HEADER = "nome;idade;endereco;rg;cpf";
    
    private static final List alunos = new ArrayList();
    
    public static void addToList(Person aluno){
    
        alunos.add(aluno);
        
    }
    
    public static List getAlunos () {
        return alunos;
    }
    
    public static Boolean writeCsvFile(String fileName) {
        
        Boolean retorno = false;
     
        FileWriter fileWriter = null;

       try {
            fileWriter = new FileWriter(fileName);
 
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
             
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
             
            //Write a new student object list to the CSV file
            for (Iterator it = alunos.iterator(); it.hasNext();) {
                Person aluno = (Person) it.next();
                fileWriter.append(String.valueOf(aluno.getNome()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(aluno.getIdade());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(aluno.getEndereco());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(aluno.getRg());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(aluno.getCpf());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
   
            System.out.println("CSV file was created successfully !!!");
            retorno = true;
            
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
             
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }    
        }
       return retorno;
    }
    
    public static Boolean readCsvFile(String fileName) {
        
        Boolean retorno = false;
    
        BufferedReader fileReader = null;
    
        try {
        
            alunos.clear();
            
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));
             
            //Read the CSV file header to skip it
            fileReader.readLine();
             
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new student object and fill his  data
                    Person aluno = new Person();
                    aluno.setNome(tokens[ALUNO_NOME]);
                    aluno.setIdade(tokens[ALUNO_IDADE]);
                    aluno.setEndereco(tokens[ALUNO_END]);
                    aluno.setRg(tokens[ALUNO_RG]); 
                    aluno.setCpf(tokens[ALUNO_CPF]);
                    alunos.add(aluno);
                }
                
            }
            retorno = true;
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return retorno;
    
    }
}
