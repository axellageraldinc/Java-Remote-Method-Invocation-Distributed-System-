package tugas.rmi;

import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            DataBMI stub = (DataBMI) registry.lookup("DataBMI");
           String gender = JOptionPane.showInputDialog("Masukkan jenis kelamin anda (L/P)");
           String berat = JOptionPane.showInputDialog("Masukkan berat badan anda (kg)");
           String tinggi = JOptionPane.showInputDialog("Masukkan tinggi badan anda (dalam cm)");
            // System.out.print("Masukkan gender (L/P) : ");
            // String gender = System.console().readLine();
            // System.out.print("Masukkan tinggi badan (cm) : ");
            // String tinggi = System.console().readLine();
            String statusBadan = stub.BMI(gender, Double.parseDouble(tinggi), Double.parseDouble(berat));
            System.out.println("Status tubuh anda : " + statusBadan);
           JOptionPane.showMessageDialog(null, "Status tubuh anda : " + statusBadan);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
