package webbangiaydabong.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import webbangiaydabong.dto.OrderDTO;
import webbangiaydabong.dto.ProductDTO;
import webbangiaydabong.entity.Brand;
import webbangiaydabong.entity.Category;
import webbangiaydabong.entity.Product;
import webbangiaydabong.repository.ProductRepository;
import webbangiaydabong.service.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class ProductServiceImpl implements ProductService {
	@PersistenceContext
	EntityManager manager;
	@Autowired
	ProductRepository productRepo;

	@Override
	public List<Product> findAll() {
		return productRepo.findByStatus();
	}

	@Override
	public List<Product> findByCategoryId(String categoryId) {
		return productRepo.finByCategoryId(categoryId);
	}

	@Override
	public Product findById(Long id) {
		return productRepo.findById(id).get();
	}

	@Override
	public Product create(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product update(Product product) {
		return productRepo.save(product);
	}

	@Override
	public void delete(Long id) {
		productRepo.deleteById(id);
	}

	@Override
	public Page<Product> findByKey(Pageable pageable, String name,Long id,  Double outputprice, Category category, Brand hang) {
		return productRepo.findByKey(pageable, name,id,outputprice, category, hang);
	}

	@Override
	public List<Product> findByStatus() {
		return productRepo.findByStatus();
	}

	@Override
	public List<Product> findTop(Date date) {
		return productRepo.findTop(date);
	}

	@Override
	public List<ProductDTO> serchName(ProductDTO dto) {
		String sql="select new webbangiaydabong.dto.ProductDTO(o) from Product o ";
		String whereClause = "where (1=1)";
		if(dto.getName().trim()!=null){
			whereClause+=" AND o.name like :name ";

		}
		sql+=whereClause;
		Query q = manager.createQuery(sql, ProductDTO.class);
	if(dto.getName()!=null){
		q.setParameter("name",'%'+dto.getName().trim()+'%');
	}
	List<ProductDTO>lstProductDTOS=q.getResultList();
		return lstProductDTOS;
	}
}
