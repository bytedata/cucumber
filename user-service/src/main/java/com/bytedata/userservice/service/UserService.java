package com.bytedata.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bytedata.userservice.entity.User;
import com.bytedata.userservice.repository.UserRepository;
import com.bytedata.userservice.vo.Department;
import com.bytedata.userservice.vo.ResponseTemplateVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public ResponseTemplateVo geUserWithDepartment(Long userId) {
		ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
		User user = userRepository.findByUserId(userId);

		Department department = restTemplate.getForObject("http://DEPT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);
		responseTemplateVo.setUser(user);
		responseTemplateVo.setDepartment(department);
		return responseTemplateVo;
	}

}
