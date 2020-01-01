package com.sincere.candy3.dao;

import com.sincere.candy3.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class PetDaoImpl implements PetDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Pet> getAllPetsFromDB() {
        String sql = String.format("select * from pet;");
        List list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return list;
    }
    @Override
    public List<Pet> testSelectFromDB() throws SQLException {
        String[] colName = {"name", "owner", "species", "sex", "birth", "death"};
        String tableName = "pet";
        return select(colName, tableName);
    }

    @Override
    public List<Pet> testInsertFromDB() throws SQLException {
        String tableName = "pet";
        String[] colName = {"name", "owner", "species", "sex", "birth", "death"};
        String[] values1 = {"Puffball6", "Diane6", "hamster6", "m", "1991-01-01", "2200-01-01"};
        String[] values2 = {"Puffball7", "Diane7", "hamster7", "f", "1994-01-01", "2400-01-01"};
        insert(tableName, colName, values1);
        insert(tableName, values2);
        return select(colName, tableName);
    }

    @Override
    public List<Pet> testUpdateFromDB() throws SQLException {
        String tableName = "pet";
        String[] colName = {"name", "owner", "species", "sex", "birth", "death"};
        String[] setColName = {"owner", "species"};
        String[] setValues = {"Diane0", "hamster0"};
        String[] conColName = {"name", "owner", "sex"};
        String[] conValues = {"Puffball", "Diane2", "f"};
        String[] con = {"or", "or"};
        update(tableName, setColName, setValues, conColName, conValues, con);
        return select(colName, tableName);
    }

    @Override
    public List<Pet> testDeleteFromDB() throws SQLException {
        String tableName = "pet";
        String[] colName = {"name", "owner", "species", "sex", "birth", "death"};
        String[] conColName = {"name", "owner"};
        String[] conValues = {"Puffball7", "Diane6"};
        String[] con = {"or"};
        delete(tableName, conColName, conValues, con);
        return select(colName, tableName);
    }

    public List<Pet> select(String[] colName, String tableName) throws SQLException {
        StringBuilder sql = new StringBuilder("select ");
        for(int i = 0; i < colName.length - 1; i++) {
            sql.append(colName[i]);
            sql.append(", ");
        }
        sql.append(colName[colName.length - 1]);
        sql.append(" from ");
        sql.append(tableName);
        sql.append(";");
        System.out.println(sql);
        List result = jdbcTemplate.queryForList(String.valueOf(sql));
        return result;
    }

    public void insert(String tableName, String[] colName, String[] values) throws SQLException {
        StringBuilder sql = new StringBuilder("insert into ");
        sql.append(tableName);
        sql.append(" (");
        for(int i = 0; i < colName.length - 1; i++) {
            sql.append(colName[i]);
            sql.append(", ");
        }
        sql.append(colName[colName.length - 1]);
        sql.append(") values('");
        for(int i = 0; i < values.length - 1; i++) {
            sql.append(values[i]);
            sql.append("', '");
        }
        sql.append(values[values.length - 1]);
        sql.append("');");
        System.out.println(sql);
        int flag = jdbcTemplate.update(String.valueOf(sql));
        if(flag > 0)
            System.out.println("Successfully Inserted");
        else
            System.out.println("Insert Failed");
    }

    public void insert(String tableName, String[] values) throws SQLException {
        StringBuilder sql = new StringBuilder("insert into ");
        sql.append(tableName);
        sql.append(" values('");
        for(int i = 0; i < values.length - 1; i++) {
            sql.append(values[i]);
            sql.append("', '");
        }
        sql.append(values[values.length - 1]);
        sql.append("');");
        System.out.println(sql);
        int flag = jdbcTemplate.update(String.valueOf(sql));
        if(flag > 0)
            System.out.println("Successfully Inserted");
        else
            System.out.println("Insert Failed");
    }

    public void update(String tableName, String[] setColName, String[] setValues, String[] conColName, String[] conValues, String[] con) throws SQLException {
        StringBuilder sql = new StringBuilder("update ");
        sql.append(tableName);
        sql.append(" set ");
        for(int i = 0; i < setColName.length - 1; i++) {
            sql.append(setColName[i]);
            sql.append(" = '");
            sql.append(setValues[i]);
            sql.append("', ");
        }
        sql.append(setColName[setColName.length - 1]);
        sql.append(" = '");
        sql.append(setValues[setValues.length - 1]);
        sql.append("' where ");
        for(int i = 0; i < conColName.length - 1; i++) {
            sql.append(conColName[i]);
            sql.append(" = '");
            sql.append(conValues[i]);
            sql.append("' ");
            sql.append(con[i]);
            sql.append(" ");
        }
        sql.append(conColName[conColName.length - 1]);
        sql.append(" = '");
        sql.append(conValues[conValues.length - 1]);
        sql.append("';");
        System.out.println(sql);
        int flag = jdbcTemplate.update(String.valueOf(sql));
        if(flag > 0)
            System.out.println("Successfully Updated");
        else
            System.out.println("Update Failed");
    }

    public void delete(String tableName, String[] conColName, String[] conValues, String[] con) throws SQLException {
        StringBuilder sql = new StringBuilder("delete from ");
        sql.append(tableName);
        sql.append(" where ");
        for(int i = 0; i < conColName.length - 1; i++) {
            sql.append(conColName[i]);
            sql.append(" = '");
            sql.append(conValues[i]);
            sql.append("' ");
            sql.append(con[i]);
            sql.append(" ");
        }
        sql.append(conColName[conColName.length - 1]);
        sql.append(" = '");
        sql.append(conValues[conValues.length - 1]);
        sql.append("';");
        System.out.println(sql);
        int flag = jdbcTemplate.update(String.valueOf(sql));
        if(flag > 0)
            System.out.println("Successfully Deleted");
        else
            System.out.println("Delete Failed");
    }
}
