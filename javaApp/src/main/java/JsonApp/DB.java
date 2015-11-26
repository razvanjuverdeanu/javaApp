package JsonApp;
import models.Employee;
import models.devEmployee;
import models.qaEmployee;

import java.util.ArrayList;

/**
 * Created by razvan.juverdeanu on 11/24/15.
 */
public class DB {

        public static ArrayList<qaEmployee> qaEmployeesList = new ArrayList<qaEmployee>();
        public static ArrayList<devEmployee> devEmployeesList = new ArrayList<devEmployee>();
       public static  ArrayList listaALL = new ArrayList();

    public static ArrayList<Employee> getALLEmployeesList() {


    listaALL.addAll(getQaEmployeesList());
    listaALL.addAll(getDevEmployeesList());
        return listaALL;
    }


    public static ArrayList<qaEmployee> getQaEmployeesList() {
        return qaEmployeesList;
    }

    public static ArrayList<devEmployee> getDevEmployeesList() {
        return devEmployeesList;
    }

//    public void addToList(String whichList, String name, String surname, String CNP, String city, String address, String level, String occupation){
//        if (whichList.equals("qaList")) {
//            qaEmployee qaEmp = new qaEmployee(name, surname,  CNP,  city,  address, level, occupation);
//            qaEmployeesList.add(qaEmp);
//        }else{
//            devEmployee devEmp = new devEmployee(name, surname,  CNP,  city,  address, level, occupation);
//            devEmployeesList.add(devEmp);
//        }

    }
//       public ArrayList readList(String whichList) {
//           if (whichList.equals("qaList")) {
//               return
//           }else{
//               return
//           }
//       }


