package com.blogPessoal.CRUDBlogPessoal.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blogPessoal.CRUDBlogPessoal.Model.ModelPostagem;


    
	@Repository
	public interface RepositoryPostagem extends JpaRepository<ModelPostagem, Long> {
    public List <ModelPostagem> findAllByTituloContainingIgnoreCase(String titulo);	
	}
		
	

