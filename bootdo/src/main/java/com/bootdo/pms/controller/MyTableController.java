package com.bootdo.pms.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.pms.domain.MyTableDO;
import com.bootdo.pms.service.MyTableService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 测试表
 * 
 * @author boge
 * @email 1992lcg@163.com
 * @date 2018-01-31 19:52:09
 */
 
@Controller
@RequestMapping("/pms/myTable")
public class MyTableController {
	@Autowired
	private MyTableService myTableService;
	
	@GetMapping()
	@RequiresPermissions("pms:myTable:myTable")
	String MyTable(){
	    return "pms/myTable/myTable";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("pms:myTable:myTable")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MyTableDO> myTableList = myTableService.list(query);
		int total = myTableService.count(query);
		PageUtils pageUtils = new PageUtils(myTableList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("pms:myTable:add")
	String add(){
	    return "pms/myTable/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("pms:myTable:edit")
	String edit(@PathVariable("id") Long id,Model model){
		MyTableDO myTable = myTableService.get(id);
		model.addAttribute("myTable", myTable);
	    return "pms/myTable/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("pms:myTable:add")
	public R save( MyTableDO myTable){
		if(myTableService.save(myTable)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("pms:myTable:edit")
	public R update( MyTableDO myTable){
		myTableService.update(myTable);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("pms:myTable:remove")
	public R remove( Long id){
		if(myTableService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("pms:myTable:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		myTableService.batchRemove(ids);
		return R.ok();
	}
	
}
