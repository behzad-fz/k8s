package com.behzadfz.user.service;

import com.behzadfz.user.VO.ResponseTemplateVO;
import com.behzadfz.user.entity.Department;
import com.behzadfz.user.entity.User;
import com.behzadfz.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO findUserById(Long id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findUserById(id);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
