package guru.springfamework.service;

import java.util.List;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;

public interface CategoryService {

	List<CategoryDTO> getAllCategories();
	CategoryDTO getCateryByName(String name);

}
