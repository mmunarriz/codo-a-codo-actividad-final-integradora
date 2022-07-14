package com.codoacodo.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codoacodo.spring.datajpa.model.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
	List<Club> findByPublished(boolean published);
	List<Club> findByTitleContaining(String title);
}
