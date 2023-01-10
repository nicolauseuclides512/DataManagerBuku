/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamanagerbuku.controller;

import datamanagerbuku.database.ConnectionHelper;
import datamanagerbuku.models.Buku;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicoe
 */
public class BukuDataSource {
    public void save(Buku buku) throws SQLException{
        String sql="INSERT INTO buku (judul, pengarang, penerbit, tahun_terbit) VALUES (?,?,?,?)";
        Connection connection = ConnectionHelper.getConnection();
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, buku.getJudulBuku());
        preparedStatement.setString(2, buku.getPengarang());
        preparedStatement.setString(3, buku.getPenerbit());
        preparedStatement.setInt(4, buku.getTahunTerbit());
        
        preparedStatement.executeUpdate();
    }
    
    public void update(Buku buku) throws SQLException{
        String sql="UPDATE buku SET judul=?, pengarang=?, penerbit=?, tahun_terbit=? WHERE id=?";
        Connection connection = ConnectionHelper.getConnection();
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, buku.getJudulBuku());
        preparedStatement.setString(2, buku.getPengarang());
        preparedStatement.setString(3, buku.getPenerbit());
        preparedStatement.setInt(4, buku.getTahunTerbit());
        preparedStatement.setLong(5, buku.getId());
        
        preparedStatement.executeUpdate();
    }
    
    public void delete(Buku buku) throws SQLException{
        String sql="DELEtE FROM buku WHERE id=?";
        Connection connection = ConnectionHelper.getConnection();
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, buku.getId());
        
        preparedStatement.executeUpdate();
    }
    
    public List<Buku> findAll() throws SQLException{
        String sql="SELECT * FROM buku";
        Connection connection = ConnectionHelper.getConnection();
        
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        List<Buku> bukuList = new ArrayList<>();
        while(resultSet.next()){
            Buku buku = new Buku();
            buku.setId(resultSet.getLong("id"));
            buku.setJudulBuku(resultSet.getString("judul"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setPenerbit(resultSet.getString("penerbit"));
            buku.setTahunTerbit(resultSet.getInt("tahun_terbit"));
            bukuList.add(buku);
        }
        return bukuList;
    }
}
