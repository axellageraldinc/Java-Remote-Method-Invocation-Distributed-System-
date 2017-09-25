package tugas.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataBMI extends Remote {
    public String BMI(String gender, Double tinggi, Double berat) throws RemoteException;
}
