import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;



public class BasicTest extends UnitTest
{
  
  @BeforeClass
  public static void loadDB()
  {
    Fixtures.deleteAllModels();
  }
  
  @Test
  public void aVeryImportantThingToTest()
  {
    assertEquals(2, 1 + 1);
  }

  @Test
  public void testCreateUser()
  {
    User bob = new User("bob", "jones", "bob@jones.com", "secret", 20, "irish");
    bob.save();

    User testUser = User.findByEmail("bob@jones.com");
    assertNotNull (testUser);
  }
  
  @Test
  public void testCreateMessage()
  {
    User mary = new User("mary", "colllins",  "mary@collins.com", "secret", 20, "irish");
    mary.save();

    User joan = new User("joan", "colllins", "joan@collins.com", "secret", 20, "irish");
    joan.save();

    Message msg = new Message (mary, joan, "Hi there - how are you");
    msg.save();
    
    List<Message> joansMessages = Message.find("byTo", joan).fetch();
    assertEquals (joansMessages.size(), 1);
    
    Message message = joansMessages.get(0);
    assertEquals(message.messageText, "Hi there - how are you");
  }
  
  @Test
  public void testNoMessagese()
  {
    User mary = new User("mary", "colllins", "mary@collins.com", "secret", 20, "irish");
    mary.save();

    List<Message> joansMessages = Message.find("byTo", mary).fetch();
    assertEquals (joansMessages.size(), 0);
  }

  @Test
  public void testMultipleMessages()
  {
    User mary = new User("mary", "colllins",  "mary@collins.com", "secret", 20, "irish");
    mary.save();

    User joan = new User("joan", "colllins", "joan@collins.com", "secret", 20, "irish");
    joan.save();

    Message msg1 = new Message (mary, joan, "Hi there - how are you");
    msg1.save();
    Message msg2 = new Message (mary, joan, "Where are you now?");
    msg2.save();

    List<Message> joansMessages = Message.find("byTo", joan).fetch();
    assertEquals (joansMessages.size(), 2);
    Message message1 = joansMessages.get(0);
    assertEquals(message1.messageText, "Hi there - how are you");
    Message message2 = joansMessages.get(1);
    assertEquals(message2.messageText, "Where are you now?");   
  }
}
