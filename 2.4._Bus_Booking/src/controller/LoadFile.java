/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Bus;

/**
 *
 * @author Admin
 */
public class LoadFile {
    public List<Bus> readBusFromFile(String filePath) {
        List<Bus> listBus = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|\\s*");
                if (data.length == 6) {
                    Bus b = new Bus();
                    b.setBcode(data[0].trim());
                    b.setBus_name(data[1].trim());
                    b.setSeat(Integer.parseInt(data[2].trim()));
                    b.setBooked(Integer.parseInt(data[3].trim()));
                    b.setDepart_time(Double.parseDouble(data[4].trim()));
                    b.setArrival_time(Double.parseDouble(data[5].trim()));
                    listBus.add(b);
                }
            }
        } catch (IOException e) {
        }

        return listBus;
    }
}
