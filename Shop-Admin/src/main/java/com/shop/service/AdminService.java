package com.shop.service;

import com.shop.domain.Admin;

import java.util.List;

public interface AdminService {
    Integer addAdmin(Admin admin);
    List<Admin> selectAll();
}
