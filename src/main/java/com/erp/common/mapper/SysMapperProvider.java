package com.erp.common.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.scripting.xmltags.MixedSqlNode;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.scripting.xmltags.StaticTextSqlNode;

import com.github.abel533.mapper.MapperProvider;
import com.github.abel533.mapperhelper.EntityHelper;
import com.github.abel533.mapperhelper.MapperHelper;

public class SysMapperProvider extends MapperProvider {

	public SysMapperProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}

	// 这些方法就是为了生成 sql 语句用的
	/**
	 * 参数说明: SqlNode:mybatis 提供一个 sql 语句的载体. 通过 sqlNode 对象包含sql 语句. 则最终执行时提取sql
	 * 
	 * MappedStatement:mybatis 提供的内置资源配置通过对象可以灵活的获取当前正在执行的方法的具体参数和路径
	 * 
	 * @param ms
	 * @return
	 */
	public SqlNode deleteByIDS(MappedStatement ms) {
		Class<?> entityClass = getSelectReturnType(ms);
		Set<EntityHelper.EntityColumn> entityColumns = EntityHelper.getPKColumns(entityClass);
		EntityHelper.EntityColumn column = null;
		for (EntityHelper.EntityColumn entityColumn : entityColumns) {
			column = entityColumn;
			break;
		}

		List<SqlNode> sqlNodes = new ArrayList<SqlNode>();
		// 开始拼sql
		BEGIN();
		// delete from table
		DELETE_FROM(tableName(entityClass));
		// 得到sql
		String sql = SQL();
		// 静态SQL部分
		sqlNodes.add(new StaticTextSqlNode(sql + " WHERE " + column.getColumn() + " IN "));
		// 构造foreach sql
		SqlNode foreach = new ForEachSqlNode(ms.getConfiguration(),
				new StaticTextSqlNode("#{" + column.getProperty() + "}"), "ids", "index", column.getProperty(), "(",
				")", ",");
		sqlNodes.add(foreach);
		return new MixedSqlNode(sqlNodes);
	}

}
