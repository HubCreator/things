package thigns.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class NotionServiceTest {
    @Autowired
    private NotionService notionService;
    
    @Test
    @DisplayName("api 연동 테스트")
    void addItemTest() {
        //given
        String result = notionService.addItem("hello there");
        
        //when
        System.out.println("result = " + result);
        
        
        //then
        
    }
    
}
