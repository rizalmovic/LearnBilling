import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Item Test Suite")
class ItemTest {
    private Item item;

    @BeforeEach
    void setUp() {
        this.item = new Item("Rinso", 2, Item.Type.ELECTRONIC, 35000);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Item name should be accessible & mutable")
    void getItemName() {
        this.item.setName("B29"); // Mutate
        assertEquals(this.item.getName(), "B29"); // Confirmed item name is accessible & match
    }

    @Test
    @DisplayName("Item type should be accessible & mutable")
    void getItemType() {
        this.item.setType(Item.Type.GROCERY);
        assertEquals(this.item.getType(), Item.Type.GROCERY);
    }

    @Test
    @DisplayName("Item quantity, price & total should be accessible. Total should be calculated correctly")
    void getTotalAmount() {
        assertEquals(this.item.getTotal(), 70000);
    }
}
