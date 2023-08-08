/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.AccountAdmin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUNGVT
 */
public class AccountAdminDAO extends DBContext {

    public AccountAdmin getAccountByUserAndPass(String username, String password) {
        String sql = "select * from Account_Admin where account_username = ? and account_password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                AccountAdmin a = new AccountAdmin();

                a.setAccount_id(rs.getString(1));
                a.setAccount_name(rs.getString(2));
                a.setAccount_username(rs.getString(3));
                a.setAccount_password(rs.getString(4));
                a.setAccount_role(rs.getString(5));
                a.setAccount_email(rs.getString(6));
                a.setAccount_phone(rs.getString(7));
                a.setAccount_avatar(rs.getString(8));

                return a;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public AccountAdmin getAccountById(String id) {
        String sql = "select * from Account_Admin where account_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(id));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AccountAdmin a = new AccountAdmin();

                a.setAccount_id(rs.getString(1));
                a.setAccount_name(rs.getString(2));
                a.setAccount_username(rs.getString(3));
                a.setAccount_password(rs.getString(4));
                a.setAccount_role(rs.getString(5));
                a.setAccount_email(rs.getString(6));
                a.setAccount_phone(rs.getString(7));
                a.setAccount_avatar(rs.getString(8));

                return a;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public AccountAdmin getAccountByUsername(String username) {
        String sql = "select * from Account_Admin where account_username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AccountAdmin a = new AccountAdmin();

                a.setAccount_id(rs.getString(1));
                a.setAccount_name(rs.getString(2));
                a.setAccount_username(rs.getString(3));
                a.setAccount_password(rs.getString(4));
                a.setAccount_role(rs.getString(5));
                a.setAccount_email(rs.getString(6));
                a.setAccount_phone(rs.getString(7));
                a.setAccount_avatar(rs.getString(8));

                return a;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<AccountAdmin> getAllAccount() {
        List<AccountAdmin> acc = new ArrayList<>();
        String sql = "select * from Account_Admin";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AccountAdmin a = new AccountAdmin();

                a.setAccount_id(rs.getString(1));
                a.setAccount_name(rs.getString(2));
                a.setAccount_username(rs.getString(3));
                a.setAccount_password(rs.getString(4));
                a.setAccount_role(rs.getString(5));
                a.setAccount_email(rs.getString(6));
                a.setAccount_phone(rs.getString(7));
                a.setAccount_avatar(rs.getString(8));

                acc.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return acc;
    }

    public void insertAccount(String name, String username, String password, String role) {
        String sql = "INSERT INTO [dbo].[Account_Admin]\n"
                + "           ([account_name]\n"
                + "           ,[account_username]\n"
                + "           ,[account_password]\n"
                + "           ,[account_role]\n"
                + "           ,[account_email]\n"
                + "           ,[account_phone]\n"
                + "           ,[account_avatar])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, username);
            st.setString(3, password);
            st.setInt(4, Integer.parseInt(role));
            st.setString(5, null);
            st.setString(6, null);
            st.setString(7, null);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void upadateAccount(String name, String username, String password, String role, String email, String phone, String avatar, String id, String mode) {
        String sql = "UPDATE [dbo].[Account_Admin]\n";

        if (mode.equals("accupdate")) {
            sql += " SET [account_username] = ?\n"
                    + ",[account_password] = ?\n"
                    + ",[account_role] = ?\n";
        }
        if (mode.equals("profileupdate")) {
            sql += "SET [account_name] = ?\n"
                    + ",[account_email] = ?\n"
                    + ",[account_phone] = ?\n"
                    + ",[account_avatar] = ?\n";
        }

        sql += " WHERE [account_id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            if (mode.equals("accupdate")) {
                st.setString(1, username);
                st.setString(2, password);
                st.setInt(3, Integer.parseInt(role));
                st.setInt(4, Integer.parseInt(id));
            }
            if (mode.equals("profileupdate")) {
                st.setString(1, name);
                st.setString(2, email);
                st.setString(3, phone);
                st.setString(4, avatar);
                st.setInt(5, Integer.parseInt(id));
            }

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAccount(String id) {
        String sql = "DELETE FROM [dbo].[Account_Admin]\n"
                + "      WHERE [account_id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(id));

            st.execute();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        AccountAdminDAO ad = new AccountAdminDAO();
        ad.updateProfile("123", "123456789", "sua@gmail.com", "hehe", "5");
    }

    public void updateProfile(String account_password, String account_phone, String account_email, String account_avatar, String account_id) {
        String sql = "UPDATE [dbo].[Account_Admin]\n"
                + "   SET [account_password] = ?\n"
                + "      ,[account_email] = ?\n"
                + "      ,[account_phone] = ?\n"
                + "      ,[account_avatar] = ?\n"
                + " WHERE account_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, account_password);
            st.setString(2, account_email);
            st.setString(3, account_phone);
            st.setString(4, account_avatar);
            st.setString(5, account_id);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
