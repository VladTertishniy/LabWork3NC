package edu.sumdu.labwork3.dao.impl;

import edu.sumdu.labwork3.dao.DAO;
import edu.sumdu.labwork3.dao.DaoGoodsType;
import edu.sumdu.labwork3.model.GoodsType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoGoodsTypeIml implements DaoGoodsType {
    private final DAO dao;
    List<GoodsType> goodsTypes;

    public DaoGoodsTypeIml(DAO dao) {
        this.dao = dao;
    }


    @Override
    public void create(GoodsType goodsType) {
        Connection connection = dao.connect();
        try {
            dao.setStatement(connection.prepareStatement("INSERT INTO GoodsType (id, name, parent) VALUES (?, ?, ?)"));
            dao.getStatement().setInt(1, goodsType.getId());
            dao.getStatement().setString(1, goodsType.getName());
            dao.getStatement().setInt(1, goodsType.getId());
            ((PreparedStatement) dao).execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            dao.disconnect();
        }
    }

    @Override
    public List<GoodsType> findAll() {
        Connection connection = dao.connect();
        goodsTypes = new ArrayList<>();
        try {
            dao.setStatement((PreparedStatement) connection.createStatement());
            dao.setResultSet(dao.getStatement().executeQuery("SELECT * FROM GoodsType"));
            while (dao.getResultSet().next()) {
                goodsTypes.add(parseCategory(dao.getResultSet()));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            dao.disconnect();
        }
        return goodsTypes;
    }

    private GoodsType parseCategory(ResultSet resultSet) {
        GoodsType goodsType = null;
        try {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Integer parentId = resultSet.getInt("parentGoodsType");
            goodsType = findGoodsTypeByIdFromList(id);
            if (parentId != null) {
                GoodsType parent = findGoodsTypeByIdFromList(parentId);
                if (parent == null) {
                    parent = new GoodsType(parentId);
                    goodsTypes.add(parent);
                }
                if (goodsType == null) {
                    goodsType = new GoodsType(name, id, parent);
                } else {
                    goodsType.setName(name);
                    goodsType.setParentGoodsType(parent);
                }
            }
            if (goodsType == null) {
                goodsType = new GoodsType(name, id, null);
            } else {
                goodsType.setName(name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return goodsType;
    }

    private GoodsType findGoodsTypeByIdFromList(int id) {
        for (GoodsType goodsType : goodsTypes) {
            if (goodsType.getId() == id) {
                return goodsType;
            }
        }
        return null;
    }
}
