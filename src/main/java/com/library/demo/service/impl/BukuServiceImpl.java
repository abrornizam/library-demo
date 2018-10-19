package com.library.demo.service.impl;

/**
 * @author ANIZAM
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.demo.model.Buku;
import com.library.demo.repository.BukuRepository;
import com.library.demo.service.BukuService;

@Service
@Transactional
public class BukuServiceImpl implements BukuService {
	
	private BukuRepository bukuRepository;
	
	@Autowired
	public void setBukuRepository(BukuRepository bukuRepository) {
		// TODO Auto-generated method stub
		this.bukuRepository = bukuRepository;
	}
	
	@Override
	public Buku saveBuku(Buku buku) {
		// TODO Auto-generated method stub
		buku.setKdbuku("BOOK"+buku.getId());
		buku.setStatus(true);		
		return bukuRepository.save(buku);
	}

	@Override
	public void updateBuku(String kdbuku) {
		// TODO Auto-generated method stub
		Buku entity = bukuRepository.findByKdbuku(kdbuku);
		if(entity != null) {
			entity.setKdbuku(entity.getKdbuku());
			entity.setJudul(entity.getJudul());
			entity.setDeskripsi(entity.getDeskripsi());
			entity.setTahun(entity.getTahun());
			entity.setJumlah(entity.getJumlah());
			entity.setPengarang(entity.getPengarang());
			entity.setStatus(true);
		}
	}

	@Override
	public void deleteBuku(String kdbuku) {
		// TODO Auto-generated method stub
		Buku entity = bukuRepository.findByKdbuku(kdbuku);
		if(entity != null) {
			entity.setStatus(false);
		}
	}

//	@Override
//	public Buku findById(int id) {
//		// TODO Auto-generated method stub
//		return bukuRepository.findById(id);
//	}

	@Override
	public List<Buku> findAll() {
		// TODO Auto-generated method stub
		return bukuRepository.findAll();
	}

	@Override
	public Buku findByKode(String kdbuku) {
		// TODO Auto-generated method stub
		return bukuRepository.findByKdbuku(kdbuku);
	}

	@Override
	public void updateJumlahBuku(String kdbuku, int jumlah) {
		// TODO Auto-generated method stub
		Buku buku = bukuRepository.findByKdbuku(kdbuku);
		buku.setJumlah(jumlah);
	}

	@Override
	public Buku findByTahun(String tahun) {
		// TODO Auto-generated method stub
		return bukuRepository.findByTahun(tahun);
	}
	
}
