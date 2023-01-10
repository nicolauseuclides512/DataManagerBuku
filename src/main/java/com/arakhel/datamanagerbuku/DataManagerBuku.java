/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.arakhel.datamanagerbuku;

import datamanagerbuku.database.ConnectionHelper;
import datamanagerbuku.ui.DataManagerBukuForm;
import java.sql.SQLException;
import javax.swing.SwingUtilities;

/**
 *
 * @author nicoe
 */
public class DataManagerBuku {
    private static void testConnection(){
        try {
            ConnectionHelper.getConnection();
            System.out.println("Database Connected");
        } catch (SQLException ex) {
            System.out.println("Failed to connect database");
        }
    }
    
    public static void main(String[] args) {
        testConnection();
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                DataManagerBukuForm form = new DataManagerBukuForm();
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }
        });
    }
}
