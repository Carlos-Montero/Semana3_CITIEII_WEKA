package com.company;
import weka.core.Instances;
import java.io.BufferedReader;
import java.io.FileReader;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import java.util.Random;
import weka.core.Instances;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;


public class Main {
    public static void main(String[] args) {

        //obtenemos el diabetes.arff del directorio en el que está
        DataSource source = new DataSource("/Users/Carlos/Desktop/weka-3-8-1/data/diabetes.arff");
        Instances data = source.getDataSet();

        //en el diabetes.arff, la clase está en el último atributo (test positive or negative)
        if (data.classIndex() == -1)
            data.setClassIndex(data.numAttributes() - 1);

















    }
}
