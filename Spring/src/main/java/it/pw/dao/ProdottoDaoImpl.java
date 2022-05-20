package it.pw.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import it.pw.model.Prodotto;

@Repository
public class ProdottoDaoImpl implements ProdottoDao {

	@Autowired
	private JdbcTemplate template;
	

	
	@Override
	public List<Prodotto> vediTutti() {
		String sql = "SELECT * from prodotti";
		return template.query(sql, prodottoMapper);
	}
	
	private RowMapper<Prodotto> prodottoMapper = (resultSet, rowNum)
			->
	{
		Prodotto p = new Prodotto();
		p.setId_prodotto(resultSet.getInt("id_prodotto"));
		p.setNome(resultSet.getString("nome"));
		p.setDescrizione(resultSet.getString("descrizione"));
		p.setPrezzo(resultSet.getDouble("prezzo"));
		return p;
	};



	@Override
	public void create(Prodotto p) {
		String sql = "INSERT INTO prodotti(nome,descrizione,prezzo VALUES(?,?,?)";
		template.update(sql, p.getNome(),p.getDescrizione(),p.getPrezzo());
	}

	@Override
	public void update(Prodotto p) {
		String sql = "UPDATE prodotti SET nome=?,descrizione=?,prezzo=? WHERE id = ?";
		template.update(sql, p.getNome(),p.getDescrizione(),p.getPrezzo());
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM prodotti WHERE id=?";
		template.update(sql,id);
		
	}

	@Override
	public Prodotto getProdottoById(int id) {
		String sql = "SELECT * FROM prodotti WHERE id_prodotto=?";
		return template.queryForObject(sql,prodottoMapper,id);
	}
	
}
