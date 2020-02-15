package com.atguigu.dao;
import org.springframework.stereotype.Repository;
/**
* @author 作者： 马振坤 
* @version 
* @email 524991368@qq.com
* @date 创建时间：2018年3月24日 下午5:41:56
* @desc 类说明：名字默认是类名首字母小写
 */
@Repository
public class BookDao {
	private String lable = "1";
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	@Override
	public String toString() {
		return "BookDao [lable=" + lable + "]";
	}
}
