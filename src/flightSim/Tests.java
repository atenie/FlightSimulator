package flightSim;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@RunWith(JUnit4.class)
public class Tests {
    @Test
    public void readInputTest() {
        Scanner in = null;
        String s;
        try {
            in = new Scanner(new File("input/scenario.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(in);
        in.close();
    }

    @Test
    public void readOutputTest() {
        Scanner in = null;
        String s;
        try {
            in = new Scanner(new File("simulation.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(in);
        in.close();
    }
}
