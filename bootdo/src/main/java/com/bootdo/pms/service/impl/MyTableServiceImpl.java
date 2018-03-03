package com.bootdo.pms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.pms.dao.MyTableDao;
import com.bootdo.pms.domain.MyTableDO;
import com.bootdo.pms.service.MyTableService;



@Service
public class MyTableServiceImpl implements MyTableService {
	@Autowired
	private MyTableDao myTableDao;
	
	@Override
	public MyTableDO get(Long id){
		return myTableDao.get(id);
	}
	
	@Override
	public List<MyTableDO> list(Map<String, Object> map){
		return myTableDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return myTableDao.count(map);
	}
	
	@Override
	public int save(MyTableDO myTable){
		return myTableDao.save(myTable);
	}
	
	@Override
	public int update(MyTableDO myTable){
		return myTableDao.update(myTable);
	}
	
	@Override
	public int remove(Long id){
		return myTableDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return myTableDao.batchRemove(ids);
	}
	
}
