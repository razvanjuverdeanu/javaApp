package models;

import JsonApp.DB;

import java.util.ArrayList;

/**
 * Created by razvan.juverdeanu on 11/24/15.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        Employee emp = new Employee("Ion", "Gica", "123", "Iasi", "Str.Eminescu", "1", "Trainee");
        employeeList.add(emp);
        System.out.println(employeeList);

        ArrayList<qaEmployee> qaemployee = new ArrayList<qaEmployee>();
        qaEmployee qaemp = new qaEmployee("Razvan", "Qa", "124", "Iasi", "Str.Lotrului", "unior", "qa");
        qaemployee.add(qaemp);

        ArrayList<devEmployee> devemp = new ArrayList<devEmployee>();
        devEmployee developer = new devEmployee("Razvan", "Popa", "125", "Iasi", "Str.Nicolina", "middle level", "dev");
        devemp.add(developer);

        ArrayList<tlQa> tlqa = new ArrayList<tlQa>();
        tlQa teamleadQa = new tlQa("Razvan", "Ionescu", "126", "Iasi", "Str.Pacurari", "junior level", "Coordonate Team QA 2", "team lead qa");
        tlqa.add(teamleadQa);

        ArrayList<tlDev> tldev = new ArrayList<tlDev>();
        tlDev teamleadDev = new tlDev("Razvan", "Popescu", "127", "Iasi", "Str.Bucium", "junior level", "Coordonate Team Dev 1 ", "team lead dev");
        tldev.add(teamleadDev);

        ArrayList<ProjectM> pm = new ArrayList<ProjectM>();
        ProjectM projectmanager = new ProjectM("Razvan", "Cozma", "128", "Iasi", "Str.Silvestru", "Project GroupOn","1", "Project manager");
        pm.add(projectmanager);


        qaEmployee qaempx = new qaEmployee("qaxx","contrax","123","Iasi","Eminescu","5","qa");
        devEmployee devempx = new devEmployee("devxx","contrax","123","Iasi","Eminescu","5","qa");

        DB.qaEmployeesList.add(qaempx);
        DB.devEmployeesList.add(devempx);

        System.out.println("/n");
        System.out.println(DB.qaEmployeesList);

}
}


