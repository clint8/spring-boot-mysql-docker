package com.example.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    private Item sampleItem;

    @BeforeEach
    void setUp() {
        sampleItem = new Item("Test Item", "Test Description");
        sampleItem.setId(1L);
    }

    @Test
    void testGetAllItems() {
        Mockito.when(itemRepository.findAll()).thenReturn(List.of(sampleItem));

        List<Item> items = itemService.getAllItems();

        Assertions.assertFalse(items.isEmpty());
        Assertions.assertEquals(1, items.size());
        Assertions.assertEquals("Test Item", items.get(0).getName());
        Mockito.verify(itemRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testSaveItem() {
        Mockito.when(itemRepository.save(Mockito.any(Item.class))).thenReturn(sampleItem);

        Item savedItem = itemService.saveItem(new Item("Test Item", "Test Description"));

        Assertions.assertNotNull(savedItem);
        Assertions.assertEquals("Test Item", savedItem.getName());
        Mockito.verify(itemRepository, Mockito.times(1)).save(Mockito.any(Item.class));
    }
}
