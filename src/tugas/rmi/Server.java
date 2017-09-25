package tugas.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements DataBMI {

    protected Server() throws RemoteException {
        super();
    }

    @Override
    public String BMI(String gender, Double tinggi, Double berat) throws RemoteException {
        Double BMI;
        String statusBadan = "";
        BMI = (berat/((tinggi/100)*(tinggi/100)));
        if (gender.equals("L")){
            if (BMI<17){
                statusBadan="KURUS";
            }
            else if(BMI>=17 && BMI<23){
                statusBadan="NORMAL";
            }
            else if(BMI>=23 && BMI<27){
                statusBadan="GEMUK";
            }
            else{
                statusBadan="OBESITAS";
            }
        } else if (gender.equals("P")){
            if (BMI<18){
                statusBadan="KURUS";
            }
            else if(BMI>=18 && BMI<25){
                statusBadan="NORMAL";
            }
            else if(BMI>=25 && BMI<27){
                statusBadan="GEMUK";
            }
            else{
                statusBadan="OBESITAS";
            }
        }
        return statusBadan;
    }

    public static void main(String[] args) {
        try{
            Server obj = new Server();
            DataBMI stub = (DataBMI) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("DataBMI", stub);
            System.out.println("SERVER READY");
        } catch (Exception ex){
            System.out.println("Server error : " + ex.toString());
            ex.printStackTrace();
        }
    }
}
