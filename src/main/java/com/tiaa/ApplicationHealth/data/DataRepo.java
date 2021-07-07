package com.tiaa.ApplicationHealth.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataRepo extends JpaRepository<Data, Long> {
    public List<Data> findByApplicationAppId(Long id);
}
