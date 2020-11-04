package edu.sumdu.labwork3.mapper;

import edu.sumdu.labwork3.model.GoodsType;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoodsTypeMapper implements RowMapper<GoodsType> {

    public static final String GOODS_TYPE_ID_ROW_NAME = "id";
    public static final String PARENT_ID_ROW_NAME = "parent_id";
    public static final String NAME_ROW_NAME = "name";
    public static final String VENDOR_CODE_ROW_NAME = "vendorcode";
    final static Logger logger = Logger.getLogger(GoodsTypeMapper.class);

    /**
     * @exception IllegalArgumentException if ResultSet is not valid
     * */
    @Override
    public GoodsType mapRow(ResultSet rs, int i) throws SQLException {
        boolean isResultSetValid = validateResultSet(rs);
        if(!isResultSetValid) {
            throw new IllegalArgumentException();
        }
        GoodsType goodsType = new GoodsType();
        goodsType.setVendorCode(rs.getString(VENDOR_CODE_ROW_NAME));
        goodsType.setName(rs.getString(NAME_ROW_NAME));
        int parentID = rs.getInt(PARENT_ID_ROW_NAME);
        goodsType.setParent_id(parentID != 0 ? parentID : null);
        goodsType.setId(rs.getInt(GOODS_TYPE_ID_ROW_NAME));
        logger.info("Successfully converting resultSet to goodsType: " + goodsType.toString());
        return goodsType;
    }

    /**
     * This method checks input {@link ResultSet} for its validity.
     * <p>
     * A {@code resultSet} considers to be valid in case if it satisfy the requirements below:
     * <ul>
     * <li>It is not empty</li>
     * <li>It must contain {@link #GOODS_TYPE_ID_ROW_NAME} row</li>
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
        return columnNames.containsAll(Arrays.asList(
                GOODS_TYPE_ID_ROW_NAME,
                PARENT_ID_ROW_NAME,
                NAME_ROW_NAME,
                VENDOR_CODE_ROW_NAME));
    }
}
