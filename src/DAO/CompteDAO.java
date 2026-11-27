package DAO;

import config.connexion;
import model.compte;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteDAO {

    // AJOUTER
    public void ajouter(compte c) {
        String sql = "INSERT INTO compte (numero, solde, type, id_proprietaire) VALUES (?, ?, ?, ?)";
        try (Connection cn = connexion.ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, c.getNumero());
            ps.setDouble(2, c.getSolde());
            ps.setInt(3, c.getProprietaire_id());
            ps.executeUpdate();
            System.out.println("Compte ajouté avec succès");
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout", e);
        }
    }

    // RECHERCHER
    public compte rechercher(String numero) {
        String sql = "SELECT * FROM compte WHERE numero = ?";
        compte c = null; // <-- ici on initialise à null, plus d'erreur
        try (Connection cn = connexion.ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new compte(
                        rs.getString("numero"),
                        rs.getDouble("solde"),
                        rs.getInt("proprietaire_id")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la recherche", e);
        }
        return c;
    }

    // MODIFIER
    public void modifier(compte c) {
        String sql = "UPDATE compte SET solde = ?, type = ? WHERE numero = ?";
        try (Connection cn = connexion.ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setDouble(1, c.getSolde());
            ps.setString(2, c.getProprietaire_id());
            ps.setString(3, c.getNumero());
            ps.executeUpdate();
            System.out.println("Compte modifié");
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la modification", e);
        }
    }

    // SUPPRIMER
    public void supprimer(String numero) {
        String sql = "DELETE FROM compte WHERE numero = ?";
        try (Connection cn = connexion.ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, numero);
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("Compte supprimé avec succès");
            } else {
                System.out.println("Compte introuvable");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression", e);
        }
    }

    // LISTER
    public List<compte> lister() {
        List<compte> liste = new ArrayList<>();
        String sql = "SELECT * FROM compte";
        try (Connection cn = connexion.ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                compte c = new compte(
                        rs.getString("numero"),
                        rs.getDouble("solde"),
                        rs.getInt("proprietaire_id")
                );
                liste.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du listing", e);
        }
        return liste;
    }
}