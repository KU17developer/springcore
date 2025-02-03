package com.bs.spring.common;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringArrayTypeHandler implements TypeHandler<String[]> {

    @Override
    public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
        // 저장하는 부분
        if(parameter != null && parameter.length > 0) {
            // String.join(",", parameter) : 파라미터를 쉼표로 구분한 문자열로 만들어서 주면된다.
            ps.setString(i, String.join(",", parameter));
        } else {
            // typefornull 해놨으니깐 null 집어넣는것도 가능
            ps.setString(i, null);
        }
    }

    @Override
    public String[] getResult(ResultSet rs, String columnName) throws SQLException {
        String lang = rs.getString(columnName);
        if(lang != null) {
            return lang.split(",");
        }else return null;
    }

    @Override
    public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
        String lang = rs.getString(columnIndex);
        if(lang != null) {
            return lang.split(",");
        }else return null;
    }

    @Override
    public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String lang = cs.getString(columnIndex);
        if(lang != null) {
            return lang.split(",");
        }else return null;
    }
}
