package daos;

import models.ConnectionFactory;
import models.Praetor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PraetorDaoConcrete implements PraetorDao {

    private Connection connection = ConnectionFactory.getConnection();


    private Praetor extractPraetorFromResultSet(ResultSet rs) throws SQLException{
        Praetor praetor = new Praetor();

        praetor.setId(rs.getInt("id"));
        praetor.setPrenomen(rs.getString("prenomen"));
        praetor.setNomen(rs.getString("nomen"));
        praetor.setCognomen(rs.getString("cognomen"));
        praetor.setProvince(rs.getString("province"));
        praetor.setYearAssigned(rs.getInt("year_appointed"));

        return praetor;
    }

    @Override
    public Praetor getPraetorById(Integer id) {

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM praetors WHERE id=" + id);

            if(rs.next()){
                return extractPraetorFromResultSet(rs);
            }
        } catch( SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Praetor> getAllPraetors() {

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM praetors");

            List<Praetor> praetors = new ArrayList<>();
            while(rs.next()){
                Praetor praetor = extractPraetorFromResultSet(rs);
                praetors.add(praetor);
            }

            return praetors;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean insertPraetor(Praetor praetor) {
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO praetors VALUES (NULL, ?, ?, ?, ?, ?)");
            ps.setString(1, praetor.getPrenomen());
            ps.setString(2, praetor.getNomen());
            ps.setString(3, praetor.getCognomen());
            ps.setString(4, praetor.getProvince());
            ps.setInt(5, praetor.getYearAssigned());
            int result = ps.executeUpdate();

            if(result==1){
                return true;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePraetor(Praetor praetor) {
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE praetors SET prenomen=?, nomen=?," +
                    " cognomen=?, province=?, year_appointed=? WHERE id=?");
            ps.setString(1, praetor.getPrenomen());
            ps.setString(2, praetor.getNomen());
            ps.setString(3, praetor.getCognomen());
            ps.setString(4, praetor.getProvince());
            ps.setInt(5, praetor.getYearAssigned());
            ps.setInt(6, praetor.getId());
            int result = ps.executeUpdate();

            if(result==1){
                return true;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePraetorById(Integer id) {
        try{
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("DELETE FROM praetors WHERE id=" + id);

            if(result == 1){
                return true;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
