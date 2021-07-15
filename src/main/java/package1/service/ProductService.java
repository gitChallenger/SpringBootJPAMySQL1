package package1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import package1.entity.Product;
import package1.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//POST (Save an individual product)
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	//POST (Save multiple product)
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	//Get all products
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	//Get products by Id
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null); //orElse is must
	}
	
	//Get products by Name (Create custom method in ProductREpository since jpaRepository has only Primary key get function.
	public Product getProductByName(String name) {
		return repository.findByName(name);   //"findBy" prefix + <nameOfTheField> to create custom get method.
	}
	 
	//Delete by Id
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product Deleted: "+id;
	}
	
	//PUT(update an existing product fields)
	//We don't have build in method for PUT, we have to use POST save() method of JpaRepository.
	public Product updateProduct(Product product) {
		Product existingProduct =repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
}
