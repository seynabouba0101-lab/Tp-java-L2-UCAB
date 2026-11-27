package DAO;
import config.connexion;
import model.proprietaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class proprietaireDAO {
    public proprietaire rechercherProprietaire(int id){

        String sql ="SELECT id,nom,pronom,adersse from proprietaire where  id= ?";

        try (Connection cn = connexion.ouvrir();
            PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1,id);
                ResultSet rs = ps.executeQuery(

            }
    } catch (SQLException ex) {
            System.out.println("Erreur:" + ex.getMessage());
        }
        return  null;
        }
}
