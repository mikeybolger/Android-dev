package models;
/**
* @file    LeaderBoard.java
* @brief   Class publishes users graded most socially and talkatively active
* @version June 10 2014
* @author  
*/

import java.util.ArrayList;
import java.util.Collections;
import utils.UserSocialComparator;
import utils.UserTalkativeComparator;
import utils.UserLeastTalkativeComparator;
import views.LeaderBoardView;


public class LeaderBoard
{
  public static void index(ArrayList<User> users)
  {

    Collections.sort(users, new UserSocialComparator());
    LeaderBoardView.index(users);
  }
  
  public static void talkative(ArrayList<User> users)
  { 
    Collections.sort(users, new UserTalkativeComparator());
    LeaderBoardView.talkative(users);
  }
  public static void leastTalkative(ArrayList<User> users)
  {
    Collections.sort(users, new UserLeastTalkativeComparator());
    LeaderBoardView.leastTalkative(users);
  }
}
