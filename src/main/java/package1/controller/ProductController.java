package package1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import package1.entity.Product;
import package1.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	//POST Controller for single product
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	//POST Controller for products
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}
	
	//GET Api for all products fetching
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return service.getProducts();
	}
	
	//GET Api for fetching product using id
	@GetMapping("/product/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
		}
	
	//GET Api for fetching product using name
	@GetMapping("/productByName/{name}")
	public Product findProductByName(@PathVariable String name) {
		return service.getProductByName(name);
		}
	
	//PUT Api for updation of existing fields
	@PutMapping("/productUpdate")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
		}
	
	//Delete Api for deleting an existing record
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
		}
	
}