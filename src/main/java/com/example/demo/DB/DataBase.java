package com.example.demo.DB;

import com.example.demo.Catalog.Wood;
import com.example.demo.Catalog.WoodContainer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private static String DB_PATCH = "/db/Products.db";
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
    public void Connect(){
        try {
            Resource res = new ClassPathResource(DB_PATCH);
            connection = DriverManager.getConnection("jdbc:sqlite:" + res.getFile().getPath());
            statement = connection.createStatement();
            statement.execute("CREATE TABLE if not exists 'CLAPBOARD' ('NAME'  TEXT,'IMG'   TEXT,'THICKNESS' REAL,'LONG'  REAL,'WIDTH' REAL,'SORT'  TEXT,'FORM'  TEXT,'PRICE' INTEGER);");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
    public WoodContainer Update() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM CLAPBOARD");
        WoodContainer wc = new WoodContainer();
        while (resultSet.next()){
            Wood wood = new Wood();
            wood.setName(resultSet.getString("NAME"));
            wood.setImage(resultSet.getString("IMG"));
            wood.setThickness(resultSet.getFloat("THICKNESS"));
            wood.setLong(resultSet.getFloat("LONG"));
            wood.setWidth(resultSet.getFloat("WIDTH"));
            wood.setSort(resultSet.getString("SORT"));
            wood.setForm(resultSet.getString("FORM"));
            wood.setPrice(resultSet.getInt("PRICE"));

            wc.add(wood);
        }
        return wc;
    }
    public void Update(ArrayList<Wood> AllWood) throws SQLException {
        statement.execute("DELETE FROM 'CLAPBOARD'");
        for(int i = 0; i < AllWood.size();i++){
            System.out.println(AllWood.get(i).getForm());
            statement.execute("INSERT INTO 'CLAPBOARD' ('NAME', 'IMG', 'THICKNESS', 'LONG', 'WIDTH', 'SORT', 'FORM', 'PRICE') VALUES ('"+AllWood.get(i).getName()+"', '"+AllWood.get(i).getImage()+"', '"+AllWood.get(i).getThickness()+"', '"+AllWood.get(i).getLong()+"', '"+AllWood.get(i).getWidth()+"', '"+AllWood.get(i).getSort()+"', '"+AllWood.get(i).getForm()+"', '"+AllWood.get(i).getPrice()+"') ; ");
        }

    }
    public void CloseDB() throws SQLException{
    connection.close();
    statement.close();
    resultSet.close();

    }
}
