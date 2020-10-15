package edu.sumdu.labwork3.model;

import edu.sumdu.labwork3.dao.impl.DaoGoodsTypeIml;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoodsTypeMapper implements RowMapper<GoodsType> {

    public static final String GOOD_TYPE_ID_ROW_NAME = "id";
    public static final String PARENT_ID_ROW_NAME = "parent_id";
    public static final String NAME_ROW_NAME = "name";
    public static final String VENDOR_CODE_ROW_NAME = "vendorcode";
    final static Logger logger = Logger.getLogger(GoodsTypeMapper.class);

    /**
     * @exception IllegalArgumentException if ResultSet is not valid
     * */
    @Override
    public GoodsType mapRow(ResultSet resultSet, int i) throws SQLException {
        boolean isResultSetValid = validateResultSet(resultSet);
        if(!isResultSetValid) {
            throw new IllegalArgumentException();
        }
        // additional LOGGER.trace("The result set is valid !!! :) "); todo
        GoodsType goodsType = new GoodsType();
        goodsType.setVendorCode(resultSet.getString("vendorCode"));
        goodsType.setName(resultSet.getString("name"));
        int parentID = resultSet.getInt("parent_id");
        goodsType.setParent_id(parentID != 0 ? parentID : null);
        // additional LOGGER.info("Converting 0 -> null parentID data from ResultSet"); todo
        goodsType.setId(resultSet.getInt("id"));
        return goodsType;
    }

    /**
     * This method checks input {@link ResultSet} for its validity.
     * <p>
     * A {@code resultSet} considers to be valid in case if it satisfy the requirements below:
     * <ul>
     * <li>It is not empty</li>
     * <li>It must contain {@link #GOOD_TYPE_ID_ROW_NAME} row</li>
     * <li>It must contain {@link #PARENT_ID_ROW_NAME} row</li>
     * <li>It must contain {@link #NAME_ROW_NAME} row</li>
     * <li>It must contain {@link #VENDOR_CODE_ROW_NAME} row</li>
     * </ul>
     * */
    private boolean validateResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Set<String> columnNames = new HashSet<>();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            columnNames.add(metaData.getColumnName(i));
        }
        return columnNames.containsAll(Arrays.asList(GOOD_TYPE_ID_ROW_NAME, PARENT_ID_ROW_NAME, NAME_ROW_NAME, VENDOR_CODE_ROW_NAME));
    }

}
