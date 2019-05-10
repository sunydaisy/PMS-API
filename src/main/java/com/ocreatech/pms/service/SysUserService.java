package com.ocreatech.pms.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.ocreatech.pms.entity.basic.ResponseDataVO;
import com.ocreatech.pms.entity.basic.ResponseStatus;
import com.ocreatech.pms.entity.basic.UserVO;
import com.ocreatech.pms.mapper.UserMapper;
import com.ocreatech.pms.model.TbUser;
import com.ocreatech.pms.utils.TokenTool;

@Service
public class SysUserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private HttpServletRequest req;
	
    /**
     * 用户登录
     * @param params
     * @return
     */
	@Transactional(rollbackFor = Exception.class)
	public ResponseDataVO<Object> login(UserVO params) {
		// 通过用户名和密码查询用户是否存在
		List<TbUser> userList = userMapper.findNameAndPwd(params.getUserName(), params.getPassWord());
		if (userList.isEmpty()) {
			return ResponseDataVO.fail(ResponseStatus.NOT_EXIT);
		}
		// 通过用户名称查看缓存中是否有用户信息
		TbUser user = userList.get(0);
		String token = (String) req.getSession().getAttribute(user.getUserCode());
		if(StringUtils.hasText(token)) {
			return ResponseDataVO.success(token);
		}
		// 生成token
		token = TokenTool.creatToken();
		// 通过token查询缓存中是否有用户信息，否，则将用户信息放入缓存
		Object cacheUser = req.getSession().getAttribute(token);
		if(cacheUser == null) {
			req.setAttribute(user.getUserCode(), token);
			req.setAttribute(token, user);
		}
		// token持久化
		userMapper.updateUserToken(user.getId(),token);
		return ResponseDataVO.success(token);
	}

}
