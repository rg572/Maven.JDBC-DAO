import daos.PraetorDaoConcrete;
import models.Praetor;

import java.util.List;

public class AppRunner {

    public static void main(String[] args) {
        PraetorDaoConcrete praetorDao= new PraetorDaoConcrete();

        System.out.println("TESTING GET ALL");
        List<Praetor> praetorList = praetorDao.getAllPraetors();
        System.out.println(praetorListToString(praetorList));

        System.out.println("TESTING GETBYID");
        Praetor praetor = praetorDao.getPraetorById(1);
        System.out.println(praetorToString(praetor));

        /*System.out.println("\nTESTING INSERT");
        praetor = new Praetor("Camillus", "Maelius", "Indaletius", "Illyricum", 107);
        praetorDao.insertPraetor(praetor);
        praetorList = praetorDao.getAllPraetors();
        System.out.println(praetorListToString(praetorList));

        System.out.println("TESTING UPDATE");
        praetor = new Praetor(4,"Aulus", "Vibenius","Hesychius","Noricum",111);
        praetorDao.updatePraetor(praetor);
        praetorList = praetorDao.getAllPraetors();
        System.out.println(praetorListToString(praetorList));*/

        System.out.println("TESTING DELETE");
        praetorDao.deletePraetorById(5);
        praetorList = praetorDao.getAllPraetors();
        System.out.println(praetorListToString(praetorList));
    }

    public static String praetorToString(Praetor p){
        return String.format("id %d: %s %s %s, Governor of %s, appointed in %d",
                p.getId(), p.getPrenomen(), p.getNomen(), p.getCognomen(), p.getProvince(), p.getYearAssigned());
    }

    public static String praetorListToString(List<Praetor> list){
        StringBuilder sbuild = new StringBuilder();
        for(Praetor p : list){
            sbuild.append(praetorToString(p)).append("\n");
        }
        return sbuild.toString();
    }
}
