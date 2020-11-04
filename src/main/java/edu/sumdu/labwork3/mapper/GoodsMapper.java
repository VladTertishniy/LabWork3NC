package edu.sumdu.labwork3.mapper;

import edu.sumdu.labwork3.model.Goods;
import edu.sumdu.labwork3.model.GoodsType;
import edu.sumdu.labwork3.model.Supplier;
import edu.sumdu.labwork3.model.User;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class GoodsMapper implements RowMapper<Goods> {

    public static final String USER_ID_ROW_NAME = "user_id";
    public static final String USER_NAME_ROW_NAME = "user_name";
    public static final String USER_PASSWORD_ROW_NAME = "user_password";
    public static final String SUPPLIER_FIRSTNAME_ROW_NAME = "supplier_firstname";
    public static final String SUPPLIER_LASTNAME_ROW_NAME = "supplier_lastname";
    public static final String SUPPLIER_PHONENUMBER_ROW_NAME = "supplier_phonenumber";
    public static final String SUPPLIER_EMAIL_ROW_NAME = "supplier_email";
    public static final String SUPPLIER_ORGANIZATION_ROW_NAME = "supplier_organization";
    public static final String GOODS_ID_ROW_NAME = "goods_id";
    public static final String GOODS_NAME_ROW_NAME = "goods_name";
    public static final String GOODS_PRICE_ROW_NAME = "goods_price";
    public static final String GOODS_SUPPLIER_ID_ROW_NAME = "goods_supplier_id";
    public static final String GOODS_TYPE_ID_ROW_NAME = "goodstype_id";
    public static final String GOODS_TYPE_NAME_ROW_NAME = "goodstype_name";
    public static final String GOODS_TYPE_PARENT_ID_ROW_NAME = "goodstype_parent_id";
    public static final String GOODS_VENDORCODE_ROW_NAME = "goodstype_vendorcode";
    final static Logger logger = Logger.getLogger(GoodsTypeMapper.class);

    /**
     * @exception IllegalArgumentException if ResultSet is not valid
     * */
    @Override
    public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
        boolean isResultSetValid = validateResultSet(rs);
        if(!isResultSetValid) {
            throw new IllegalArgumentException();
        }
        User user = new User();
        user.setUser_id(rs.getInt(USER_ID_ROW_NAME));
        user.setPassword(rs.getString(USER_PASSWORD_ROW_NAME));
        user.setUsername(rs.getString(USER_NAME_ROW_NAME));
        Supplier supplier = new Supplier();
        supplier.setUser(user);
        supplier.setEmail(rs.getString(SUPPLIER_EMAIL_ROW_NAME));
        supplier.setFirstname(rs.getString(SUPPLIER_FIRSTNAME_ROW_NAME));
        supplier.setLastname(rs.getString(SUPPLIER_LASTNAME_ROW_NAME));
        supplier.setOrganization(rs.getString(SUPPLIER_ORGANIZATION_ROW_NAME));
        supplier.setPhoneNumber(rs.getString(SUPPLIER_PHONENUMBER_ROW_NAME));
        GoodsType goodsType = new GoodsType();
        goodsType.setId(rs.getInt(GOODS_TYPE_ID_ROW_NAME));
        int goodsTypeParenId = rs.getInt(GOODS_TYPE_PARENT_ID_ROW_NAME);
        goodsType.setParent_id(goodsTypeParenId != 0 ? goodsTypeParenId : null );
        goodsType.setName(rs.getString(GOODS_TYPE_NAME_ROW_NAME));
        goodsType.setVendorCode(rs.getString(GOODS_VENDORCODE_ROW_NAME));
        Goods goods = new Goods();
        goods.setPrice(rs.getFloat(GOODS_PRICE_ROW_NAME));
        goods.setGoodsType(goodsType);
        goods.setId(rs.getInt(GOODS_ID_ROW_NAME));
        goods.setName(rs.getString(GOODS_NAME_ROW_NAME));
        goods.setSupplier(supplier);
        logger.info("Successfully converting resultSet to supplier: " + supplier.toString());
        return goods;
    }

    /**
     * This method checks input {@link ResultSet} for its validity.
     * <p>
     * A {@code resultSet} considers to be valid in case if it satisfy the requirements below:
     * <ul>
     * <li>It is not empty</li>
     * <li>It must contain {@link #USER_ID_ROW_NAME} row</li>
     * <li>It must contain {@link #USER_NAME_ROW_NAME} row</li>
     * <li>It must contain {@link #USER_PASSWORD_ROW_NAME} row</li>
     * <li>It must contain {@link #SUPPLIER_FIRSTNAME_ROW_NAME} row</li>
     * <li>It must contain {@link #SUPPLIER_LASTNAME_ROW_NAME} row</li>
     * <li>It must contain {@link #SUPPLIER_PHONENUMBER_ROW_NAME} row</li>
     * <li>It must contain {@link #SUPPLIER_EMAIL_ROW_NAME} row</li>
     * <li>It must contain {@link #SUPPLIER_ORGANIZATION_ROW_NAME} row</li>
     * <li>It must contain {@link #GOODS_ID_ROW_NAME} row</li>
     * <li>It must contain {@link #GOODS_NAME_ROW_NAME} row</li>
     * <li>It must contain {@link #GOODS_PRICE_ROW_NAME} row</li>
     * <li>It must contain {@link #GOODS_SUPPLIER_ID_ROW_NAME} row</li>
     * <li>It must contain {@link #GOODS_TYPE_ID_ROW_NAME} row</li>
     * <li>It must contain {@link #GOODS_TYPE_NAME_ROW_NAME} row</li>
     * <li>It must contain {@link #GOODS_TYPE_PARENT_ID_ROW_NAME} row</li>
     * <li>It must contain {@link #GOODS_VENDORCODE_ROW_NAME} row</li>
     * </ul>
     * */
    private boolean validateResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Set<String> columnNames = new HashSet<>();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            columnNames.add(metaData.getColumnName(i));
            logger.info(metaData.getColumnName(i));
        }
        logger.info(Arrays.asList(
                USER_ID_ROW_NAME,
                USER_NAME_ROW_NAME,
                USER_PASSWORD_ROW_NAME,
                SUPPLIER_FIRSTNAME_ROW_NAME,
                SUPPLIER_LASTNAME_ROW_NAME,
                SUPPLIER_PHONENUMBER_ROW_NAME,
                SUPPLIER_EMAIL_ROW_NAME,
                SUPPLIER_ORGANIZATION_ROW_NAME,
                GOODS_ID_ROW_NAME,
                GOODS_NAME_ROW_NAME,
                GOODS_PRICE_ROW_NAME,
                GOODS_SUPPLIER_ID_ROW_NAME,
                GOODS_TYPE_ID_ROW_NAME,
                GOODS_TYPE_NAME_ROW_NAME,
                GOODS_TYPE_PARENT_ID_ROW_NAME,
                GOODS_VENDORCODE_ROW_NAME
        ).toString());
        return columnNames.containsAll(Arrays.asList(
                USER_ID_ROW_NAME,
                USER_NAME_ROW_NAME,
                USER_PASSWORD_ROW_NAME,
                SUPPLIER_FIRSTNAME_ROW_NAME,
                SUPPLIER_LASTNAME_ROW_NAME,
                SUPPLIER_PHONENUMBER_ROW_NAME,
                SUPPLIER_EMAIL_ROW_NAME,
                SUPPLIER_ORGANIZATION_ROW_NAME,
                GOODS_ID_ROW_NAME,
                GOODS_NAME_ROW_NAME,
                GOODS_PRICE_ROW_NAME,
                GOODS_SUPPLIER_ID_ROW_NAME,
                GOODS_TYPE_ID_ROW_NAME,
                GOODS_TYPE_NAME_ROW_NAME,
                GOODS_TYPE_PARENT_ID_ROW_NAME,
                GOODS_VENDORCODE_ROW_NAME
        ));
    }
}
