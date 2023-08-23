package com.example.demo.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.notice.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

}
