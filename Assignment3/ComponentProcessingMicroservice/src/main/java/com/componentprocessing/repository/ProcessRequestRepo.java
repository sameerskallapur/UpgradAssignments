package com.componentprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.componentprocessing.entity.ProcessRequest;


public interface ProcessRequestRepo extends JpaRepository<ProcessRequest, Integer>{

}
