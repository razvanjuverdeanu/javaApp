package JsonApp;


import com.google.gson.Gson;
import models.qaEmployee;
import models.Employee;
import models.devEmployee;
import models.tlQa;
import models.tlDev;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.json.JsonObject;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;

/**
 * Created by razvan.juverdeanu on 11/24/15.
 */
@Path("/app")
public class Json {


    @Path("/add")
    @GET
    @Produces("application/json")
    public JsonObject add(@QueryParam("name") String name, @QueryParam("surname") String surname, @QueryParam("cnp") String cnp, @QueryParam("city") String city, @QueryParam("address") String address, @QueryParam("occupation") String occupation, @QueryParam("level") String level) {
        if (name != null && surname != null && cnp != null) {
           // System.out.println(name + surname);


            if (occupation == null) {
                JsonObject object = javax.json.Json.createObjectBuilder().add("Please fill occupation", new Integer(401)).build();
                return object;
            } else if (occupation.equalsIgnoreCase("qa")) {


                qaEmployee qaemp = new qaEmployee(name, surname, cnp, city, address, level, occupation);
                DB.qaEmployeesList.add(qaemp);


                JsonObject object = javax.json.Json.createObjectBuilder().add("Qa added", new Integer(200)).build();
                return object;

            } else if (occupation.equalsIgnoreCase("dev")) {


                devEmployee devemp = new devEmployee(name, surname, cnp, city, address, level, occupation);
                DB.devEmployeesList.add(devemp);

                JsonObject object = javax.json.Json.createObjectBuilder().add("Dev added", new Integer(200)).build();
                return object;
            }




        } else {

            JsonObject object = javax.json.Json.createObjectBuilder().add("Error", new Integer(401)).add("Missing param", "name,surname,cnp are mandatory").build();
            return object;

        }
        JsonObject object = javax.json.Json.createObjectBuilder().build();
        return object;

    }


    @Path("/view")
    @GET
    @Produces("application/json")
    public String view(@QueryParam("show") String show) {


        if (show.equals("all")) {

            ArrayList listaQa = DB.getQaEmployeesList();
            ArrayList listaDev = DB.getDevEmployeesList();
            ArrayList listaALL = new ArrayList();
            listaALL.addAll(listaQa);
            listaALL.addAll(listaDev);

            Gson gson = new Gson();
            String resJson1 = gson.toJson(listaALL);
            return resJson1;
        } else if (show.equals("qa")) {
            ArrayList lista = DB.getQaEmployeesList();
            Gson gson = new Gson();
            String resJson = gson.toJson(lista);
            return resJson;
        } else if (show.equals("dev")) {
            ArrayList lista = DB.getDevEmployeesList();
            Gson gson = new Gson();
            String resJson = gson.toJson(lista);
            return resJson;
        } else {
            Gson gson = new Gson();
            String resJson = gson.toJson("give a filter qa /dev");
            return resJson;
        }

    }



    @Path("filter")
    @GET
    @Produces("application/json")
    public String filter(@QueryParam("name") String name, @QueryParam("surname") String surname, @QueryParam("cnp") String cnp, @QueryParam("city") String city, @QueryParam("address") String address, @QueryParam("Level") String Level,@QueryParam("occupation") String occupation) {


        if (name != null) {
            ArrayList<Employee> rezultateALLEmp = new ArrayList<Employee>();
            rezultateALLEmp = DB.getALLEmployeesList();
            ArrayList<Employee> resultsList = new ArrayList<Employee>();


            for (int i = 0; i < rezultateALLEmp.size(); i++) {

                if (name.equals(rezultateALLEmp.get(i).getName())) {
                    if (rezultateALLEmp.get(i).getOccupation().equals("qa")) {
                        qaEmployee resultEmployee = new qaEmployee(rezultateALLEmp.get(i).getName(), rezultateALLEmp.get(i).getSurname(), rezultateALLEmp.get(i).getCNP(), rezultateALLEmp.get(i).getCity(), rezultateALLEmp.get(i).getAddress(), rezultateALLEmp.get(i).getLevel(), rezultateALLEmp.get(i).getOccupation());
                        resultsList.add(resultEmployee);

                    } else {
                        devEmployee resultEmployee = new devEmployee(rezultateALLEmp.get(i).getName(), rezultateALLEmp.get(i).getSurname(), rezultateALLEmp.get(i).getCNP(), rezultateALLEmp.get(i).getCity(), rezultateALLEmp.get(i).getAddress(), rezultateALLEmp.get(i).getLevel(), rezultateALLEmp.get(i).getOccupation());
                        resultsList.add(resultEmployee);
                    }
                }
            }


            Gson gson = new Gson();
            String resJson = gson.toJson(resultsList);
            try {
                return resJson;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                resultsList.clear();
                rezultateALLEmp.clear();
            }
        } else {
            Gson gson = new Gson();
            String resJson = gson.toJson("Enter name  to filter");
            return resJson;
        }

     return "Something went wrong";
    }

    @Path("update")
    @GET
    @Produces("application/json")
    public String Update(@QueryParam("name") String name, @QueryParam("updateto") String updatename, @QueryParam("surname") String surname, @QueryParam("cnp") String cnp, @QueryParam("city") String city, @QueryParam("address") String address, @QueryParam("Level") String Level,@QueryParam("occupation") String occupation){
        ArrayList<Employee> employeeArrayListAll = new ArrayList<Employee>();
        employeeArrayListAll = DB.getALLEmployeesList();

        int capacity = employeeArrayListAll.size();

        if(name != null){


        for(int j=0;j<capacity;j++){

            if(name.equals(employeeArrayListAll.get(j).getName())) {

                if(employeeArrayListAll.get(j).getOccupation().equals("qa")){
                    for(int i=0;i<DB.qaEmployeesList.size();i++){
                    if(updatename != null) {
                        if(name.equals(DB.qaEmployeesList.get(i).getName())) {
                            qaEmployee updateQAdemp = new qaEmployee(updatename, DB.qaEmployeesList.get(i).getSurname(), DB.qaEmployeesList.get(i).getCNP(), DB.qaEmployeesList.get(i).getCity(), DB.qaEmployeesList.get(i).getAddress(), DB.qaEmployeesList.get(i).getLevel(), DB.qaEmployeesList.get(i).getOccupation());
                            DB.qaEmployeesList.set(i, updateQAdemp);
                            }


                        }
                    }
                }
                if(employeeArrayListAll.get(j).getOccupation().equals("dev")){
                        for(int i=0;i<DB.devEmployeesList.size();i++){
                            if(updatename != null) {
                                if(name.equals(DB.devEmployeesList.get(j).getName())) {
                                    devEmployee updateDevdemp = new devEmployee(updatename, DB.devEmployeesList.get(i).getSurname(), DB.devEmployeesList.get(i).getCNP(), DB.devEmployeesList.get(i).getCity(), DB.devEmployeesList.get(i).getAddress(), DB.devEmployeesList.get(i).getLevel(), DB.devEmployeesList.get(i).getOccupation());
                                    DB.devEmployeesList.set(i, updateDevdemp);
                                }
                            }
                        }
                }
            }
        }
        System.out.println(DB.qaEmployeesList);

        Gson gson = new Gson();
        String resJson = gson.toJson("Updated, new values :"+ DB.qaEmployeesList);
        return resJson;

    }else{
        Gson gson = new Gson();
        String rezjson = gson.toJson("Converted to other occupation: " + employeeArrayListAll);
        return rezjson;
    }

    }

    @Path("convert")
    @GET
    @Produces("application/json")
    public String convertStatut(@QueryParam("name") String name, @QueryParam("convertto") String convertto, @QueryParam("surname") String surname, @QueryParam("cnp") String cnp, @QueryParam("city") String city, @QueryParam("address") String address, @QueryParam("Level") String Level,@QueryParam("occupation") String occupation){
    ArrayList<Employee> employeeArrayListAll = new ArrayList<Employee>();
    employeeArrayListAll = DB.getALLEmployeesList();
    int capacity = DB.getALLEmployeesList().size();

        if(name != null){

            for (int j=0; j<capacity; j++){

                if(name.equals(employeeArrayListAll.get(j).getName())){

                    if(employeeArrayListAll.get(j).getOccupation().equals("qa")){
                        for(int i=0; i<DB.qaEmployeesList.size(); i++){

                            if(convertto != null){
                                if(name.equals(DB.qaEmployeesList.get(i).getName())){
                                    if(convertto != DB.qaEmployeesList.get(i).getOccupation()) {
                                        qaEmployee qaEmp = new qaEmployee(DB.qaEmployeesList.get(i).getName(), DB.qaEmployeesList.get(i).getSurname(), DB.qaEmployeesList.get(i).getCNP(), DB.qaEmployeesList.get(i).getCity(), DB.qaEmployeesList.get(i).getAddress(), DB.qaEmployeesList.get(i).getLevel(), convertto);
                                        DB.qaEmployeesList.set(i, qaEmp);
                                    }else{
                                        Gson gson = new Gson();
                                        String rezjson = gson.toJson("You're trying to set the same occupation");
                                        return rezjson;
                                    }
                                }
                            }

                        }

                    }
                    if(employeeArrayListAll.get(j).getOccupation().equals("dev")){
                        for (int i =0 ; i<DB.devEmployeesList.size(); i++){
                            if(convertto != null){
                                if(name.equals(DB.devEmployeesList.get(i).getName())){
                                    if(convertto != null){
                                        devEmployee devEmp = new devEmployee(DB.devEmployeesList.get(i).getName(),DB.devEmployeesList.get(i).getSurname(),DB.devEmployeesList.get(i).getCNP(),DB.devEmployeesList.get(i).getCity(),DB.devEmployeesList.get(i).getAddress(),DB.devEmployeesList.get(i).getLevel(),convertto);
                                        DB.devEmployeesList.set(i,devEmp);
                                    }else{
                                        Gson gson = new Gson();
                                        String rezjson = gson.toJson("You're trying to set the same occupation");
                                        return rezjson;
                                    }
                                }
                            }
                        }

                    }
                }

            }
            Gson gson = new Gson();
            String rezjson=gson.toJson("Converted to other occupation: " +employeeArrayListAll);
            return  rezjson;

        }
        Gson gson = new Gson();
        String rezjson=gson.toJson("Convert not set");
        return  rezjson;


    }


}


