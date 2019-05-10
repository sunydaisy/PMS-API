package com.ocreatech.pms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ocreatech.pms.model.TbUser;

@Mapper
public interface UserMapper {

	@Select("select * from tb_user where user_name = #{userName} and pass_word = #{passWord}")
	List<TbUser> findNameAndPwd(@Param("userName") String userName,@Param("passWord") String passWord);

	@Update("update tb_user set acess_token = #{token} where id = #{id}")
	int updateUserToken(@Param("token")Long id, @Param("id")String token);

}
