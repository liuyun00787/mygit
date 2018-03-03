package com.bootdo.pms.service;

import com.bootdo.pms.domain.MyTableDO;

import java.util.List;
import java.util.Map;

/**
 * 测试表
 * 
 * @author boge
 * @email 1992lcg@163.com
 * @date 2018-01-31 19:52:09
 */
public interface MyTableService {
	
	MyTableDO get(Long id);
	
	List<MyTableDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MyTableDO myTable);
	
	int update(MyTableDO myTable);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
