package za.co.wethinkcode.app.Main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import za.co.wethinkcode.app.Database.DataBase;
import za.co.wethinkcode.app.View.start.StartViewConsole;

import javax.swing.*;

/**
 * Created By Polite
 * 
 */
public class App
{
        private static JFrame frame;
        private static Scanner scanner;

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if (args.length != 1 || (!args[0].equals("console") && !args[0].equals("gui"))) {
            System.out.println("Usage: program console | gui");
            System.exit(1);
        }

        DataBase.Connect2DataBase();
        DataBase.CreateTable();

        if (args[0].equals("console"))
            new StartViewConsole().start();
//        else if (args[0].equals("gui"))
//            new StartViewGUI().start();
    }

        public static JFrame getFrame() {
        if (frame == null) {
            frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frameListener();
        }
        return frame;
    }

        public static void showFrame() {
        if (frame != null)
            frame.setVisible(true);
    }

        public static void hideFrame() {
        if (frame != null)
            frame.setVisible(false);
    }

        public static Scanner getScanner() {
        if (scanner == null)
            scanner = new Scanner(System.in);
        return scanner;
    }

        public static void closeConnections() throws SQLException {
        DataBase.DisConnect();
        if (scanner != null)
            scanner.close();
    }


        private static void frameListener() {
        getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    closeConnections();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                super.windowClosing(e);
            }
        });
    }
    }

