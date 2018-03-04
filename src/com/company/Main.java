/*
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
*/

//package wekaexamples.classifiers;

import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * This example class trains a J48 classifier on a dataset and outputs for
 * a second dataset the actual and predicted class label, as well as the
 * class distribution.
 */
public class OutputClassDistribution {

    /**
     * Expects two parameters: training file and test file.
     *
     * @param args	the commandline arguments
     * @throws Exception	if something goes wrong
     */
    public static void main(String[] args) throws Exception {
        // load data


        //obtenemos el diabetes.arff del directorio en el que está      ESTO NO ES DEL CODIGO ORIGINAL
        DataSource source = new DataSource("/Users/Carlos/Desktop/weka-3-8-1/data/diabetes.arff");


        Instances train = DataSource.read(args[0]);
        train.setClassIndex(train.numAttributes() - 1);
        Instances test = DataSource.read(args[1]);
        test.setClassIndex(test.numAttributes() - 1);
        if (!train.equalHeaders(test))
            throw new IllegalArgumentException(
                    "Train and test set are not compatible: " + train.equalHeadersMsg(test));

        // train classifier
        J48 cls = new J48();
        cls.buildClassifier(train);

        // output predictions
        System.out.println("# - actual - predicted - error - distribution");
        for (int i = 0; i < test.numInstances(); i++) {
            double pred = cls.classifyInstance(test.instance(i));
            double[] dist = cls.distributionForInstance(test.instance(i));
            System.out.print((i+1));
            System.out.print(" - ");
            System.out.print(test.instance(i).toString(test.classIndex()));
            System.out.print(" - ");
            System.out.print(test.classAttribute().value((int) pred));
            System.out.print(" - ");
            if (pred != test.instance(i).classValue())
                System.out.print("yes");
            else
                System.out.print("no");
            System.out.print(" - ");
            System.out.print(Utils.arrayToString(dist));
            System.out.println();
        }
    }
}