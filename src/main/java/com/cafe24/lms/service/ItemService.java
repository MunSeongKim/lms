package com.cafe24.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.lms.domain.Category;
import com.cafe24.lms.domain.Item;
import com.cafe24.lms.repository.CategoryRepository;
import com.cafe24.lms.repository.ItemRepository;

@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository; 
    
    public boolean saveItem(Item item, Long categoryNo){
	Category category = categoryRepository.findOne(categoryNo);
	item.setCategory( category );
	return (itemRepository.save( item ) != null);
    }
    
    public Page<Item> getItemList(Pageable pageable) {
	return itemRepository.findAll(pageable);
    }
    
    public boolean rentItem(Long no) {
	return (itemRepository.update(no) == 1);
    }
    
    public void remove(){
	itemRepository.deleteAll();
    }

    public Item getItem( Long itemNo ) {
	return itemRepository.findByNo(itemNo);
    }

}
