package com.abror.demo.repository;

/**
 * @author ANIZAM
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abror.demo.model.Peminjaman;

@Repository
public interface PeminjamanRepository extends JpaRepository<Peminjaman, String>{

	Peminjaman findByKdpeminjaman(String kdpeminjaman);

	//	Peminjaman findByBuku(String kdbuku);
}