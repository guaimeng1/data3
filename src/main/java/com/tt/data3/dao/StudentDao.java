package com.tt.data3.dao;

import com.tt.data3.pojo.Grade;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

public interface StudentDao extends PagingAndSortingRepository<Grade,Integer>{

}
